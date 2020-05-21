package JavaExercises;

//3. Write a java program to find the number of Uppercase, lowercase, numbers and spaces in the following String. 
//Input: "1. It is Work from Home  not Work for Home"
public class FindAbtString_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int upper=0,lower=0,numbers=0,spaces = 0;
		
     String inputStr="1. It is Work from Home  not Work for Home";
     
     char[] ch = inputStr.toCharArray();
     for (int i = 0; i < ch.length; i++) {
		if(Character.isUpperCase(ch[i])) {
			upper++;
		}
		else if(Character.isLowerCase(ch[i])){
			lower++;
		}
		else if(Character.isDigit(ch[i])){
			numbers++;
		}
		else if(Character.isSpaceChar(ch[i])) {
			spaces++;
		}
	}
     System.out.println("Number of UpperCase letters:"+upper);
     System.out.println("Number of LowerCase letters:"+lower);
     System.out.println("Number of digits letters   :"+numbers);
     System.out.println("Number of spaces letters   :"+spaces);
     
}
}
