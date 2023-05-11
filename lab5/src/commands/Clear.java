package commands;

import java.io.BufferedReader;
import java.util.List;

import static utils.PersonStorage.*;

/**
 * class-command clear person collection
 */
public class Clear implements Command {
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

        clearPeople();
        System.out.println("----- Collection cleared -----");
    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "clear   Delete all persons from collection";
    }
}
