package JavaExercises;

public class SumOfNumbers_2 {

	public static void main(String[] args) {
		String str = "asdf1qwer9as8d7";
		int sum =0;
		for (int i = 0; i < str.length(); i++) {
			char charAt = str.charAt(i);
			if(Character.isDigit(charAt)) {
				int digitValue = Integer.parseInt(String.valueOf(charAt));
				sum = sum +digitValue;
			}
		}
		System.out.println("Sum of the digits is :"+sum);
	}
}
