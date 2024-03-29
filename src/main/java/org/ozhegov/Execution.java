package org.ozhegov;

import org.ozhegov.commands.*;

import java.util.HashMap;

/**
 * This is class for taking the order from console.
 */
public class Execution {
    /**
     * This map stores a list of command classes and string association for each.
     */
    private static final HashMap<String, ExecutableCommand> commands = new HashMap<>();


    static{
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
        commands.put("execute_script", new ExecuteScriptCommand());
        commands.put("show", new ShowCommand());
        commands.put("add", new AddCommand());
        commands.put("remove_first", new RemoveFirstCommand());
        commands.put("remove_head", new RemoveHeadCommand());
        commands.put("filter_starts_with_name", new FilterStartsWithNameCommand());
        commands.put("filter_by_wingspan", new FilterByWingspanCommand());
        commands.put("remove_by_id", new RemoveByIdCommand());
        commands.put("save", new SaveCommand());
        commands.put("clear", new ClearCommand());
        commands.put("print_descending", new PrintDescendingCommand());
        commands.put("history", new HistoryCommand());
        commands.put("info", new InfoCommand());

    }

    /**
     * This method takes a command with arguments from the console and sends it to the right command class.
     * @param command the entered by user command with arguments.
     */
    public static void executeCommand(String[] command){
        if(commands.containsKey(command[0])){
            if(commands.get(command[0]).validate(command)) {
                commands.get(command[0]).execute(command);
            }
        }else{
            System.out.println("\u001B[31m" + "Команда "+command[0]+" не найдена!" + "\u001B[0m");
        }
    }
}
