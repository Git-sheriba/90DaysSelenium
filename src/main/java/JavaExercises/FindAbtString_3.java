package JavaExercises;

public class FindAbtString_3 {

	public static void main(String[] args) {
		int upper=0,lower=0,numbers=0,spaces = 0;
        String inputStr="1. It is Work from Home  not Work for Home";
        for (int i = 0; i < inputStr.length(); i++) {
        	char ch = inputStr.charAt(i);
        	if(ch>=67 &&ch<=90)
        		upper++;
        	else if(ch>=97&&ch<=122)
        		lower++;
        	else if(ch>=48&&ch<=57)
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
