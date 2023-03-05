import java.util.Scanner;

class ED164 {
    public static void main(String[] args) {

        BSTree<String> t = new BSTree<String>();
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	String[] data = new String[n];
	for (int i=0; i < n; i++) data[i] = s.next();
        for (int i=0; i < n; i++) t.insert(data[i]);

        System.out.println(t.numberNodes());

   }
}