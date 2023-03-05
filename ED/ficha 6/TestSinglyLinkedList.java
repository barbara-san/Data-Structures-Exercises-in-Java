public class TestSinglyLinkedList {
   public static void main(String[] args) {

      // Criacao de lista de inteiros
      SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

      // Adicionando numeros de 1 a 5 ao final da lista
      for (int i=1; i<=7; i++)
         list.addLast(i);
      //System.out.println(list);
/*
      // Adicionando numeros de 6 a 10 ao inicio da lista
      for (int i=6; i<=10; i++)
         list.addFirst(i);
      //System.out.println(list);

      // Verificando o tamanho da lista
      System.out.println("size = " + list.size());

      // Retirando o primeiro elemento
      list.removeFirst();
      System.out.println(list);

      // Retirando o ultimo elemento
      list.removeLast();
      System.out.println(list);

      // Verificando se esta vazia
      System.out.println("isEmpty? " + list.isEmpty());

      // Escreve o primeiro e ultimo elementos
      System.out.println("getFirst() = " + list.getFirst());
      System.out.println("getLast() = " + list.getLast());

	//1 
	System.out.println("get(0) = " + list.get(0));
	System.out.println("get(6) = " + list.get(6));
	System.out.println("get(-1) = " + list.get(-1));

	//2
	System.out.println(list);
	System.out.println("remove(0) = " + list.remove(0));
	System.out.println(list);
	System.out.println("remove(2) = " + list.remove(2));
	System.out.println(list);
	System.out.println("remove(-1) = " + list.remove(-1));
	System.out.println(list);
*/
	//3
	SinglyLinkedList<Integer> newList = list.copy();
	System.out.println(newList);
	
	//4
	System.out.println(newList.size());
	newList.duplicate();
	System.out.println(newList);
	System.out.println(newList.size());

	//5
	newList.removeAll(4);
	System.out.println(newList);

   }
}
