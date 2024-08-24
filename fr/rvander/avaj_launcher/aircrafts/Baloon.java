package fr.rvander.avaj_launcher.aircrafts;

import fr.rvander.avaj_launcher.*;
import fr.rvander.avaj_launcher.aircrafts.*;


public class Baloon extends Aircraft {


    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        this.type = "Baloon";
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
                msg += "What's this big hot flaming discoball above our heads !? ";
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                break;
            case "RAIN":
                msg += "Too much water, we're sinking ! ";
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                break;
            case "FOG":
                msg += "Can't see a thing....lost......best go down... ";
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                break;
            case "SNOW":
                msg += "Mayday, mayday ! We're in a snow storm. Losing altitude fast !! ";
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
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
            this.land("[" + this.description() + "] : Landing, prepare the dock !");
    }
}