package JavaExercises;
/*
2. Check for the palindrome of the given string: 
	Input: "malayalam" output: Yes, Palindrome 
	Input: "testleaf" output: No, not a palindrome*/
public class checkPalindrome_1 {
	public static void main(String[] args) {
		String str = "malayalam";
		// empty string to store the reversed vakue
		String rev = ""; 
		//Iterate over the original string
		for (int i = str.length()-1; i >= 0; i--) {
			rev+= str.charAt(i);
		} 
		System.out.println(str.equals(rev)?"Yes, A palindrome": "No, Not a palindrome");
	}
}
