package commands;

import utils.PersonStorage;

import java.io.BufferedReader;
import java.util.List;
import java.util.UUID;

import static utils.PersonStorage.*;

/**
 * class-command which remove person with entered id
 */
public class RemoveById implements Command {
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
            getPersons().stream()
                    .filter(person -> person.getId().equals(Integer.parseInt(line.get(1))))
                    .findFirst().ifPresent(PersonStorage::removePerson);
            System.out.println("----- Deletion completed -----");
        } catch (RuntimeException exc) {
            System.err.println("Error in finding person" + exc.getMessage());
        }
    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "remove_by_id    Delete person from collection by id";
    }
}
