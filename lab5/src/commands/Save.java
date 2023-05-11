package commands;

import utils.FileDespatcher;

import java.io.BufferedReader;
import java.util.List;

import utils.Parser;
import utils.PersonList;
import utils.PersonStorage;

/**
 * class command for save collection in file
 */
public class Save implements Command {
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

        FileDespatcher.writeInFile(System.getenv("LAB5_JSON"), Parser.personsToJson(new PersonList(PersonStorage.getPersons())));
        System.out.println("----- The collection is saved -----");

    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "save    Save collection in file";
    }
}
