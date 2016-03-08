import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("���� �������� �������: ");
		int dragonHP = sc.nextInt();
		System.out.print("����� �������: ");
		int dragonDamage = sc.nextInt();
		System.out.print("���� �������� ���������: ");
		int pikemanHP = sc.nextInt();
		System.out.print("����� ���������: ");
		int pikemanDamage = sc.nextInt();
		int countPikeman  = 1;	
		int pmHP = pikemanHP * countPikeman;
		int drHP = dragonHP;
		while(true){
			if(pmHP < 0){
				System.out.println("������ ������� � ���������.");
				countPikeman++;	
				pmHP = pikemanHP * countPikeman;
				drHP = dragonHP;
			}
			else if(drHP < 0){
				System.out.println("��������� ������� � ���������.");
				break;
			}
			drHP -= rouding(pmHP / (float)pikemanHP) * pikemanDamage;
			if(drHP <= 0)
				continue; 
			System.out.println("��������� ������� (���� " + rouding(pmHP / (float)pikemanHP) * pikemanDamage +
					") - � ������� �������� " + drHP + " ����� ��������.");
			pmHP -= dragonDamage;
			if(pmHP <= 0)
				continue;
			if(pmHP % pikemanHP == 0){
				System.out.println("������ ������� (���� " + dragonDamage +
						") - �������� " + pmHP / pikemanHP + " ����������.");
			}
			else{
				System.out.println("������ ������� (���� " + dragonDamage +
						") - �������� " + rouding(pmHP / (float)pikemanHP) + " ����������, ���� �� ������� ����� (�������� "
						+ pmHP % pikemanHP +" ����� ��������).");
			}
		}
		System.out.println("����������� ����� ���������� ��� ������: " + countPikeman);
		sc.close();
	}
	
	public static int rouding(float value){
		if(value - (int)value > 0.0f)
			return (int)value + 1;
		else
			return (int)value;
	}

}
