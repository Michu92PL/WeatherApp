package weather_app;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    private static final Path propertyFile = Paths.get("application.properties");

    //chcemy zeby nasz condfing byl zapisany w pliku (zeby potem go sobie zaczytywac w pliku a nie podawac recznie)

    public static void saveConfiguration() {

        //zwykle sluzy do zapisywania propertiesow, klucz-wartosc
        Properties properties = new Properties();
        properties.setProperty("url", "http://api.apixu.com/v1/current.json");
        properties.setProperty("key", "eeea89e848f743fbb8d155428180709");

        //wlasciwosci zapisujemy za pomoca obiektu Writer
        try {
            Writer propertiesWriter = Files.newBufferedWriter(propertyFile);
            properties.store(propertiesWriter, "Application Properties");
            propertiesWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //odczytywanie danych z pliku, ta metoda ma zwracac obiekt AppProperties
    public static AppProperties loadProperties() {
        AppProperties appProperties = new AppProperties();
        try {
            Reader propertiesReader = Files.newBufferedReader(propertyFile);
            Properties properties = new Properties();
            properties.load(propertiesReader);
            appProperties.setUrl(properties.getProperty("url"));
            appProperties.setKey(properties.getProperty("key"));
            propertiesReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appProperties;
    }
}
