package fr.rvander.avaj_launcher;

import fr.rvander.avaj_launcher.*;
import fr.rvander.avaj_launcher.parsing.*;
import fr.rvander.avaj_launcher.weather.*;
import fr.rvander.avaj_launcher.aircrafts.*;


public class AvajLauncher {


    public static void main(String args[]){

        if (args.length < 1) {
            System.out.println("ERROR: [Missing scenario file as argument.]");
            return;
        }
        if (args.length > 1) {
            System.out.println("ERROR: [Too many arguments. Only one file is required.]");
            return;
        }

        Scenario scenario;
        try {
            scenario = (new ScenarioReader(args[0])).readScenario();
        }
        catch (Exception excp) {
            System.out.println("ERROR: [" + excp.getMessage() + "]");
            return;
        }

        WeatherTower wTower = new WeatherTower();
        AircraftFactory acFactory = AircraftFactory.getFactory();

        for (FlyableInput fIntput : scenario.flyables) {
            acFactory.newAircraft(fIntput.type, fIntput.name, fIntput.coordinates)
                    .registerTower(wTower);
        }

        for (int i = 0; i < scenario.nbIterations; i++) {
            wTower.changeWeather();
        }
    }
}