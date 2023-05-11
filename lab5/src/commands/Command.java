package commands;

import java.io.BufferedReader;
import java.util.List;

/**
 * Command interface for construct all commands
 */
public interface Command {
    void execute();

    /**
     * @param line command from main menu
     * @param in parameter for input
     * @param manager command manager for commands menu
     */
    void execute(List<String> line, BufferedReader in, CommandManager manager);

    /**
     * @return String description for this command
     */
    String description();
}
