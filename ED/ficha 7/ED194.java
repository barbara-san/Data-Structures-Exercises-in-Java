public class ED194 { 
    public static void reverse(MyStack<Integer> s, int n) {
	int[] meow = new int[1000];
	for (int i = 0; i < n; i++) {
	    meow[i] = s.pop();
	}

	for (int i = 0; i <n; i++) {
	    s.push(meow[i]);
	}
    }
}
