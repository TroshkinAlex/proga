package commands;

import java.io.BufferedReader;
import java.util.List;

import static utils.PersonStorage.*;

/**
 * class-command which print info about person collection
 */
public class Info implements Command {
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
            System.err.println("Error in command syntax");
            return;
        }

        System.out.println("type: person\nelements count: " + getPersons().size());
    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "info    Information about collection of persons";
    }
}
