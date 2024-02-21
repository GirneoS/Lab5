package org.ozhegov.basics;

import org.ozhegov.exceptions.LogicException;
import org.ozhegov.exceptions.NullFieldException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * The main object in the app that contained in collection
 */
public class Dragon implements Comparable<Dragon>{
    private final int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final long age; //Значение поля должно быть больше 0
    private final Float wingspan; //Значение поля должно быть больше 0, Поле может быть null
    private final boolean speaking;
    private final DragonType type; //Поле может быть null
    private final DragonHead head;

    private static PriorityQueue<Dragon> appQueue = new PriorityQueue<>();
    private static Date initDate;
    private static ArrayList<Integer> dragonIDlist = new ArrayList();

    static{
        File file = new File(System.getenv("INIT_DRAGON"));
        if (!Files.isReadable(file.toPath())) {
            System.out.println("\u001B[31m" + "У вас нет доступа к файлу инициализации коллекции!" + "\u001B[0m");
            System.exit(1);
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                reader.readLine();
                String line = reader.readLine();
                while (line != null) {
                    String[] fields = line.split(",");


                    String nameField = fields[0];
                    if (nameField.equals("")){
                        throw new LogicException("Введите конкретное имя дракона");
                    }

                    String Xline = fields[1];
                    Integer coordinateXField;
                    if(Xline.equals(""))
                        throw new NullFieldException("Введите конкретное число в поле x координаты");
                    else
                        coordinateXField = Integer.parseInt(Xline);

                    float coordinateYField = Float.parseFloat(fields[2]);
                    long ageField = Long.parseLong(fields[3]);
                    if(ageField<=0){
                        throw new LogicException("Возраст дракона, указанный в файле, должен быть больше 0");
                    }
                    String wingLine = fields[4];
                    Float wingspanField;
                    if(wingLine.equals("")) {
                        wingspanField = null;
                    }else{
                        if(Float.parseFloat(wingLine)>0) {
                            wingspanField = Float.parseFloat(wingLine);
                        }else{
                            throw new LogicException("Размах крыльев дракона, указанный в файле, должен быть больше 0");
                        }

                    }
                    boolean speakingField = Boolean.parseBoolean(fields[5]);
                    String typeLine = fields[6];
                    DragonType typeField;
                    if(typeLine.equals("")){
                        typeField = null;
                    }else {
                        typeField =DragonType.valueOf(typeLine);
                    }
                    long headSize = Long.parseLong(fields[7]);
                    String eyesLine = fields[8];
                    Float headEyesCount;
                    if(eyesLine.equals("")){
                        headEyesCount = null;
                    }else {
                        headEyesCount = Float.parseFloat(fields[8]);
                    }
                    float headToothCount = Float.parseFloat(fields[9]);

                    appQueue.add(new Dragon(nameField, new Coordinates(coordinateXField, coordinateYField), ageField, wingspanField, speakingField, typeField, new DragonHead(headSize, headEyesCount, headToothCount)));

                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        initDate = new Date();
    }


    public Dragon(String name, Coordinates coordinates, long age, Float wingspan, boolean speaking, DragonType type, DragonHead head) {
        while(true) {
            int ID = new Random().nextInt(998) + 1;
            if (!dragonIDlist.contains(ID)) {
                this.id = ID;
                dragonIDlist.add(ID);
                break;
            }
        }

        this.creationDate = new Date();

        if(name.equals("")) {
            throw new LogicException("Вы должны задать имя дракона в файле!");
        }else {
            this.name = name;
        }
        if(coordinates==null){
            throw new NullFieldException("Вы должны задать координату дракона в файле!");
        }else {
            this.coordinates = coordinates;
        }
        if(age<0){
            throw new LogicException("Возраст должен быть задан в файле положительным числом!");
        }else {
            this.age = age;
        }
        if(wingspan==null)
            this.wingspan=null;
        else{
            if (wingspan < 0) {
                throw new LogicException("Размах крыльев должен быть задан в файле положительным числом!");
            } else {
                this.wingspan = wingspan;
            }
        }
        this.speaking = speaking;
        this.type = type;
        this.head = head;
    }


    public static PriorityQueue<Dragon> getQueue(){
            return appQueue;

    }


    public static Date getInitDate() {
        return initDate;
    }

    public int getId() {
        return id;
    }

    public Float getWingspan() {
        return wingspan;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Дракон "+name+"{age="+age+"; "+"id="+id+"; "+"wingspan="+wingspan+"}";
    }

    @Override
    public int compareTo(Dragon o) {
        return Integer.compare(this.id, o.id);
    }

}
