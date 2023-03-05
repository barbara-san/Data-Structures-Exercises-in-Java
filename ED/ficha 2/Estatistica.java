import java.util.Scanner;

public class Estatistica {

    static int Amplitude(int v[]) {
	int max = v[0];
	int min = v[v.length-1];
	for (int i=0; i<v.length; i++) {
	    if (v[i]>max)
		max = v[i];
	    if (v[i]<min)
		min = v[i];
	}
	int res = max-min;
	return res;
    }

    static Double Media(int v[]) {
	Double soma = 0.0;
	for (int i=0; i<v.length; i++) {
	    soma += v[i];
	}
	Double med = soma / v.length;
	return med;
    }

    public static void main(String[] args) {
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	int v[] = new int[n];           
	for (int i=0; i<n; i++)
            v[i] = stdin.nextInt();
	Double m = Media(v);
	System.out.printf("%.2f\n", m);
	int a = Amplitude(v);
	System.out.println(a);
    }
}