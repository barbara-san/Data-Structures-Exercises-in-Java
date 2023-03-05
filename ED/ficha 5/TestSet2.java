public class TestSet2 {
    public static void main(String[] args) {
	IntSet s1 = new BooleanArrayIntSet(100);
	boolean x;
	
	x = s1.add(42);
	System.out.println(x);
	System.out.println(s1);
	System.out.println(s1.size());
	x = s1.add(42);
	System.out.println(x);
	System.out.println(s1);

	s1.clear();
	x = s1.add(42);
	System.out.println(x);
	x = s1.add(21);
	System.out.println(x);
	x = s1.add(22);
	System.out.println(x);
	x = s1.add(23);
	System.out.println(x);
	x = s1.add(21);
	System.out.println(x);
	x = s1.add(42);
	System.out.println(x);

	s1.clear();
	x = s1.add(21);
	System.out.println(x);
	x = s1.add(42);
	System.out.println(x);

    }
}