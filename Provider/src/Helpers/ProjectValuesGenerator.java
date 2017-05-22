package Helpers;

import java.util.Random;

public class ProjectValuesGenerator {
    private static Random randomValue=new Random();
    private static final int PRIME=37;

    public static String generateString(){
        return String.valueOf(generateValue());
    }

    public static int generateValue(){
        return randomValue.nextInt()*PRIME+PRIME;
    }
}
