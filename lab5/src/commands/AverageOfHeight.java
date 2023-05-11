package commands;

import models.Person;

import java.io.BufferedReader;
import java.util.List;

import static utils.PersonStorage.*;

/**
 * class-command average height value
 */
public class AverageOfHeight implements Command {
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

        float averageValue = (float) 0;
        for (Person person : getPersons()) averageValue += person.getHeight();
        averageValue /= getPersons().size();
        System.out.println("Average height = " + averageValue);
    }

    /**
     * @return this command description
     */
    @Override
    public String description() {
        return "average_of_height   Display the average value of the height";
    }
}
