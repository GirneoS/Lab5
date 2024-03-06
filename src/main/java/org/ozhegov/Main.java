package org.ozhegov;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

 /**
 * This class is start point class for the app
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        String[] command;
        while(true){
            System.out.print(">");
            if (scanner.hasNextLine()) {
                command = scanner.nextLine().split(" ");
                Execution.executeCommand(command);
            }else{
                command = new String[]{"exit"};
                Execution.executeCommand(command);
                System.out.println("\nВыход из приложения...");
                break;
            }
        }


    }


}
