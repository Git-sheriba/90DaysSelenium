package JavaExercises;

//Scan string str from 0 to length-1.
//check one character at a time on the basis of ASCII values
//if(str[i] >= 65 and str[i] <=90), then it is uppercase letter,
//if(str[i] >= 97 and str[i] <=122), then it is lowercase letter,
//if(str[i] >= 48 and str[i] <=57), then it is number,
//else it is a special character
//Print all the counters.

public class FindAbtString_2 {

	public static void main(String[] args) {
		int upper=0,lower=0,numbers=0,spaces = 0;
        String inputStr="1. It is Work from Home  not Work for Home";
        for (int i = 0; i < inputStr.length(); i++) {
        	char ch = inputStr.charAt(i);
        	if(ch>='A'&&ch<='Z')
        		upper++;
        	else if(ch>='a'&&ch<='z')
        		lower++;
        	else if(ch>='0'&&ch<='9')
        		numbers++;
        	else if(ch==' ')
        		spaces++;
        	
		}  
        System.out.println("Number of UpperCase letters:"+upper);
        System.out.println("Number of LowerCase letters:"+lower);
        System.out.println("Number of digits letters   :"+numbers);
        System.out.println("Number of spaces letters   :"+spaces);
	}

}
