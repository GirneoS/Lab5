package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.basics.Dragon;

public class PrintDescendingCommand implements ExecutableCommand {

    /**
     * This method adds "print_descending" command. Here the program prints all elements of main PriorityQueue in reverse order.
     * @param command command with arguments from the console.
     */
    @Override
    public void execute(String[] command) {
            var reverseOrder = "";
            for (Dragon d : Dragon.getQueue()) {
                reverseOrder = d +"\n"+ reverseOrder;
            }
            System.out.println(reverseOrder);
            HistoryCommand.UpdateHistory("print_descending");
    }

    /**
     * This method validates an arguments for "print_descending" command.
     * @param command command with arguments from the console
     * @return returns true if user not entered arguments and false if he entered some.
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==1)
            return true;
        else{
            System.out.println("\u001B[31m" + "У команды print_descending нет аргументов!" + "\u001B[0m");
            return false;
        }
    }
}
