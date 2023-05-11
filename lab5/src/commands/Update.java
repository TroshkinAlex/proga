package commands;

import models.Color;
import models.Country;
import models.Person;
import utils.PersonStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static utils.PersonStorage.*;

/**
 * class-command for update person info
 */
public class Update implements Command {
    @Override
    public void execute() {

    }

    /**
     * @param line    command from main menu
     * @param in      parameter for input
     * @param manager command manager for commands menu
     */
    @Override
    public void execute(List<String> line, BufferedReader in, CommandManager manager) {
        if (line.size() != 2) {
            System.err.println("Error in command syntax");
            return;
        }

        try {
            Person currentPerson = PersonStorage.getById(Integer.parseInt(line.get(1)));

            System.out.println("Enter name: ");
            String name = in.readLine();
            System.out.println("Enter height" + ": ");
            long height = Long.parseLong(in.readLine());
            var coordinates = createCoordinates(in, manager);
            System.out.println("Enter eye color");
            var eyeColor = createPersonCharacteristic(in, Color.class, manager);
            System.out.println("Enter hair color");
            var hairColor = createPersonCharacteristic(in, Color.class, manager);
            var nationality = createPersonCharacteristic(in, Country.class, manager);
            var location = createLocation(in, manager);

            currentPerson.setName(name);
            currentPerson.setHeight(height);
            currentPerson.setCoordinates(coordinates);
            currentPerson.setEyeColor(eyeColor);
            currentPerson.setHairColor(hairColor);
            currentPerson.setNationality(nationality);
            currentPerson.setLocation(location);
            System.out.println("----- The person was successfully upgraded -----");
        } catch (RuntimeException | IOException exc) {
            System.err.println("Error in update person" + exc.getMessage());
        }
    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "update id   Update info about person by id";
    }
}
