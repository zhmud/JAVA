
public class Painter {
	public static void main(String[] args) {
		int A = 20;
		int B = 20;
		int C = 20;
		int dyx = C/4;
		for(int i = 0; i < A + dyx; i++){
			for(int j = 0; j < B + dyx; j++){
				if(((i == 0 || i == A) && j >= dyx) || ((j == dyx || j == dyx + B - 1) && i <= A)
						|| ((i == dyx || i == dyx + A - 1) &&  j <= B) || ((j == 0 || j == B) && i >= dyx)
						|| (j <= dyx && i <= dyx && i == dyx - j)
						|| (j >= B && i <= dyx && i == dyx - j + B)
						|| (j <= dyx && i >= A && i == A + dyx - j - 1)
						|| (j >= B && i >= A && i == A + dyx - j + B - 1)
						){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	
}
