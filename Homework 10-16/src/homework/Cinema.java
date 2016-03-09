package homework;

import java.util.Random;

/**
 * Created by Женя on 08.03.2016.
 */
public class Cinema {
    public static void main(String[] args){
        int m = 12;
        int n = 22;
        int[][] seat =  new int[12][22];
        Random r = new Random();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                seat[i][j] = r.nextInt(2);
                System.out.print(seat[i][j] + " ");
            }
            System.out.println();
        }
        int k = r.nextInt(10) + 3;
        System.out.println("Необходимо мест: " + k);
        for (int i = 0; i < m; i++) {
            int count = 0;
            int index = -1;
            for (int j = 0; j < n; j++) {
                if(seat[i][j] == 0){
                    count++;
                    if(index == -1){
                        index = j;
                    }
                }else {
                    count = 0;
                    index  = -1;
                }
                if(count == k){
                    System.out.println("Места: " + (index + 1) +" - " + (j + 1) + " Ряд: " + ( i + 1 ));
                    return;
                }
            }
        }
        System.out.println("Нет!");
    }
}
