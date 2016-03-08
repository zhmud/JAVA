package homework;

import java.util.Scanner;

/**
 * Created by Женя on 06.03.2016.
 */
public class Digit {
    public static void main(String[] args){
        String one =    "   1   "+
                        "  11   "+
                        "   1   "+
                        "   1   "+
                        "   1   "+
                        "   1   "+
                        "  111  ";

        String two =    "  222  "+
                        " 2   2 "+
                        " 2  2  "+
                        "   2   "+
                        "  2    "+
                        " 2     "+
                        " 22222 ";

        String three =  "  333  "+
                        " 3   3 "+
                        "     3 "+
                        "   33  "+
                        "     3 "+
                        " 3   3 "+
                        "  333  ";

        String four =   "    4  "+
                        "   44  "+
                        "  4 4  "+
                        " 4  4  "+
                        " 444444"+
                        "    4  "+
                        "    4  ";

        String five =   " 55555 "+
                        " 5     "+
                        "  555  "+
                        "     5 "+
                        "     5 "+
                        " 5   5 "+
                        "  555  ";

        String six =    "  666  "+
                        " 6     "+
                        " 6     "+
                        " 6666  "+
                        " 6   6 "+
                        " 6   6 "+
                        " 6666  ";

        String seven =  " 77777 "+
                        "     7 "+
                        "    7  "+
                        "   7   "+
                        "  7    "+
                        " 7     "+
                        " 7     ";

        String eight =  "  888  "+
                        " 8   8 "+
                        " 8   8 "+
                        "  888  "+
                        " 8   8 "+
                        " 8   8 "+
                        "  888  ";

        String nine =   "  9999 "+
                        " 9   9 "+
                        " 9   9 "+
                        "  9999 "+
                        "     9 "+
                        "     9 "+
                        "  999  ";

        String ziro =   "  000  "+
                        " 0   0 "+
                        "0     0"+
                        "0     0"+
                        "0     0"+
                        " 0   0 "+
                        "  000  ";

        Scanner sc =  new Scanner(System.in);
        System.out.print("Введите число: ");
        String digits = sc.nextLine();
        sc.close();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < digits.length(); j++){
                switch (digits.charAt(j)){
                    case '1':
                        System.out.print(one.substring(i*7, i*7 + 7));
                        break;
                    case '2':
                        System.out.print(two.substring(i*7, i*7 + 7));
                        break;
                    case '3':
                        System.out.print(three.substring(i*7, i*7 + 7));
                        break;
                    case '4':
                        System.out.print(four.substring(i*7, i*7 + 7));
                        break;
                    case '5':
                        System.out.print(five.substring(i*7, i*7 + 7));
                        break;
                    case '6':
                        System.out.print(six.substring(i*7, i*7 + 7));
                        break;
                    case '7':
                        System.out.print(seven.substring(i*7, i*7 + 7));
                        break;
                    case '8':
                        System.out.print(eight.substring(i*7, i*7 + 7));
                        break;
                    case '9':
                        System.out.print(nine.substring(i*7, i*7 + 7));
                        break;
                    case '0':
                        System.out.print(ziro.substring(i*7, i*7 + 7));
                        break;
                }
            }
            System.out.println();
        }


    }
}
