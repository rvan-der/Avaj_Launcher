package fr.rvander.avaj_launcher.aircrafts;

import fr.rvander.avaj_launcher.*;


public class Aircraft extends Flyable {

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;


    public void updateConditions(){}


    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
        this.type = "Aircraft";
    }


    protected void land(String p_msg) {
        System.out.println(p_msg);
        this.unregisterTower();
    }


    public long getId() {
        return this.id;
    }


    public String getType() {
        return this.type;
    }


    public String getName() {
        return this.name;
    }

    public String description() {
        return this.type + "#" + this.name + "(" + this.id + ")";
    }
}