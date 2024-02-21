package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.basics.Dragon;

public class ShowCommand implements ExecutableCommand {

    /**
     * This method contains the logic for "show" command. Here the program saves the collection in file "Saved Collection".
     * @param command command with arguments from the console.
     */
    @Override
    public void execute(String[] command) {
        Dragon.getQueue().forEach(System.out::println);
        HistoryCommand.UpdateHistory("show");
    }

    /**
     * This method validates an arguments for "show" command.
     * @param command command with arguments from the console
     * @return returns true if user not entered arguments and false if he entered some.
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==1){
            return true;
        }else{
            System.out.println("\u001B[31m" + "У команды \"show\" нет аргументов!" + "\u001B[0m");
            return false;
        }

    }
}
