package homework;

/**
 * Created by Женя on 06.03.2016.
 */
public class RimDigit {
    public static void main(String[] args){
        String rimDigit[] = new String[4000];
        for (int i = 0; i < 3999; i++) {
            rimDigit[i] = intToRim(i + 1);
            System.out.println(rimDigit[i]);
        }
    }

    public static String intToRim(int value){
        int lenDig = (value+"").length();
        String rim = "";
        for (int i = lenDig; i > 0 ; i--) {
            double temp = Math.pow(10.0, i-1);
            int digit = (int)(value / temp);
            if(i == 4){
                rim+=convector(digit, "M", "", "");
            }else if(i == 3){
                rim+=convector(digit, "C", "D", "M");
            }else if(i == 2){
                rim+=convector(digit, "X", "L", "C");
            }else if(i == 1){
                rim+=convector(digit, "I", "V", "X");
            }
            value -= (temp * digit);
        }
        return rim;
    }

    public static String convector(int value, String min, String avr, String max){
        switch (value){
            case 1:
                return min;
            case 2:
                return min + min;
            case 3:
                return min + min + min;
            case 4:
                return min + avr;
            case 5:
                return avr;
            case 6:
                return avr + min;
            case 7:
                return avr + min + min;
            case 8:
                return avr + min + min + min;
            case 9:
                return min + max;
            case 10:
                return max;
        }
        return "";
    }
}
