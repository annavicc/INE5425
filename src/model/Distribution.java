package model;
import java.util.Random;

public class Distribution {

	private Random r;
	public Distribution() {
		r = new Random(System.currentTimeMillis()); // a different seed so that the randomness is different every time.
	}

	public int monteCarlo(double a, double b, double c, double d) {
		double random = r.nextDouble() * 100;

		if (random < a) {
			return 1;
		} else if (random < (a+b)) {
			return 2;
		} else if (random < (a+b+c)) {
			return 3;
		} else {
			return 4;
		}
	}
	
	/* Function overload for 3 parameters */
	public int monteCarlo(double a, double b, double c) {
		double random = r.nextDouble() * 100;

		if (random < a) {
			return 1;
		} else if (random < (a+b)) {
			return 2;
		} else {
			return 3;
		}
	}

	public double calculateNormal(double m, double d) {
		double random1 = r.nextDouble();
		double random2 = r.nextDouble();
		
		return m + (d * Math.sqrt(-2 * Math.log(random1)) * Math.cos(2 * Math.PI * random2));
	}

	public double calculateExponential(double mean) {
		double random = r.nextDouble();
		return -1/mean * Math.log(1 - random);
	}

	public double calculateUniform(double a, double b) {
		double random = r.nextDouble();
		if (random > 0 && random < 1)
			return (int) (a + (b - a) * random);
		return -1;
	}

	public double calculateTriangular(double a, double b, double c) {
		double random = r.nextDouble();

		if ((0 <= random) && (random <= (b - a) / (c - a))) {
			return a + Math.sqrt(random * (b - a) * (c - a));
		} else {
			return (c - Math.sqrt((1 - random) * (c - b) * (c - a)));
		}
	}

}
