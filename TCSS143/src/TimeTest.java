// Igor Kalezic
// 3/1/16
// TCSS 143
// Assignment #8
//
// This program will test the Time class.

public class TimeTest {

	public static void main(String[] args) {

		testTime();
		testTimeOverLoad();
		testAdd();
		testGetTime();
	}
	
	//Tests the default constructor.
	public static void testTime() {
		System.out.println("test time constructor");
		Time a = new Time();
		System.out.println(a);
		System.out.println();
	}
	
	//Tests the constructor with values added by user.
	public static void testTimeOverLoad () {
		System.out.println("test Time constructor overload");
		Time a = new Time(1,2,5);
		Time b = new Time(23,25,1);
		Time c = new Time (25,73, 84);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println();
	}
	
	//Tests the adding method.
	public static void testAdd() {
		System.out.println("Test add");
		Time t = new Time(3, 45, 15);
		System.out.print(t + " + 2:30:55 = ");
		t.add(2, 30, 55);
		System.out.println(t);
		t.add(0, 55, 45);
		System.out.println("6:16:10 + 0:55:45 = " + t);
		System.out.println();
		
	}
	//Tests the getTime method.
	public static void testGetTime() {
		System.out.println("Test get time");
		Time t = new Time(50, 34, 11);
		System.out.println(t + " equals " + t.getTime());
		t.add(2, 30, 55);
		System.out.println(t + " equals " + t.getTime());
		t.add(0, 55, 45);
		System.out.println(t + " equals " + t.getTime());
	}
	
}