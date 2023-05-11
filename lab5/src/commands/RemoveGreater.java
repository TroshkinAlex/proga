package commands;

import models.Person;
import utils.PersonStorage;

import java.io.BufferedReader;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;

import static utils.PersonStorage.getPersons;

/**
 * class-command witch remove all elements with height value more than entered person
 */
public class RemoveGreater implements Command {
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
            System.err.println("Error in command");
            return;
        }

        try {
            ((TreeSet<Person>)getPersons().clone()).stream()
                    .filter(person -> person.compareTo(PersonStorage.getById(Integer.parseInt(line.get(1)))) > 0)
                    .forEach(PersonStorage::removePerson);
            System.out.println("----- Deletion completed -----");
        } catch (RuntimeException exc) {
            System.err.println("Error in removing greater people" + exc.getMessage());
        }
    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "remove_greater {element}    delete all persons with height exceeds the specified";
    }
}
