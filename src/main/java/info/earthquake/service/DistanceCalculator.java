package info.earthquake.service;

import info.earthquake.domain.Location;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;

public class DistanceCalculator {

    private static final int EARTH_RADIUS = 6371;

    public static double calculateDistance(Location start, Location end) {
        double deltaLat = toRadians((end.getLat() - start.getLat()));
        double deltaLong = toRadians((end.getLon() - start.getLon()));

        double startLat = toRadians(start.getLat());
        double endLat = toRadians(end.getLat());

        double a = haversin(deltaLat) + cos(startLat) * cos(endLat) * haversin(deltaLong);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    private static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}
