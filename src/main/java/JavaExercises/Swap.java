package JavaExercises;

public class Swap {

//	1. Write a java program to swap two numbers
//	Input: a = 5, b= 10
//	output: a = 10, b = 5
//	(Note: Try without the third variable)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       int a = 5, b=10;
       System.out.println("Before swapping:   "+"a= "+ a + "  b="+b);
       a = a+b;
       b=a-b;
       a=a-b;
       System.out.println("After swapping:    "+"a= "+ a + "  b="+b);;
	}

}
