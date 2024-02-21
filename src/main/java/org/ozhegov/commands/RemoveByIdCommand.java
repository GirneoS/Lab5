package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.MainCollection;
import org.ozhegov.basics.Dragon;

public class RemoveByIdCommand implements ExecutableCommand {

    /**
     * This method adds "remove_by_id" command. Here the program removes an element from main PriorityQueue by its id.
     * @param command command with arguments from the console.
     */
    @Override
    public void execute(String[] command) {
            boolean flag = false;
            int ID = Integer.parseInt(command[1]);
            for(Dragon d: MainCollection.getQueue()){
                if (d.getId()==ID){
                    MainCollection.getQueue().remove(d);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println("\u001B[31m" + "Дракона с таким id не существует в коллекции!" + "\u001B[0m");
            }else{
                HistoryCommand.UpdateHistory("remove_by_id");
            }
    }

    /**
     * This method validates an arguments for "remove_by_id" command
     * @param command command with arguments from the console
     * @return returns true if arguments was entered correctly and false if it was entered incorrectly
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length==2){
            try{
                Integer.parseInt(command[1]);
                return true;
            }catch(NumberFormatException e){
                System.out.println("\u001B[31m" + "id должен быть указан числом!" + "\u001B[0m");
                return false;
            }
        }else{
            System.out.println("\u001B[31m" + "В команде должен remove_by_id быть 1 аргумент!" + "\u001B[0m");
            return false;
        }
    }
}
