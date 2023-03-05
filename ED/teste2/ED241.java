import java.util.LinkedList;
import java.util.Scanner;

public class ED241 {
    public static void main(String[] args) {
	BSTree<String> f1 = new BSTree<String>();
        BSTMap<String,Integer> f2 = new BSTMap<String,Integer>();
	BSTMap<String,int[]> f3 = new BSTMap<String,int[]>();
	BSTMap<String,BSTree<String>> f4 = new BSTMap<String,BSTree<String>>();
	BSTree<String> ffff = new BSTree<String>();
	Scanner s = new Scanner(System.in);
	int F = s.nextInt();
	int N = s.nextInt();
	String[] p = new String[999];
	for (int i = 0; i < N; i++) {
	    String name = s.next();
	    String problem = s.next();
	    String result = s.next();
	    if (F == 1) {
		f1.insert(name);
	    }
	    if (F == 2) {
		if (f2.get(problem) == null) {f2.put(problem, 1);}
		else {f2.put(problem, f2.get(problem) + 1);}
	    }
	
	    if (F == 3) {
		int[] a = new int[2];
		a[0] = 0;
		a[1] = 1;
		if (f3.get(problem) == null) {f3.put(problem, a);}
		else {
		    a = f3.get(problem);
		    a[1] += 1;
		    f3.put(problem, a);
		}
		if (result.equals("Accepted")) {
		    a = f3.get(problem);
		    a[0] += 1;

		    f3.put(problem, a);
		}
	    }

	    if (F == 4) {
		BSTree<String> w = new BSTree<String>();
		if (f4.get(name) == null && result.equals("Accepted")) {
		    f4.put(name, w);
		}
		if (result.equals("Accepted")) {
		    w = f4.get(name);
		    w.insert(problem);
		    f4.put(name, w);
		}
		ffff.insert(problem);
	    }
	}
//------------------------------------------------------          
        if (F == 1) {
	    System.out.println(f1.numberNodes());
	}
//------------------------------------------------------
        if (F == 2) {
	    LinkedList<String> keys = f2.keys();
	    String max = keys.getFirst();
      	    for (String k : f2.keys()) {
		if (f2.get(k) > f2.get(max))
		    max = k;
	    }
	    System.out.println(max + " " + f2.get(max));
	}
//------------------------------------------------------
        if (F == 3) {
      	    for (String k : f3.keys()) {
		float a = f3.get(k)[0];
		float b = f3.get(k)[1];
		if (a/b >= 0.5)
		    System.out.println(k);
	    }
	}
//------------------------------------------------------
	if (F == 4) {
      	    for (String k : f4.keys()) {
		BSTree<String> w = f4.get(k);
		if (w.numberNodes() == ffff.numberNodes())
		    System.out.println(k);
	    }
	}

    }
}