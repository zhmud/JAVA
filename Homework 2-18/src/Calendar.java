import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Calendar {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter days: ");
		int days = sc.nextInt();
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(new Date(new Date().getTime() + 86400000L * days));
		System.out.println(calendar.getTime());
		sc.close();
	}
}
