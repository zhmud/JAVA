import java.util.Scanner;

public class TimeCalc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h_start, m_start, s_start;
		int h_end, m_end, s_end;
		
		System.out.println("Enter call start:");
		System.out.print("h:");
		h_start = sc.nextInt();
		System.out.print("m:");
		m_start = sc.nextInt();
		System.out.print("s:");
		s_start = sc.nextInt();
		
		
		System.out.println("Enter call end:");
		System.out.print("h:");
		h_end = sc.nextInt();
		System.out.print("m:");
		m_end = sc.nextInt();
		System.out.print("s:");
		s_end = sc.nextInt();
		
		int start = s_start + m_start * 60 + h_start * 3600;
		int end = s_end + m_end * 60 + h_end * 3600;
		int timer = end - start;
		System.out.println("Cost: " + (float)timer / 60.0f * 15.0f);
		sc.close();
	}
}