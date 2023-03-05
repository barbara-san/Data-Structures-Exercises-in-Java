import java.util.Scanner;

public class TestBTree {
    public static void main(String[] args) {
        // Ler arvore de inteiros em preorder
        Scanner in = new Scanner(System.in);
        BTree<Integer> t = LibBTree.readIntTree(in);

        System.out.println(t.nodesLevel(0));
	System.out.println();
	System.out.println(t.nodesLevel(1));
	System.out.println();
	System.out.println(t.nodesLevel(2));
	System.out.println();
	System.out.println(t.nodesLevel(3));
    }
}