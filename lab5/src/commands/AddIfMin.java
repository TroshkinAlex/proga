package commands;

import models.*;

import java.io.BufferedReader;
import java.util.List;

import static utils.PersonStorage.*;

/**
 * class command app person if his height is min
 */
public class AddIfMin implements Command {
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
        if (line.size() != 1) {
            System.err.println("Error in command");
            return;
        }

        try {
            Person newPerson;
            var name = createName(in, manager);
            long height = createHeight(in, manager);
            if (height >= getPersons().first().getHeight() || getPersons().isEmpty()) {
                System.out.println("Person height is not max, creation stop.");
                return;
            }
            Coordinates coordinates = createCoordinates(in, manager);
            System.out.println("Enter eye color");
            var eyeColor = createPersonCharacteristic(in, Color.class, manager);
            System.out.println("Enter hair color");
            var hairColor = createPersonCharacteristic(in, Color.class, manager);
            var nationality = createPersonCharacteristic(in, Country.class, manager);
            Location location = createLocation(in, manager);

            newPerson = new Person(name, coordinates, height, eyeColor, hairColor, nationality, location);
            getPersons().add(newPerson);
            System.out.println("----- Man added to the collection -----");
        } catch (RuntimeException exc) {
            System.err.println("Error in creating person\nproblem: " + exc.getMessage());
            if (manager.isFromFile) {
                manager.shouldExit = true;
            }
        }
    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "add_if_min {element}    Add new person in collection if person's height is smallest";
    }
}
