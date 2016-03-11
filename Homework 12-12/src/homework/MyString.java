package homework;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Женя on 11.03.2016.
 */
public class MyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder(sc.nextLine());
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                char temp = input.charAt(i);
                input.setCharAt(i, input.charAt(j));
                input.setCharAt(j, temp);
                if(!array.contains(input.toString())){
                    array.add(input.toString());
                }
            }
        }

        for (String s: array) {
            System.out.println(s);
        }
    }
}
