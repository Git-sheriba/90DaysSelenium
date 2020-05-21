package JavaExercises;

/*
 * ####### Using a string and a string builder #####
 * 1. Declare a string str = "amma"
 * 2. Declare an empty string String rev ""
 * 3. Create  a string builder to convert rev to mutable string
 * 4. Convert the string to array of characters
 * 5. Iterate the array from the end and append to the null array using StringBuilder.append()
 */
public class checkPalindrome_2 {

	public static void main(String[] args) {
		String str = "testleaf";
		String rev = "";
		StringBuilder revBuf = new StringBuilder(rev);
		
		char ch[] = str.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			revBuf.append(ch[i]);
		}

		if(str.contentEquals(revBuf))
			System.out.println("The string " + str + " is a Palindrome");
        else
        	System.out.println("The string " + str + " is not a Palindrome");
		
		// If two stringBuilders have to be compared, then use .toString() for both the stringBuilders
        //		StringBuilder strBuf = new StringBuilder(str);
		//
        /* if((revBuf.toString()).equals((strBuf.toString())))
        	System.out.println("The string " + str + " is a Palindrome");
        else
        	System.out.println("The string " + str + " is not a Palindrome");   */
	}

}
