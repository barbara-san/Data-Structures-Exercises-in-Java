import java.util.Scanner;

public class ED198 {

    public static int best(int[] v, int n) {
	int b = 0;
	int cur = 0;
	for (int x=0; x<n; x++) {
	    if (cur + v[x] < 0) {cur = 0;}
	    else if (cur + v[x] > 0) {cur = cur + v[x];}
	    if (b < cur) {b = cur;}
	}
	return b;
    }


    public static void main(String[] args) {
	Scanner meow = new Scanner(System.in);
	int n = meow.nextInt();
	int[] v = new int[n];
	for (int i = 0; i < n; i++) {
	    v[i] = meow.nextInt();
	}
	int b = best(v, n);
	System.out.println(b);
    }
}