package JavaExercises;
// 4.	Print the armstrong numbers between 1 and 1000.

/*153 = (1*1*1)+(5*5*5)+(3*3*3)  
where:  
(1*1*1)=1  
(5*5*5)=125  
(3*3*3)=27  
So:  
1+125+27=153*/

public class ArmstrongNumbers {

	public static void main(String[] args) {
		int rem = 0;
		int sum = 0;
		

		
		for (int i = 1; i <= 2000; i++) {
			int originalNumber = i;
			int digits = 0;
	        // number of digits calculation
	        while (originalNumber != 0) {
	            originalNumber /= 10;
	            ++digits;
	        }
	        
	     //   System.out.println("Digit:"+ digits);
	        
	        originalNumber = i;
	        
			while (originalNumber>0) {
				rem = originalNumber % 10;
				sum += (int) (Math.pow(rem, digits));
				originalNumber = originalNumber / 10;
			}
			if (i == sum) {
				System.out.println("The number "+ i + " is an Armstrong number");
			}
			sum =0;
		}
	}

}
