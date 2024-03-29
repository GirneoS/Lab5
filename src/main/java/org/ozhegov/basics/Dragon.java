package org.ozhegov.basics;

import org.ozhegov.MainCollection;
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

    public Dragon(String name, Coordinates coordinates, long age, Float wingspan, boolean speaking, DragonType type, DragonHead head) {
        while(true) {
            int ID = new Random().nextInt(998) + 1;
            if (!MainCollection.getDragonIDlist().contains(ID)) {
                this.id = ID;
                MainCollection.getDragonIDlist().add(ID);
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


    public int getId() {
        return id;
    }

    public Float getWingspan() {
        return wingspan;
    }

    public String getName() {
        return name;
    }

    public long getAge() {
        return age;
    }

    public DragonType getType() {
        return type;
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
