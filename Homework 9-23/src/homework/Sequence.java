package homework;

import java.util.Scanner;

/**
 * Created by Женя on 08.03.2016.
 */
public class Sequence {
    public static void main(String[] args){
        String sequence = "1";
        String result = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        sc.close();
        for (int j = 1; j < n; j++) {
            char temp = ' ';
            int count = 0;
            result = "";
            for (int i = 0; i < sequence.length(); i++) {
                if(sequence.charAt(i) != temp)
                {
                    if(count != 0)
                        result+= "" + count + temp;
                    temp = sequence.charAt(i);
                    count = 1;
                }else {
                    count++;
                }
                if(i == sequence.length() - 1)
                    result+= "" + count + temp;
            }
            sequence = result;
        }
        System.out.println(sequence);
    }
}
