package JavaExercises;

//2. Write a java program to do the following.
//Input: "When the world realise its own mistake, corona will dissolve automatically" 
//output: "When eht world esilaer its nwo mistake, anoroc will evlossid automatically"
	
public class ReverseAltWords_1 {
	public static void main(String[] args) {
    String inputString = "When the world realise its own mistake, corona will dissolve automatically";
    String[] splitStr = inputString.split(" ");
    
    StringBuffer buffers[] = new StringBuffer[splitStr.length];
    
    for (int i = 0; i < splitStr.length; i++) {
    	buffers[i] = new StringBuffer(splitStr[i]);
    	if ((i%2)!=0) {
    		buffers[i].reverse().toString();
		} 
    	System.out.print(buffers[i]+" ");
	}
 }
}


