package fr.rvander.avaj_launcher.parsing;

import fr.rvander.avaj_launcher.*;


public class FlyableInput {
    public String type;
    public String name;
    public Coordinates coordinates;


    public FlyableInput(String p_type, String p_name, Coordinates p_coordinates) {
        this.type = p_type;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }
}