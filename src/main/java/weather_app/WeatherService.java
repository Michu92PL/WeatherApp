package weather_app;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class WeatherService {

    private String finalUrl;

    //kawalek adresu do apixu "http://api.apixu.com/v1/current.json"
    //key to nasz klucz do api
    public WeatherService(String url, String key) {
        finalUrl = url + "?key=" + key;
    }

    //tej metodzie podajemy miasto, i to miasto doklejamy do finalnego adresu url dodając -q i city (bo taki adres do apixu jest potrzebny)
    public Weather getCityWeather(String city) {
        Weather weather = new Weather();
        String url = finalUrl + "&q=" + city;
        //do tego obiektu wczytujemy dane ktore sa w formacie Json
        JSONObject jsonObject = null;
        try {
            //do kontruktora JsonObiejc przekaczuemy 1 parametr, IOUltils, zwraca toStringa z obiektu URL i jego kodowanie
            //(zeby w tym kodowaniu odebrać dane). Json obiect oczekuje od nas Stringa. IOUtils wchodzi na ten adres URL,
            //pobiera te dane i przekształca je na stringa, po to zeby to wszystko moglo trafic do obiektu JsonObject
            jsonObject = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //dobieramy sie do obiektu Location w Jsonie, i potem do imie (bo tam jest nazwa miasta), toStringujemy to, i tak reszte tez

        weather.setCity(jsonObject.getJSONObject("location").get("name").toString());
        weather.setIconUrl(jsonObject.getJSONObject("current").getJSONObject("condition").get("icon").toString());
        weather.setTemperature((Double) jsonObject.getJSONObject("current").get("temp_c"));
        weather.setFeelslikeC((Double) jsonObject.getJSONObject("current").get("feelslike_c"));
        weather.setConditionText(jsonObject.getJSONObject("current").getJSONObject("condition").get("text").toString());
        weather.setLat((Double) jsonObject.getJSONObject("location").get("lat"));
        weather.setLon((Double) jsonObject.getJSONObject("location").get("lon"));
        //System.out.println(weather);

        return weather;
    }

}
