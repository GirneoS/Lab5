package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.basics.Dragon;

public class InfoCommand implements ExecutableCommand {

    /**
     * This method contains the logic for "info" command. Here the program prints type of main collection in app, date and time of initialization and number of dragons in collection.
     * @param command command with arguments from the console
     */
    @Override
    public void execute(String[] command) {
        if(validate(command)) {
            System.out.println("Тип: PriorityQueue\nДата инициализации: " + Dragon.getInitDate() + "\nКоличество элементов: " + Dragon.getQueue().size());
            HistoryCommand.UpdateHistory("info");
        }
    }

    /**
     * This method validates an arguments for "info" command.
     * @param command command with arguments from the console
     * @return returns true if user not entered arguments and false if he entered some.
     */
    @Override
    public boolean validate(String[] command) {
        if (command.length == 1) {
            return true;
        } else {
            System.out.println("\u001B[31m" + "У команды info нет аргументов!" + "\u001B[0m");
            return false;
        }
    }
}
