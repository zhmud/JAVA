import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Очки здоровья дракона: ");
		int dragonHP = sc.nextInt();
		System.out.print("Атака дракона: ");
		int dragonDamage = sc.nextInt();
		System.out.print("Очки здоровья копейщика: ");
		int pikemanHP = sc.nextInt();
		System.out.print("Атака копейщика: ");
		int pikemanDamage = sc.nextInt();
		int countPikeman  = 1;	
		int pmHP = pikemanHP * countPikeman;
		int drHP = dragonHP;
		while(true){
			if(pmHP < 0){
				System.out.println("Дракон атакует и побеждает.");
				countPikeman++;	
				pmHP = pikemanHP * countPikeman;
				drHP = dragonHP;
			}
			else if(drHP < 0){
				System.out.println("Копейщики атакуют и побеждают.");
				break;
			}
			drHP -= rouding(pmHP / (float)pikemanHP) * pikemanDamage;
			if(drHP <= 0)
				continue; 
			System.out.println("Копейщики атакуют (урон " + rouding(pmHP / (float)pikemanHP) * pikemanDamage +
					") - у дракона осталось " + drHP + " очков здоровья.");
			pmHP -= dragonDamage;
			if(pmHP <= 0)
				continue;
			if(pmHP % pikemanHP == 0){
				System.out.println("Дракон атакуют (урон " + dragonDamage +
						") - осталось " + pmHP / pikemanHP + " копейщиков.");
			}
			else{
				System.out.println("Дракон атакуют (урон " + dragonDamage +
						") - осталось " + rouding(pmHP / (float)pikemanHP) + " копейщиков, один из которых ранен (осталось "
						+ pmHP % pikemanHP +" очков здоровья).");
			}
		}
		System.out.println("Минимальное число копейщиков для победы: " + countPikeman);
		sc.close();
	}
	
	public static int rouding(float value){
		if(value - (int)value > 0.0f)
			return (int)value + 1;
		else
			return (int)value;
	}

}
