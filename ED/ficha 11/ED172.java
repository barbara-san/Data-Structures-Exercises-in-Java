import java.util.LinkedList;
import java.util.Scanner;

public class ED172 {
   
    public static void main(String[] args) {
    
        BSTMap<String,Integer> map = new BSTMap<String,Integer>();
     
	Scanner s = new Scanner(System.in);
	while (s.hasNext()) {
	    String n = s.next();
	    if (map.get(n) != null) map.put(n, map.get(n) + 1);
	    else if (map.get(n) == null) map.put(n, 1);
	}
          
        LinkedList<String> keys = map.keys();
        for (String k : map.keys())
            System.out.println(k + ": " + map.get(k));

    }
}