package weather_app;

public class Weather {

    private String city;
    private String iconUrl;
    private double temperature;
    private double feelslikeC;
    private String conditionText;
    private double lat; //wysokosc geograficzna
    private double lon; //szerokosc geograficzna

    public Weather() {
    }

    public Weather(String city, String iconUrl, double temperature, double feelslikeC, String conditionText, double lat, double lon) {
        this.city = city;
        this.iconUrl = iconUrl;
        this.temperature = temperature;
        this.feelslikeC = feelslikeC;
        this.conditionText = conditionText;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public String getConditionText() {
        return conditionText;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", temperature=" + temperature +
                ", feelslikeC=" + feelslikeC +
                ", conditionText='" + conditionText + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
