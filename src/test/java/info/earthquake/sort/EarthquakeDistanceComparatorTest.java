package info.earthquake.sort;

import info.earthquake.domain.EarthquakePoint;
import info.earthquake.domain.Location;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class EarthquakeDistanceComparatorTest {
    private EarthquakePoint one;
    private EarthquakePoint two;
    private EarthquakePoint three;
    private EarthquakePoint source;
    private final Location CITY_LOCATION = new Location(41.3965463, 2.1963997);
    private List<EarthquakePoint> ORDER_LIST = new ArrayList<>();

    @Before
    public void setUp() {
        one = new EarthquakePoint("M 5.0 - Prince Edward Islands region", new Location(40.3965463, 20.1963997), CITY_LOCATION);
        two = new EarthquakePoint("M 4.9 - Bouvet Island region", new Location(1.34463, 2.2), CITY_LOCATION);
        three = new EarthquakePoint("M 4.1 - 209km SSE of Ol'ga, Russia", new Location(11.0, 6.7), CITY_LOCATION);

        source = new EarthquakePoint("M 4.5 - 26km ESE of Pamandzi, Mayotte", CITY_LOCATION, CITY_LOCATION);

        ORDER_LIST.add(one);
        ORDER_LIST.add(two);
        ORDER_LIST.add(three);
    }

    @Test
    public void compare() {
        Collections.sort(ORDER_LIST, new EarthquakeDistanceComparator(source));
        assertTrue(ORDER_LIST.get(0) == one);
        assertTrue(ORDER_LIST.get(1) == three);
        assertTrue(ORDER_LIST.get(2) == two);

    }
}