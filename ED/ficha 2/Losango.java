import java.util.Scanner;

public class Losango {

    static void line(int n, int i) {
	int k = n-i;
	int m = k/2-k%2 +1;
	for (int l = 0; l < m; l++) {
	    System.out.print(".");
	}
	for (int l = 0; l <= i; l++) {
	    System.out.print("#");
	}
	for (int l = 0; l < m; l++) {
	    System.out.print(".");
	}
	System.out.println("");
	
    }

    static void losang(int n) {
	int l;
	for (int i = 0; i <=n; i+=2) {
	    line(n, i);
	}
	for (int i = n-3; i >=0; i-=2) {
	    line(n, i);
	}
    }

    public static void main(String[] args) {
	
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	
	losang(n);

    }
}