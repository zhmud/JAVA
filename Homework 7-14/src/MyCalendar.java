import java.util.Scanner;

public class MyCalendar {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Ââåäèòå ãîä: ");
		int year = sc.nextInt();
		int countDays = 0;
		for(int i = 1; i < year; i++){
			if (!((i % 4) != 0) || (!((i % 100) != 0) && (i % 400) != 0)){
				countDays += 366;
			}else{
				countDays += 365;
			}
		}
		if(countDays == 0)
			countDays++;
		
		System.out.println("      ßíâàğü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 31; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=31;
		System.out.println();
		System.out.println("      Ôåâğàëü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		int leapYear  = (!((year % 4) != 0) || (!((year % 100) != 0) && (year % 400) != 0)) ? 29 : 28;
		for(int i = 1 - (countDays - 1) % 7; i <= leapYear; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=leapYear;
		
		System.out.println();
		System.out.println("      Ìàğò");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 31; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=31;
		
		System.out.println();
		System.out.println("      Àïğåëü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 30; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=30;
		
		System.out.println();
		System.out.println("      Ìàé");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 31; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=31;
		
		
		System.out.println();
		System.out.println("      Èşíü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 30; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=30;
		
		System.out.println();
		System.out.println("      Èşëü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 31; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=31;
		
		System.out.println();
		System.out.println("      Àâãóñò");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 31; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=31;
		
		System.out.println();
		System.out.println("      Ñåíòÿáğü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 30; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=30;
		
		System.out.println();
		System.out.println("      Îêòÿáğü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 31; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=31;
		
		System.out.println();
		System.out.println("      Íîÿáğü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 30; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=30;
		
		System.out.println();
		System.out.println("      Äåêàáğü");
		System.out.println("Ïí Âò Ñğ ×ò Ïò Ñá Âñ");
		for(int i = 1 - (countDays - 1) % 7; i <= 31; i++){
			if(i < 1){
				System.out.print("   ");
			} else {
				System.out.print(i < 10 ? " " + i + " ": i + " ");
			}
			if((i + (countDays - 1) % 7) % 7 == 0)
				System.out.println();
		}
		countDays+=31;
		
		sc.close();
	}

}
