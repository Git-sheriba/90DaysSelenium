package JavaExercises;

//1. Write a java code to find the sum of the given numbers 
// Input: "asdf1qwer9as8d7" output: 1+9+8+7 = 25
public class SumOfNumbers_1 {

	public static void main(String[] args) {
		int remainder,Quotient,total=0;
		
		String str = "asdf1qwer9as8d7";
		String replacedStr = str.replaceAll("\\D", "");
		int number = Integer.parseInt(replacedStr);
		System.out.println("The extracted number is :"+number);
		while(number>0) {
			remainder = number%10;
			Quotient = number/10;
			total = total+remainder;
			number=Quotient;
		}
		System.out.println("Total : "+total);
	}

}



