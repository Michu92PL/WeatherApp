package weather_app;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {
    private String url;
    private String key;
    private String finalUrl;

    public WeatherService(String url, String key) {
        this.url = url;
        this.key = key;
        finalUrl = url + "?key" + key;
    }

    public Weather getCityWeather(String city){
        Weather weather = new Weather();
        String url = finalUrl + "&q=" + city;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject.toString());

        return weather;
    }
}
