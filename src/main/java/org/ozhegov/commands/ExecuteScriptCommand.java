package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.Execution;

import java.io.*;

public class ExecuteScriptCommand implements ExecutableCommand {

    /**
     * This method contains logic for "execute_script" command. Here the program reading commands from file.
     * @param command command with arguments from the console
     */
    @Override
    public void execute(String[] command) {
            try(BufferedReader reader = new BufferedReader(new FileReader(command[1]))){
                var line = reader.readLine();
                while(line!=null){
                    Execution.executeCommand(line.split(" "));
                    line = reader.readLine();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            HistoryCommand.UpdateHistory("execute_script");
    }

    /**
     * This method validates an arguments for "execute_script" command
     * @param command command with arguments from the console
     * @return returns true if arguments was entered correctly and false if it was entered incorrectly
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==2){
            if(command[1].startsWith(" ")){
                System.out.println("\u001B[31m" + "Имя файла не может начинаться или заканчиваться с пробела!" + "\u001B[0m");
                return false;
            }
            if(command[1].startsWith(".")){
                System.out.println("\u001B[31m" + "Имя файла не может начинаться или заканчиваться с точки!" + "\u001B[0m");
                return false;
            }
            return true;
        }else{
            System.out.println("\u001B[31m" + "У команды execute_script должен быть 1 аргумент(название файла должно быть в одно слово)!" + "\u001B[0m");
            return false;
        }
    }
}
