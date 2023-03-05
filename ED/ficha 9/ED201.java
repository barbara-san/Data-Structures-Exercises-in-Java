import java.util.Scanner;

public class ED201 {
    static int max = 0;
    static int sets(int m[], int time) {
	boolean used[] = new boolean[m.length];
	goSets(0, m, used, time);
	return max;
    }

    static void goSets(int cur, int v[], boolean used[], int time) {
	if (cur == v.length) { 
	    int current = 0;
	    for (int i = 0; i < v.length; i++) {
                if (used[i]) current += v[i];
		if (current <= time && current > max) max = current;
	    }
	} else {
	    used[cur] = true;
	    goSets(cur+1, v, used, time);
	    used[cur] = false;
	    goSets(cur+1, v, used, time);
        }
    }
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	int time = in.nextInt();
        int n = in.nextInt();
	int[] m = new int[n];
	for (int i = 0; i < n; i++) {
            m[i] = in.nextInt();
	}
	System.out.println(sets(m, time));
    }
}
