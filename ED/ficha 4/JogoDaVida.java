import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	rows = r;
	cols = c;
	m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
	for (int i=0; i<rows; i++)
	    m[i] = in.next().toCharArray();
    }
    
    // Metodo para escrever a matriz m[][]                                      23
    public void write() {
	for (int i = 0; i < rows; i++)
	    System.out.println(m[i]);
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)        29
    public int countAlive(int y, int x) {
	int count = 0, xx = -1, yy = -1, n = 3, b = 3;
	
	for (int i = 0; i < n; yy++, i++) {
	    if (y == 0 && i == 0) {yy = 0; n -=1;}
	    if (x == 0 && i == 0) {xx = 0; b -=1;}
	    for (int j = 0; j < b; xx++, j++) {
		if (y == rows-1 && j == 0 && i == 0) {n -=1;}
		if (x == cols-1 && j == 0 && i == 0) {b -=1;}

		//System.out.println("coordenadas = " + (y) + ", " + (x));
		//System.out.println("coordenadas verif = " + (y+yy) + ", " + (x+xx));
		//System.out.println(m[y+yy][x+xx]);

		if (m[y+yy][x+xx] == ALIVE && !(xx == 0 && yy == 0))    //      41
		    count++;

		//System.out.println(count);
	    }
	if (x == 0) {xx = 0;}
	else {xx = -1;}
	}
	//System.out.println(count);
	return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
	char m2[][] = new char[rows][cols];
	for (int i = 0; i < rows; i++) {
	//System.out.println("linha " + i);
	    for (int j = 0; j < cols; j++) {
		int q = countAlive(i, j);
		if ((q == 0) || (q == 1) || (q >= 4))
		    m2[i][j] = DEAD;

		if (q == 3)
		    m2[i][j] = ALIVE;

		if ((m[i][j] == ALIVE) && (q == 2))
		    m2[i][j] = ALIVE;

		if ((m[i][j] == DEAD) && (q == 2))
		    m2[i][j] = DEAD;
		

		/*if (i == 2 && j == 2) {
		    System.out.println("coordenadas = " + i + ", " + j);
		    System.out.println(countAlive(i, j));
		    System.out.println(m2[i][j]);
		    for (int a = 0; a < rows; a++)
	    		System.out.println(m2[a]); }*/

	    }
	
	}
	m = m2;
    }
}

public class JogoDaVida {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);

	// Ler linhas, colunas e numero de iteracoes
	int rows = in.nextInt();
	int cols = in.nextInt();
	int n    = in.nextInt();

	// Criar objecto para conter o jogo e ler estado inicial
	Game g = new Game(rows, cols);
	g.read(in);

	//g.write();

	for (int i = 0; i < n; i++)
	    g.iterate();
	g.write();
    }
}