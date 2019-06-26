package info.earthquake.service;

import info.earthquake.domain.Location;
import org.junit.Test;

import static org.junit.Assert.*;

class DistanceCalculatorTest {
    @Test
    public void smokeTest() {
        Location a1 = new Location(41.3925603, 2.1418532);
        Location a2 = new Location(41.3870194,2.1678584);

        assertEquals(2.0, DistanceCalculator.calculateDistance(a1, a2), 0.5);
    }

}