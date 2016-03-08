import java.math.BigDecimal;
import java.math.MathContext;

public class MassPlanetarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal sun = new BigDecimal("1.9885e30");
		BigDecimal mercury = new BigDecimal("3.33022e23");
		BigDecimal venus = new BigDecimal("4.8685e24");
		BigDecimal earth = new BigDecimal("5.9726e24");
		BigDecimal mars = new BigDecimal("6.4185e23");
		BigDecimal jupiter = new BigDecimal("1.8986e27");
		BigDecimal saturn = new BigDecimal("5.6846e26");
		BigDecimal uranus = new BigDecimal("8.6832e25");
		BigDecimal neptune = new BigDecimal("1.0243e26");
		
		BigDecimal summa = new BigDecimal("0");
		summa = summa.add(sun).add(mercury).add(venus).add(earth).add(mars)
					 .add(jupiter).add(saturn).add(uranus).add(neptune);
		BigDecimal average = summa.divide(new BigDecimal(8));
		System.out.println("Summa: " + summa.toString());
		
		System.out.println("Average: " + average.toString());
		
		System.out.println("Sun: " + sun.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		System.out.println("Mercury: " + mercury.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		System.out.println("Venus: " + venus.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		System.out.println("Earth: " + earth.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		System.out.println("Mars: " + mars.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		System.out.println("Jupiter: " + jupiter.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		System.out.println("Suturn: " + saturn.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		System.out.println("Uranus: " + uranus.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		System.out.println("Neptune: " + neptune.divide(summa,MathContext.DECIMAL128).multiply(new BigDecimal(100)).toString() + " %");
		
		System.out.println("Sun / all : " + sun.divide(summa.subtract(sun),MathContext.DECIMAL128).toString());
	}

}
