package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;

public class ExitCommand implements ExecutableCommand {

    /**
     * This method contains logic for "exit" command. Here the program exits from app.
     * @param command command with arguments from the console
     */
    @Override
    public void execute(String[] command) {
        System.exit(0);
    }

    /**
     * This method validates an arguments for "exit" command
     * @param command command with arguments from the console
     * @return returns true if arguments was entered correctly and false if it was entered incorrectly
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==1){
            return true;
        }else{
            System.out.println("\u001B[31m" + "У команды exit нет аргументов!" + "\u001B[0m");
            return false;
        }
    }
}
