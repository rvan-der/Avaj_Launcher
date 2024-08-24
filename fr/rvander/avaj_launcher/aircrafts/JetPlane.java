package fr.rvander.avaj_launcher.aircrafts;

import fr.rvander.avaj_launcher.*;
import fr.rvander.avaj_launcher.aircrafts.*;


public class JetPlane extends Aircraft {


    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
        this.type = "JetPlane";
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
                msg += "Vamos a la playa ! ";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                msg += "C'est la fête à la grenouille. ";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG":
                msg += "Quelle purée de pois ! ";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                msg += "Is it a bird... is it a plane ? No, it's Santa ! ";
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
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
            this.land("[" + this.description() + "] : Landing, liberate the strip !");
    }
}