package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;

import java.util.ArrayDeque;

/**
 * This class contains a history of the last 13 commands used
 */
public class HistoryCommand implements ExecutableCommand {
    private static ArrayDeque<String> history = new ArrayDeque<>();

    /**
     * Method for adding a new command to the list of used commands
     * @param cmd the command just used
     */
    public static void UpdateHistory(String cmd){
        if(history.size()>=13){
            history.removeFirst();
        }else {
            history.addLast(cmd);
        }
    }

    /**
     * Special method that adds command "history" to the list of last 13 used commands
     */
    public static void AddHistoryInHistory(){
        history.addLast("history");
    }

    /**
     * Method that prints all the list of last 13 used commands
     */
    public static void PrintHistory(){
        String string = "";
        for (String s : history) {
            string = s+"\n"+string;
        }
        System.out.println(string);
    }

    /**
     * This method adds "history" command to collection that contains all last 13 used commands and prints it.
     * @param command command with arguments from the console.
     */
    @Override
    public void execute(String[] command) {
            AddHistoryInHistory();
            PrintHistory();
    }

    /**
     * This method validates an arguments for "history" command.
     * @param command command with arguments from the console
     * @return returns true if user not entered arguments and false if he entered some.
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==1){
            return true;
        }else {
            System.out.println("\u001B[31m" + "У команды \"history\" нет аргументов!" + "\u001B[0m");
            return false;
        }
    }
}
