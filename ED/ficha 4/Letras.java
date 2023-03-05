import java.util.Scanner;

class Sopa {
    
    private int lins, cols;
    private char s[][];
    String words[];
    int num;

    Sopa(int l, int c) {
	lins = l;
	cols = c;
	s = new char[lins][cols];
    }

    public void read(Scanner in) {
	for (int i = 0; i < lins; i++)
	    s[i] = in.next().toCharArray();
	}

    public void change(String word, char s2[][], int x, int y, boolean way) {
	if (way) { //verticais
	    for (int i = 0; i < word.length(); i++) {
		s2[x+i][y] = word.charAt(i);
	    }
	}

	if (!way) { //horizontais
	    for (int i = 0; i < word.length(); i++)
		s2[x][y+i] = word.charAt(i);
	}
    }

    public boolean check(String word, int x, int y, boolean way) {
	if (way) { //verticais
	    if (x + word.length() - 1 >= lins)
		return false;
	    for (int i = 0; i < word.length(); i++) {
		if (!(s[x+i][y] == word.charAt(i))) 
		    return false;
	    }
	}

	if (!way) { //horizontais
	    if (y + word.length() - 1 >= cols)
		return false;
	    for (int i = 0; i < word.length(); i++){
		if (!(s[x][y+i] == word.charAt(i))) 
		    return false;
	    }
	}
    return true;
    }

    public String reverse(String word) {
	String tmp = "";
	char ch; 
	for (int i=0; i < word.length(); i++){
	    ch = word.charAt(i);
            tmp = ch + tmp;
	}
	return tmp; 
    }

    public char[][] solve() {
	char s2[][] = new char[lins][cols];
	    for (int i = 0; i < lins; i++) {
		for (int j = 0; j < cols; j++) {
		    s2[i][j] = '.';
		}
	    }
	first: for (int w = 0; w < num; w++) {
	    second: for (int i = 0; i < lins; i++) {
	    	third: for (int j = 0; j < cols; j++) {
		    if (s[i][j] == words[w].charAt(0)) {
			if (check(words[w], i, j, true)) {
			    change(words[w], s2, i, j, true);
			    continue first;
			}
			if (check(words[w], i, j, false)) {
			    change(words[w], s2, i, j, false);
			    continue first;
			}
		    }
		    words[w] = reverse(words[w]);

		    if (s[i][j] == words[w].charAt(0)) {
			if (check(words[w], i, j, true)) {
			    change(words[w], s2, i, j, true);
			    continue first;
			}
			if (check(words[w], i, j, false)) {
			    change(words[w], s2, i, j, false);
			    continue first;
			}
		    }
		
		    words[w] = reverse(words[w]);
		}
	    }
	}
    return s2;			
    }

    public void write() {
	char[][] a = solve();
	for (int i = 0; i < lins; i++)
	    System.out.println(a[i]);
    }
}

public class Letras {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	int lins = in.nextInt();
	int i = 1;

	while (lins != 0) {
	    int cols = in.nextInt();
	    Sopa s = new Sopa(lins, cols);
	    s.read(in);

	    int n = in.nextInt();
	    String words[] = new String[n];
	    for (int j = 0; j < n; j++)
		words[j] = in.next();
	    s.words = words;
	    s.num = n;

	    System.out.println("Input #" + i);
	    s.write();

	    lins = in.nextInt();
	    i++;
	}
    }
}