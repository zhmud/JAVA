package homework;


import java.util.Scanner;

/**
 * Created by Женя on 07.03.2016.
 */
public class ConWord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digit: ");
        System.out.println(digitToWord(sc.nextInt()));
    }

    public static String digitToWord(int value){
        String[] digitWord = {"один", "два","три","четыри","пять","шесть","семь","восемь","девять", "десять",
                "одинацать","одиннадцать","двенадцать","тринадцать","четырнадцать","пятнадцать","шестнадцать","семнадцать","восемнадцать","девятнадцать",
                "двадцать","тридцать", "сорок","пятьдесят","шестьдесят","семьдесят","восемьдесят", "девяносто", "сто", "двести",
                "триста","четыреста","пятсот","шесот","семсот","восемсот","девятсот"};

        int lenDig = (value+"").length();
        String rim = "";
        boolean flag = false;
        for (int i = lenDig; i > 0 ; i--) {
            double temp = Math.pow(10.0, i-1);
            int digit = (int)(value / temp);
            value -= (temp * digit);
            if(i == 6 || i == 3 && digit != 0){
                rim+=digitWord[27 + digit]+ " ";
            }else if(i == 5 || i == 2 ){
                if(digit == 1){
                    flag = true;
                    if(value == 0){
                        rim += digitWord[9] + " ";
                    }
                }
                else if(digit != 0){
                    rim+=digitWord[18 + digit]+ " ";
                }
            }else if(i == 4 || i == 1) {
                if (flag && digit != 0) {
                    rim += digitWord[10 + digit] + " ";
                    flag = false;
                } else if(flag) {
                    rim += digitWord[9] + " ";
                    flag = false;
                } else if (digit > 0){
                    if(i == 4 && digit == 1){
                        rim +="одна ";
                    }else if(i == 4 && digit == 2){
                        rim +="две ";
                    }else{
                        rim += digitWord[digit - 1] + " ";
                    }
                }
            }
            if(digit == 1 && i == 4)
                rim+="тысяча ";
            else if(i == 4 && ((digit > 4 || digit == 0) || value == 0))
                rim+="тысячь ";
            else if(i == 4 && digit > 1)
                rim+="тысячи ";
            if(value == 0)
            {
                if(i >= 5 && i < 7)
                    rim+="тысячь ";
                else if(i == 7)
                    rim+="миллион";
                break;
            }

        }
        return rim;
    }


}
