package org.ozhegov;

/**
 * This interface makes the class possible to use in the app as a command.
 */
public interface ExecutableCommand {
    /**
     * This method contains the logic of command execution
     * @param command command with arguments from the console
     */
    public void execute(String[] command);

    /**
     * This method validates a command from the console
     * @param command command with arguments from the console
     * @return returns true if command was entered correctly and false if it was entered incorrectly
     */
    public boolean validate(String[] command);
}
