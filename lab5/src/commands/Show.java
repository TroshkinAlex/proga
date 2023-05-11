package commands;

import models.Person;

import java.io.BufferedReader;
import java.util.List;

import static utils.PersonStorage.*;

/**
 * class-command witch show info about all people
 */
public class Show implements Command {
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
            System.err.println("Incorrect command");
            return;
        }

        for (Person person : getPersons()) {
            System.out.println(person.toString() + "\n----------\n");
        }
    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "show    Information about all persons";
    }
}
