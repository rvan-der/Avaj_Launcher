package fr.rvander.avaj_launcher.weather;

import fr.rvander.avaj_launcher.*;


public class WeatherProvider {

    private static WeatherProvider instance = null;
    private static String[] weather = {"RAIN", "SUN", "FOG", "SNOW"};
    private static int seed;


    private WeatherProvider() {}


    public static WeatherProvider getProvider() {
        if (instance == null) {
            instance = new WeatherProvider();
            seed = (int)(Math.random() * 10000 + 1000);
        }
        return instance;
    }


    public void changeSeed() {
        seed = (int)(Math.random() * 10000 + 1000);
    }


    public String getCurrentWeather(Coordinates coords) {
        int coordHash = (coords.getLongitude() % seed + 1) * (coords.getLatitude() % seed + 1);
        coordHash = (coordHash % seed + 1) * (coords.getHeight() % seed + 1);
        coordHash %= seed;
        double wave = Math.sin(coordHash * seed) * (this.weather.length - 1);
        return this.weather[(int)Math.round(Math.abs(wave))];
    }
}