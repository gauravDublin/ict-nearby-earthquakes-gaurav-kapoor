package info.earthquake.domain;

public class EarthquakePoint {
    private String title;
    private Location source;
    private Location cityCentre;

    public EarthquakePoint(String title, Location source, Location cityCentre) {
        this.title = title;
        this.source = source;
        this.cityCentre = cityCentre;
    }

    public String getTitle() {
        return title;
    }

    public Location getSource() {
        return source;
    }

    public Location getCityCentre() {
        return cityCentre;
    }
}
