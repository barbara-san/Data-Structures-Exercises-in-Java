import java.util.Scanner;

public class ReadNumbers {

    // Escrever os numeros guardados num array no stdout
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

    public static void main(String[] args) {

	Scanner stdin = new Scanner(System.in);

	int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem
	int v[] = new int[n];     // Cria um novo array com espaço para 10 inteiros           
      
	for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
            v[i] = stdin.nextInt();
      
	writeArray(v);             // Chamar procedimento que escreve
	int m = Amplitude(v);
	System.out.println(m);
    }
}