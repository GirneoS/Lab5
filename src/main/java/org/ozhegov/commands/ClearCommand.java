package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.MainCollection;
import org.ozhegov.basics.Dragon;

public class ClearCommand implements ExecutableCommand {

    /**
     * This method contains logic for "clear" command. Here the program makes PriorityQueue empty.
     * @param command command with arguments from the console
     */
    @Override
    public void execute(String[] command) {
            int sizeCollection = MainCollection.getQueue().size();
            if(sizeCollection==0){System.out.println("\u001B[31m" + "Коллекция уже пустая!" + "\u001B[0m");}
            for(int i = 0;i<sizeCollection;i++){
                MainCollection.getQueue().remove();
            }
            HistoryCommand.UpdateHistory("clear");

    }

    /**
     * This method validates an arguments for "clear" command
     * @param command command with arguments from the console
     * @return returns true if arguments was entered correctly and false if it was entered incorrectly
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==1){
            return true;
        }else{
            System.out.println("\u001B[31m" + "У команды save не должно быть аргументов!" + "\u001B[0m");
            return false;
        }
    }
}
