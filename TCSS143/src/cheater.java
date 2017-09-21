
public class cheater {

	public static void main(String[] args) {
		System.out.println(charCount('m', "mmmmmm"));

	}
	public static int charCount(char x, String sample) {
		int i = 0;
		
		for (int b = 0; b <= sample.length()-1; b++) {
			if (x == sample.charAt(b)) {
				i++;
				
			}
			
		}
		
		return i;
		
	}

}
