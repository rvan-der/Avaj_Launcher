package fr.rvander.avaj_launcher;


public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;


    public Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }


    public int getLongitude() {
        return this.longitude;
    }


    public int setLongitude(int p_longitude) {
        return this.longitude = p_longitude;
    }


    public int getLatitude() {
        return this.latitude;
    }


    public int setLatitude(int p_latitude) {
        return this.latitude = p_latitude;
    }


    public int getHeight() {
        return this.height;
    }


    public int setHeight(int p_height) {
        return this.height = p_height;
    }


    public String description() {
        return "(" + this.longitude + "," + this.latitude + "," + this.height + ")";
    }
}