package fr.rvander.avaj_launcher;

import fr.rvander.avaj_launcher.*;
import java.util.ArrayList;


public class Tower {

    private ArrayList<Flyable> observers = null;


    public void register(Flyable p_flyable) {
        if (this.observers == null)
            this.observers = new ArrayList<Flyable>();
        System.out.println("Tower : " + p_flyable.description()
                + " registered to weather tower. God speed.");
        this.observers.add(p_flyable);
    }


    public void unregister(Flyable p_flyable) {
        System.out.println("Tower : " + p_flyable.description()
                + " unregistered from weather tower.");
        this.observers.remove(p_flyable);
        if (this.observers.size() == 0)
            this.observers = null;
    }


    protected void conditionChanged() {
        if (this.observers == null) {
            System.out.println("Tower : There's nobody to notify anymore...");
            return;
        }
        ArrayList<Flyable> observersCopy = new ArrayList<Flyable>(this.observers);
        for (Flyable observer : observersCopy) {
            observer.updateConditions();
        }
    }


    public ArrayList<Flyable> getObservers() {
        return this.observers;
    }
}