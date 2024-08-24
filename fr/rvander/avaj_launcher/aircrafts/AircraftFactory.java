package fr.rvander.avaj_launcher.aircrafts;

import fr.rvander.avaj_launcher.*;
import fr.rvander.avaj_launcher.aircrafts.*;


public class AircraftFactory {

    private static AircraftFactory instance = null;
    private static long id_counter = 1;


    private AircraftFactory() {}


    public static AircraftFactory getFactory() {
        if (instance == null)
            instance = new AircraftFactory();
        return instance;
    }


    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        long id = id_counter;
        id_counter += 1;
        return switch (p_type) {
            case "JetPlane":
                yield new JetPlane(id, p_name, p_coordinates);
            case "Helicopter":
                yield new Helicopter(id, p_name, p_coordinates);
            case "Baloon":
                yield new Baloon(id, p_name, p_coordinates);
            default:
                yield new Aircraft(id, p_name, p_coordinates);
        };
    }
}