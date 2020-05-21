package JavaExercises;

public class checkPalindrome_3 {

	public static void main(String[] args) {
     String str = "malayalam";
     StringBuffer strBuf = new StringBuffer(str);
     String revStr = strBuf.reverse().toString();
     System.out.println(revStr.equals(str)?"It is a palindrome":"Not a Palindrome");
	}

}
