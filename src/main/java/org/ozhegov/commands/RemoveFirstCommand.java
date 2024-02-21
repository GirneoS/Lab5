package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.MainCollection;
import org.ozhegov.basics.Dragon;

public class RemoveFirstCommand implements ExecutableCommand {

    /**
     * This method adds "remove_first" command. Here the program removes the first element in the main PriorityQueue.
     * @param command command with arguments from the console.
     */
    @Override
    public void execute(String[] command) {
            if(MainCollection.getQueue().isEmpty()){
                System.out.println("\u001B[31m" + "Нельзя выполнить \"remove_first\", т. к. коллекция пустая!" + "\u001B[0m");
            }else {
                MainCollection.getQueue().remove();
                HistoryCommand.UpdateHistory("remove_first");
            }
    }

    /**
     * This method validates an arguments for "remove_first" command.
     * @param command command with arguments from the console
     * @return returns true if user not entered arguments and false if he entered some.
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==1){
            return true;
        }else{
            System.out.println("\u001B[31m" + "У команды \"remove_first\" нет аргументов!" + "\u001B[0m");
            return false;
        }
    }
}
