import java.util.Scanner;

class Matrix {
    int data[][];
    int rows;
    int cols;

    Matrix(int r, int c) {
	data = new int[r][c];
	rows = r;
	cols = c;
    }

    public void read(Scanner in) {
	for (int i=0; i<rows; i++)
	    for (int j=0; j<cols; j++)
		data[i][j] = in.nextInt();
    }

    public static Matrix identity(int n) {
	Matrix m = new Matrix(n, n);
	for (int i=0; i<n; i++) {
	    for (int j=0; j<n; j++)
		m.data[i][j] = 0;
	    m.data[i][i] = 1;
	}
	return m;
    }

    public Matrix transpose() {
	int save;
	Matrix m = new Matrix(cols, rows);
	for (int i=0; i<rows; i++) {
	    for (int j=0; j<cols; j++) {
		m.data[j][i] = data[i][j];
	    }
	}
	return m;
    }

    public Matrix sum(Matrix m) {
	for (int i=0; i<rows; i++) {
	    for (int j=0; j<cols; j++)
		m.data[i][j] = data[i][j] + m.data[i][j];
	}
	return m;
    }

    public Matrix multiply(Matrix m) {
	Matrix n = new Matrix(rows, m.cols);
	for (int i=0; i<n.rows; i++)
	    for (int j=0; j<n.cols; j++)
		n.data[i][j] = 0;

	for (int i=0; i<rows; i++) {
	    for (int j=0; j<m.cols; j++) {
		for (int a=0; a<cols; a++) {
		    n.data[i][j] = n.data[i][j] + (data[i][a] * m.data[a][j]);
		}
	    }
	}
	return n;
    }

    public String toString() {
	String ans = "";
	for (int i=0; i<rows; i++) {
	    for (int j=0; j<cols; j++)
		ans += data[i][j] + " ";
	    ans += "\n";
	}
	return ans;
    }
}