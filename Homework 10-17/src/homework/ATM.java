package homework;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Женя on 10.03.2016.
 * P.S.
 *      ничего сложного справился за 50 минут)
 */
public class ATM {
    public static void main(String[] args) {
        Random r = new Random();
        int banknotes[] = {1,2,5,10,20,50,100,200,500};
        int k = 4 + r.nextInt(3);
        int[][] cartridges = new int[k][2];
        for (int i = 0; i < k; i++) {
            cartridges[i][0] = 2000 +  r.nextInt(1001);
            cartridges[i][1] = banknotes[r.nextInt(9)];
        }

        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < k - i - 1; j++) {
                if (cartridges[j][1] > cartridges[j+1][1]) {
                    int tempB = cartridges[i][0];
                    int tempK = cartridges[j][1];
                    cartridges[j][0] = cartridges[j+1][0];
                    cartridges[j][1] = cartridges[j+1][1];
                    cartridges[j+1][0] = tempB;
                    cartridges[j+1][1] = tempK;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Введите сумму: ");
            int sumInput = sc.nextInt();
            if(sumInput == 0)
                break;
            int sumOutput = 0;
            int countBanknote = 40;
            int result[] = new int[countBanknote];
            int count = 0;
            for (int i = k - 1; i >= 0; i--) {
                while(sumInput > sumOutput && cartridges[i][0] > 1 && count < countBanknote){
                    sumOutput += cartridges[i][1];
                    result[count] = cartridges[i][1];
                    count++;
                }
                if(sumInput == sumOutput){
                    for (int l = 0; l < count; l++) {
                        System.out.println(result[l]);
                    }
                    break;
                }else{
                    sumOutput -= cartridges[i][1];
                    count--;
                }
                if(count >= countBanknote || i == 0){
                    System.out.println("Запрашиваемую сумму выдать нельзя!");
                    break;
                }
            }
        }
        sc.close();
    }
}
