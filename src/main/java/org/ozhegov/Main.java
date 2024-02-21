package org.ozhegov;

import java.util.Scanner;

 /**
 * This class is start point class for the app
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int i = 1;
//        while(i>0){
//            i--;
//            System.out.print(">");
//            if(scanner.hasNext()){
//                String[] command = scanner.nextLine().split(" ");
//                Execution.executeCommand(command);
//            }
//        }

        while(true){
            System.out.print(">");
            String[] command = scanner.nextLine().split(" ");
            Execution.executeCommand(command);
        }
    }
}