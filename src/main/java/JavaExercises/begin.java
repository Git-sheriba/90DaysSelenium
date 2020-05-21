package JavaExercises;

public class begin {
// To verify the immutability
	public static void main(String[] args) {
		// String Literal
		String str1="TestLeaf";
		String str2="TestLeaf";
		System.out.println(str1==str2);// true
		// String object
		String str3 = new String("TestLeaf");
		String str4 = new String("TestLeaf");
		System.out.println(str3==str4); // false
		
	}

}
