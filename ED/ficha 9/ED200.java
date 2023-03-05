import java.util.Scanner;

public class ED200 {
    static int rows;            // Numero de linhas
    static int cols;            // Numero de colunas   
    static char m[][];          // Matriz de celulas
    static boolean visited[][]; // Saber se uma dada posicao ja foi visitada

    // Tamanho da mancha que inclui posicao (y,x)
    static int t(int y, int x) {
        if (y<0 || y>=rows || x<0 || x>=cols) return 0;
        if (visited[y][x]) return 0;
        if (m[y][x] == '.') return 0;
        int count = 1;
        visited[y][x] = true;
        count += t(y-1, x);
        count += t(y+1, x);
        count += t(y, x+1);
        count += t(y, x-1);
        count += t(y-1, x-1);
        count += t(y+1, x+1);
        count += t(y-1, x+1);
        count += t(y+1, x-1);
	
        return count;
    }
   
    // -----------------------------------------------------------
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
	for (int i = 0; i < n; i++) {
            rows = in.nextInt();
            cols = in.nextInt();
            m = new char[rows][cols];
            visited = new boolean[rows][cols];
            for (int j=0; j<rows; j++)
                m[j] = in.next().toCharArray();
	    int max = 0;
	    for (int r = 0; r < rows; r++) {
		for (int c = 0; c < cols; c++) {
		    max = Math.max(max, t(r, c));
		}
	    }
	    System.out.println(max);  
	}
 
    }
   
}