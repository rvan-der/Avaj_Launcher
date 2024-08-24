package fr.rvander.avaj_launcher.aircrafts;

import fr.rvander.avaj_launcher.*;
import fr.rvander.avaj_launcher.aircrafts.*;


public class Helicopter extends Aircraft {


    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        this.type = "Helicopter";
    }


    public void updateConditions() {

        String weather = this.weatherTower.getWeather(this.coordinates);
        String comesFrom = this.coordinates.description();

        if (this.coordinates.getHeight() == 0 && !weather.equals("SUN")) {
            this.land("[" + this.description()
                    + "] : Weather doesn't allow takeoff. Abort for today ! "
                    + this.coordinates.description());
            return;
        }

        String msg = "[" + this.description() + "] : ";

        switch (weather) {
            case "SUN":
                msg += "Wow... such bright ! ";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                msg += "I'm laughing at clouds. So dark up above. ";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":
                msg += "It's as thick as stew. ";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                msg += "Christmas already ? Let's build a snowman ! ";
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                break;
            default:
                msg += "What the heck !? Are we still on earth ?? ";
                break;
        }

        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() <= 0)
            this.coordinates.setHeight(0);

        String goesTo = this.coordinates.description();
        msg += comesFrom + "->" + goesTo;
        System.out.println(msg);

        if (this.coordinates.getHeight() == 0)
            this.land("[" + this.description() + "] : Landing, clear the platform !");
    }
}