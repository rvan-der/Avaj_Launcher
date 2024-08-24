package fr.rvander.avaj_launcher.parsing;

import fr.rvander.avaj_launcher.parsing.*;
import java.util.ArrayList;


public class Scenario {

    public int nbIterations = 0;
    public ArrayList<FlyableInput> flyables = null;


    public void addFlyable(FlyableInput p_flyable) {
        if (this.flyables == null) {
            this.flyables = new ArrayList<FlyableInput>();
        }
        this.flyables.add(p_flyable);
    }
}