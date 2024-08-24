package fr.rvander.avaj_launcher.parsing;

import fr.rvander.avaj_launcher.*;
import fr.rvander.avaj_launcher.parsing.*;
import java.io.*;


public class ScenarioReader {
    private String path;


    public ScenarioReader(String p_path) {
        this.path = p_path;
    }


    public Scenario readScenario() throws AvajLauncherParsingException, IOException {

        BufferedReader bReader = new BufferedReader(new FileReader(this.path));
        String line = bReader.readLine();
        if (line == null)
            throw new AvajLauncherParsingException("The scenario file is empty.");
        String type;
        String name;
        int longitude;
        int latitude;
        int height;
        Scenario scenario = new Scenario();

        try {
            scenario.nbIterations = Integer.parseInt(line);
        }
        catch (Exception excp) {
            throw new AvajLauncherParsingException(
                    "Couldn't find number of iterations in the first line. "
                    + excp.getMessage());
        }

        int lineCount = 1;
        while ((line = bReader.readLine()) != null) {
            lineCount += 1;

            if (line.equals(""))
                continue;

            String[] words = line.split(" ");
            if (words.length != 5) {
                throw new AvajLauncherParsingException("Invalid format in scenario file(:"
                    + lineCount + ").");
            }

            if (!words[0].equals("Baloon") && !words[0].equals("Helicopter") && !words[0].equals("JetPlane")) {
                throw new AvajLauncherParsingException("Wrong aircraft type in scenario file(:"
                        + lineCount + "). '" + words[0] + "'");
            }
            type = words[0];

            name = words[1];

            try {
                longitude = Integer.parseInt(words[2]);
                latitude = Integer.parseInt(words[3]);
                height = Integer.parseInt(words[4]);
            }
            catch (Exception excp) {
                throw new AvajLauncherParsingException("Invalid coordinates format in scenario file(:"
                        + lineCount + "). " + excp.getMessage());
            }

            if (longitude < 0 || latitude < 0 || height < 0 || height > 100) {
                throw new AvajLauncherParsingException("Invalid coordinates in scenario file(:"
                        + lineCount + "). <" + longitude + "," + latitude + "," + height
                        +"> Must be positive integers and height<=100.");
            }
            
            scenario.addFlyable(new FlyableInput(type, name, new Coordinates(longitude, latitude, height)));
        }

        bReader.close();

        return scenario;
    }
}