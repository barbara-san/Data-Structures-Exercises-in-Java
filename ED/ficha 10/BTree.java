public class BTree<T> {   
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }

    public int numberLeafs() {
	return numberLeafs(root);
    }

    private int numberLeafs(BTNode<T> n) {
	if (n == null) return 0;
	if (n.getLeft() == null && n.getRight() == null) return 1;
	return numberLeafs(n.getLeft()) + numberLeafs(n.getRight()); 	
    }

    public boolean strict() {
	return strict(root);
    }

    public boolean strict(BTNode<T> n) {
	if (n != null && n.getLeft() == null && n.getRight() != null) {return false;}
	else if (n != null && n.getLeft() != null && n.getRight() == null) {return false;}
	if (n == null) return true;
	return (strict(n.getLeft()) && strict(n.getRight()));
    }

    public T path(String s) {
	if (s.equals("R")) return root.getValue();
	char[] n = new char[s.length()];
	BTNode<T> cur = root;
	for (int i = 0; i < s.length(); i++) n[i] = s.charAt(i);
	for (int i = 0; i < s.length(); i++) {
	    if (n[i] == 'E') cur = cur.getLeft();
	    if (n[i] == 'D') cur = cur.getRight();
	}
	return cur.getValue();
    }

    public int nodesLevel(int k) {
	int d = depth();
	return nodesLevel(root, k, d); 	
    }

    public int nodesLevel(BTNode<T> n, int k, int d) {
	//if (k == 0) return 1;
	if (d - depth(n) == k) {System.out.println(n.getValue()); System.out.println(depth(n)); return 1;}
	if (n == null) return 0;
	return nodesLevel(n.getLeft(), k, d) + nodesLevel(n.getRight(), k, d); 	
    }

}