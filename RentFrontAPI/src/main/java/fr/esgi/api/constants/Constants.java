package fr.esgi.api.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Constants {
    public static final String FRONT_API_URI;
    public static final String RENTAL_PROPERTIES_URI;
    public static final String RENTAL_CARS_URI;
    public static final String PROPERTIES_URI_TARGET;
    public static final String CARS_URI_TARGET;
    public static final int CARS_API_PORT;
    public static final int PROPERTIES_API_PORT;
    public static final int FRONT_PORT;
    public static final String HOST;
    public static final String BASE_CARS_API_URI;
    public static final String BASE_PROPERTIES_API_URI;
    public static final String BASE_FRONT_URI;
    public static final String AUTH_TOKEN;

    static {
        Properties config = new Properties();
        try (InputStream input = Constants.class.getClassLoader().getResourceAsStream("config.properties")) {
            config.load(input);
        } catch (IOException e) {
            try {
                throw new IOException(e.getMessage(), e);
            } catch (IOException ex) {
                throw new RuntimeException(ex.getMessage(), e);
            }
        }

        FRONT_API_URI = config.getProperty("front.api.uri");
        RENTAL_PROPERTIES_URI = config.getProperty("rental.properties.uri");
        RENTAL_CARS_URI = config.getProperty("rental.cars.uri");
        PROPERTIES_URI_TARGET = config.getProperty("properties.uri.target");
        CARS_URI_TARGET = config.getProperty("cars.uri.target");
        CARS_API_PORT = Integer.parseInt(config.getProperty("cars.api.port"));
        PROPERTIES_API_PORT = Integer.parseInt(config.getProperty("properties.api.port"));
        FRONT_PORT = Integer.parseInt(config.getProperty("front.port"));
        HOST = config.getProperty("host");
        BASE_CARS_API_URI = HOST + CARS_API_PORT + "/";
        BASE_PROPERTIES_API_URI = HOST + PROPERTIES_API_PORT + "/";
        BASE_FRONT_URI = HOST + FRONT_PORT + "/" + FRONT_API_URI;
        AUTH_TOKEN = config.getProperty("auth.token");
    }

    private Constants() {
    }
}
