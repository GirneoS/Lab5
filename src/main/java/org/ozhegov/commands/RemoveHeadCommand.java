package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.MainCollection;
import org.ozhegov.basics.Dragon;

public class RemoveHeadCommand implements ExecutableCommand {
    /**
     * This method contains the logic for "remove_head" command. Here the program prints first element in the PriorityQueue and delete it.
     * @param command command with arguments from the console.
     */
    @Override
    public void execute(String[] command) {
            if(MainCollection.getQueue().isEmpty()){
                System.out.println("\u001B[31m" + "Нельзя выполнить \"remove_head\", т. к. коллекция пустая!" + "\u001B[0m");
            }else {
                System.out.println(MainCollection.getQueue().poll());
                HistoryCommand.UpdateHistory("remove_head");
            }
    }
    /**
     * This method validates an arguments for "remove_head" command.
     * @param command command with arguments from the console
     * @return returns true if user not entered arguments and false if he entered some.
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==1){
            return true;
        }else{
            System.out.println("\u001B[31m" + "У команды нет аргументов!" + "\u001B[0m");
            return false;
        }
    }
}
