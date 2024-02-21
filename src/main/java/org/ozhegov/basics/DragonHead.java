package org.ozhegov.basics;

/**
 * This class represents a head of Dragon
 */
public class DragonHead {
    private long size;
    private Float eyesCount; //Поле может быть null
    private float toothCount;

    public DragonHead(long size, Float eyesCount, float toothCount) {
        this.size = size;
        this.eyesCount = eyesCount;
        this.toothCount = toothCount;
    }
}
