package org.ozhegov;

import java.util.Scanner;

 /**
 * This class is start point class for the app
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        while(true){
            System.out.print(">");
            String[] command = scanner.nextLine().split(" ");
            Execution.executeCommand(command);
        }
    }
}