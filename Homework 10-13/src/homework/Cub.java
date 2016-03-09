package homework;

import java.util.Scanner;

/**
 * Created by Женя on 08.03.2016.
 */
public class Cub {
    public static void main(String[] args){
        System.out.print("Введите размер массива : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][][] ar = new int[size][size][size];
        int r = size / 2;

        int R = r;
        for (double j = 0.0; j < Math.PI; j += Math.PI / size / 10)
        {
            for (double i = 0.0; i < 2 * Math.PI; i += Math.PI / size / 10)
            {
                int x = (int)(R - 0.01 + R * Math.sin(j) * Math.cos(i));
                int y = (int)(R - 0.01 + R * Math.sin(j) * Math.sin(i));
                int z = (int)(R - 0.01 + R * Math.cos(j));
                ar[(size / 2) - R + z][(size / 2) - R + x][(size / 2) - R + y] = 1;
            }
        }
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                for (int k = 0; k < size; k++) {
                    System.out.print(ar[k][j][i]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
