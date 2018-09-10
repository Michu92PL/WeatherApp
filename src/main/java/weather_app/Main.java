package weather_app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WeatherService weatherService = new WeatherService(

                //to jest wziete z adresu apixu http://api.apixu.com/v1/current.json?key=eeea89e848f743fbb8d155428180709&q=Warsaw
                //a adres jest wziety z https://www.apixu.com/my/

                "http://api.apixu.com/v1/current.json",
                "eeea89e848f743fbb8d155428180709"
        );

        weatherService.getCityWeather("warsaw");
        System.out.println("---------");

        List<Weather> weatherList = generateWeatherList();


        Weather weather = new Weather(
                "Toruń",
                "www",
                40,
                60,
                "Slonecznie",
                54.54,
                21.23);
        //zapis danych do pliku
        ObjectMapper objectMapper = new ObjectMapper();
        //przyjmuje obiekt file ktory przechowuje adres do pliku oraz obiekt ktory chemy zapisać
        File filename = new File("weather.json");
        File filename2 = new File("weatherList.json");
        try {

            //tworzy obiekt tekstowy .json (mozna go sformatować)
            objectMapper.writeValue(filename, weather);
            objectMapper.writeValue(filename2, weatherList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //odczytywanie  danych z pliku
        //Weather[].class// przekazujemy do obiektu objectMapper klase wzorcowa, ktora jest wzorcem dla pliku Jsonowego
        //zeby te pola Jsonowe trafily do pol klasy
        //obiect mapper chce stworzyc obiekt pogody i za pomoca setterow settowac wszystko, klasa weather musi miec pusty konstruktor
        //jesli jest tylko jeden obiekt zapisany do pliku to nie trzeba jechac forem
        try {
            Weather[] readWeather = objectMapper.readValue(filename2, Weather[].class);

            for (Weather w : readWeather) {
                System.out.println(w.getCity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Weather> generateWeatherList() {

        ArrayList<Weather> weatherList = new ArrayList<Weather>();

        Weather weather1 = new Weather(
                "Bydgoszcz",
                "www",
                40,
                60,
                "Pochmurno",
                55.59,
                20.24);

        Weather weather2 = new Weather(
                "Kolobrzeg",
                "www",
                40,
                60,
                "Slonecznie",
                10.10,
                11.23);

        Weather weather3 = new Weather(
                "Sosnowiec",
                "www",
                40,
                60,
                "Opad Radioaktywny",
                54.58,
                23.32);

        Weather weather4 = new Weather(
                "Radom",
                "www",
                40,
                60,
                "Nie wiadomo",
                53.94,
                11.44);

        Weather weather5 = new Weather(
                "Warszawa",
                "www",
                40,
                60,
                "Slonecznie",
                54.54,
                71.28);

        weatherList.add(weather1);
        weatherList.add(weather2);
        weatherList.add(weather3);
        weatherList.add(weather4);
        weatherList.add(weather5);
        return weatherList;
    }
}