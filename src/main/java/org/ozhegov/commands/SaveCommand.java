package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;
import org.ozhegov.MainCollection;
import org.ozhegov.basics.Dragon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class SaveCommand implements ExecutableCommand {

    /**
     * This method contains the logic for "save" command. Here the program saves the collection in file "SavedCollection".
     * @param command command with arguments from the console.
     */
    @Override
    public void execute(String[] command) {
            if (Files.isWritable(new File(System.getenv("SAVE_DRAGON")).toPath())){
                try (PrintWriter writer = new PrintWriter(new FileWriter(System.getenv("SAVE_DRAGON")))) {
                    writer.write("name,age,id,wingspan,DragonType"+"\nS");
                    for (Dragon d : MainCollection.getQueue()) {
                        writer.write(d.getName()+","+d.getAge()+","+d.getId()+","+d.getWingspan()+","+d.getType() + "\n");
                    }
                    HistoryCommand.UpdateHistory("save");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("\u001B[31m" + "У вас нет прав доступа к файлу сохранения!" + "\u001B[0m");
            }
        }
    /**
     * This method validates an arguments for "save" command.
     * @param command command with arguments from the console
     * @return returns true if user not entered arguments and false if he entered some.
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
