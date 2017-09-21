import java.util.ArrayList;

public class Extra {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Squid");
		list.add("Octopus");
		
		manyStrings(list, 2);
		System.out.println(list);
		
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("a");
		aList.add("a");
		aList.add("b");		
		aList.add("c");
		
		manyStrings(aList, 3);
		System.out.println(aList);
	}
	
	public static void manyStrings(ArrayList<String> list, int n) {
		int b = 1;
		int c = list.size();
		
		do {
			String x = list.get(b);
			
			list.add(b, x);
			b++;
			
		} while (list.size() <= n * c -1);
		
	}

}
