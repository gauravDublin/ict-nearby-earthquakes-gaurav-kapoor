package info.earthquake.service;

import info.earthquake.domain.EarthQuakeInfoResponse;
import info.earthquake.domain.EarthquakePoint;
import info.earthquake.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

@Service
public class USGCService {

    private final ConsoleService consoleService;

    private final EarthQuakeInfoResponse earthQuakeInfoResponse;

    @Autowired
    public USGCService(ConsoleService consoleService, EarthQuakeInfoResponse earthQuakeInfoResponse) {
        this.consoleService = consoleService;
        this.earthQuakeInfoResponse = earthQuakeInfoResponse;
    }

    public void calculateNearestEarthquakes() {
        consoleService.printWelcomeMessage();
        Double longitude = consoleService.isDoubleEntered();
        Double latitude = consoleService.isDoubleEntered();
        consoleService.printWaitingMessage();
        Location source = new Location(longitude, latitude);
        List<EarthquakePoint> pointList = new ArrayList<>();

        saveLocationDataToList(source, pointList, earthQuakeInfoResponse);
        Map<Double, EarthquakePoint> distanceMapSorted = sortLocationsByIncreasingDistance(source, pointList);
        consolePrintTop10Results(distanceMapSorted);
    }

    private void saveLocationDataToList(Location source, List<EarthquakePoint> pointList, EarthQuakeInfoResponse earthQuakeInfoResponse) {
        earthQuakeInfoResponse.getFeatures().forEach(feature -> {
            String title = feature.getFeature().getProperties().getTitle();
            Double lo = feature.getFeature().getGeometry().getCoordinates().get(0);
            Double la = feature.getFeature().getGeometry().getCoordinates().get(1);
            Location eqPoint = new Location(lo, la);
            EarthquakePoint point = new EarthquakePoint(title, eqPoint, source);
            pointList.add(point);
        });
    }

    private Map<Double, EarthquakePoint> sortLocationsByIncreasingDistance(Location source, List<EarthquakePoint> pointList) {
        Map<Double, EarthquakePoint> distanceMapUnsorted = pointList.stream()
                .parallel()
                .collect(Collectors.toMap(point -> DistanceCalculator.calculateDistance(
                        source, point.getSource()), Function.identity(), (a1, a2) -> a1
                ));
        return distanceMapUnsorted.entrySet().stream()
                .sorted(comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private void consolePrintTop10Results(Map<Double, EarthquakePoint> distanceMapSorted) {
        List<String> top10NearestEarthquakes = distanceMapSorted.entrySet().stream().limit(10)
                .map(point -> point.getValue().getTitle() + " || " + Math.round(point.getKey() * 100) / 100)
                .collect(Collectors.toList());
        consoleService.printDashLine();
        consoleService.printTop10();
        top10NearestEarthquakes.stream().forEach(System.out::println);
    }

}
