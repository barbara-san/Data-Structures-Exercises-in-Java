import java.util.Scanner;

public class Estatistica {

    static void writeArray(int v[]) {
	for (int i=0; i<v.length; i++)          
            System.out.println("v[" + i + "] = " + v[i]);      
    }
   
    static int Amplitude(int v[]) {

	int max = v[0];
	int min = v[v.length-1];

	for (int i=1; i<v.length; i++) {
	    if (i>max)
		max = i;
	    if (i<min)
		min = i;
	}
	
	int res = max-min;
	return res;
    }

    static int Media(int v[]) {

	Double soma = 0;

	for (int i=0; i<v.length; i++) {
	    soma += v[1];
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


	int m = Media(v);
	System.out.println("%.2f\n", m);
	int a = Amplitude(v);
	System.out.println(a);
    }
}