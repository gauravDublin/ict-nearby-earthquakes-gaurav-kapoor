package info.earthquake.helper;

import info.earthquake.domain.EarthQuakeInfoResponse;
import info.earthquake.domain.EarthquakePoint;
import info.earthquake.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class USGCService {

    private final ConsoleService consoleService;

    private final RestTemplate restTemplate;

    private String restUrl = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson";

    @Autowired
    public USGCService(ConsoleService consoleService, RestTemplate restTemplate) {
        this.consoleService = consoleService;
        this.restTemplate = restTemplate;
    }

    public void calculateNearestEarthquakes() {
        consoleService.printWelcomeMessage();
        Double longitude = consoleService.isDoubleEntered();
        Double latitude = consoleService.isDoubleEntered();
        consoleService.printWaitingMessage();
        Location source = new Location(longitude, latitude);
        List<EarthquakePoint> pointList = new ArrayList<>();

        EarthQuakeInfoResponse earthQuakeInfoResponse = restTemplate.getForObject(restUrl, EarthQuakeInfoResponse.class);

        earthQuakeInfoResponse.getFeatures().forEach(feature -> {
            String title = feature.getFeature().getProperties().getTitle();
            Double lo = feature.getFeature().getGeometry().getCoordinates().get(0);
            Double la = feature.getFeature().getGeometry().getCoordinates().get(1);
            Location eqPoint = new Location(lo, la);
            EarthquakePoint point = new EarthquakePoint(title, eqPoint, source);
            pointList.add(point);
        });

        Map<EarthquakePoint, Double> distanceMapSorted = sortByDistance(source, pointList);
        printTop10Results(distanceMapSorted);
    }

    private Map<EarthquakePoint, Double> sortByDistance(Location source, List<EarthquakePoint> pointList) {
        Map<EarthquakePoint, Double> distanceMapUnsorted = pointList.stream()
                                                            .collect(Collectors.toMap(Function.identity(),
                                                                point -> DistanceCalculator.calculateDistance(
                                                                        source, point.getSource())));
        return distanceMapUnsorted.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private void printTop10Results(Map<EarthquakePoint, Double> distanceMapSorted) {
        List<String> resultSet = new LinkedList<>();
        List<String> top10NearestEarthquakes = distanceMapSorted.entrySet().stream().limit(10)
                .map(point -> point.getKey().getTitle() + " || " + Math.round(point.getValue()*100)/100)
                .collect(Collectors.toList());
        top10NearestEarthquakes.stream().forEach(earthquake -> System.out.println(earthquake));
    }

}
