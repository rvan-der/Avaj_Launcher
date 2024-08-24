package fr.rvander.avaj_launcher.weather;

import fr.rvander.avaj_launcher.*;
import fr.rvander.avaj_launcher.weather.*;


public class WeatherTower extends Tower {
    
    private WeatherProvider wProvider = null;


    public String getWeather(Coordinates p_coordinates) {
        if (wProvider == null)
            this.wProvider = WeatherProvider.getProvider();
        return this.wProvider.getCurrentWeather(p_coordinates);
    }


    public void changeWeather() {
        if (wProvider == null)
            this.wProvider = WeatherProvider.getProvider();
        else
            this.wProvider.changeSeed();
        this.conditionChanged();
    }
}