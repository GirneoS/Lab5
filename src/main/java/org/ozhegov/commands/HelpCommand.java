package org.ozhegov.commands;

import org.ozhegov.ExecutableCommand;

public class HelpCommand implements ExecutableCommand {

    /**
     * This method contains logic for "help" command. Here the program prints all commands that are allowed to use.
     * @param command command with arguments from the console
     */
    @Override
    public void execute(String[] command) {
            System.out.println("""
            help : вывести справку по доступным командам
            info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
            show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
            add {element} : добавить новый элемент в коллекцию
            update id {element} : обновить значение элемента коллекции, id которого равен заданному
            remove_by_id id : удалить элемент из коллекции по его id
            clear : очистить коллекцию
            save : сохранить коллекцию в файл
            execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
            exit : завершить программу (без сохранения в файл)
            remove_first : удалить первый элемент из коллекции
            remove_head : вывести первый элемент коллекции и удалить его
            history : вывести последние 13 команд (без их аргументов)
            filter_by_wingspan wingspan : вывести элементы, значение поля wingspan которых равно заданному
            filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки
            print_descending : вывести элементы коллекции в порядке убывания""");
            HistoryCommand.UpdateHistory("help");
    }

    /**
     * This method validates an arguments for "help" command.
     * @param command command with arguments from the console
     * @return returns true if user not entered arguments and false if he entered some.
     */
    @Override
    public boolean validate(String[] command) {
        if(command.length == 1){
            return true;
        }else{
            System.out.println("\u001B[31m" + "У команды help нет аргументов!" + "\u001B[0m");
            return false;
        }
    }
}
