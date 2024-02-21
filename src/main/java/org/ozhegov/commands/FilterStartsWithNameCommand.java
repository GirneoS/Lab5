package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.MainCollection;
import org.ozhegov.basics.Dragon;

public class FilterStartsWithNameCommand implements ExecutableCommand {

    @Override
    public void execute(String[] command) {
            boolean flag = false;
            String subName = command[1];

            for(Dragon d: MainCollection.getQueue()){
                if(d.getName().startsWith(subName)){
                    System.out.println(d);
                    flag = true;
                }
            }
            if(!flag){
                System.out.println("\u001B[31m" + "В коллекции нет драконов, у которых имя начинается с указанной подстроки!" + "\u001B[0m");
            }else{HistoryCommand.UpdateHistory("filter_starts_with_name");}
    }

    @Override
    public boolean validate(String[] command) {
        if(command.length==2)
            return true;
        else {
            System.out.println("\u001B[31m" + "У команды filter_starts_with_name должен быть 1 аргумент!" + "\u001B[0m");
            return false;
        }
    }
}
