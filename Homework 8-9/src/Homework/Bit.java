package Homework;

import java.util.Random;

/**
 * Created by Женя on 06.03.2016.
 */
public class Bit {
    public static void main(String[] args){
        Random r =  new Random();
        int value = 0;
        value = value | 1<<r.nextInt(32) | 1<<r.nextInt(32) | 1<<r.nextInt(32);
        System.out.println(value);
    }
}
