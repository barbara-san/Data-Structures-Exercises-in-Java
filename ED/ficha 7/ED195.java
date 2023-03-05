public class ED195 { 
    public static boolean balanced(String s) {
	MyStack<Character> x = new LinkedListStack<Character>();
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (c == '(' || c == '[') {
		x.push(c);
	    }
	    if (c == ')') {
		if (x.isEmpty()) return false;
		if (x.top() == '(') {
		    x.pop();
		}
		else {
		    return false;
		}
	    }

	    if (c == ']') {
		if (x.isEmpty()) return false;
		if (x.top() =='[') {
		    x.pop();
		}
		else {
		    return false;
		}
	    }
	}
	if (!x.isEmpty()) return false;
	return true;
    }

    public static void main(String[] args) {
	System.out.println(balanced("[)"));
	System.out.println(balanced("(]"));
	System.out.println(balanced("]"));
	System.out.println(balanced(")"));
	System.out.println(balanced("[[[()))"));
	System.out.println(balanced("[]()[[])"));
	System.out.println(balanced("()[](()]"));
    }
}
