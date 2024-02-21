package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.MainCollection;
import org.ozhegov.basics.Dragon;

public class FilterByWingspanCommand implements ExecutableCommand {

    /**
     * This method contains logic for "filter_by_wingspan" command. Here the program filtering elements from PriorityQueue and print them.
     * @param command command with arguments from the console
     */
    @Override
    public void execute(String[] command) {
            boolean flag = false;
            float goal = Float.parseFloat(command[1]);
            for (Dragon d : MainCollection.getQueue()) {
                if (d.getWingspan() == goal) {
                    System.out.println(d);
                    flag = true;
                }
            }
            if (!flag) {
                System.out.println("\u001B[31m" + "В коллекции нет драконов с указанным размахом крыльев!" + "\u001B[0m");
            }else{HistoryCommand.UpdateHistory("filter_by_wingspan");}

    }

    /**
     * This method validates an arguments for "filter_by_wingspan" command
     * @param command command with arguments from the console
     * @return returns true if arguments was entered correctly and false if it was entered incorrectly
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==2){
            try{
                Float.parseFloat(command[1]);
                return true;
            }catch(NumberFormatException e){
                System.out.println("\u001B[31m" + "Первый аргумент команды может быть задан только дробным числом!" + "\u001B[0m");
                return false;
            }
        }else {
            System.out.println("\u001B[31m" + "У команды filter_by_wingspan должен быть 1 аргумент!" + "\u001B[0m");
            return false;
        }
    }
}
