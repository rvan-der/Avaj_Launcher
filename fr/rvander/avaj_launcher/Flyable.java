package fr.rvander.avaj_launcher;

import fr.rvander.avaj_launcher.weather.*;


public abstract class Flyable {

    protected WeatherTower weatherTower = null;


    public abstract void updateConditions();


    public abstract String description();


    public void registerTower(WeatherTower p_tower) {
        p_tower.register(this);
        this.weatherTower = p_tower;
    }


    public void unregisterTower() {
        this.weatherTower.unregister(this);
        this.weatherTower = null;
    }
}