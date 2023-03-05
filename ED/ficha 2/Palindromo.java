import java.util.Scanner;

public class Palindromo {

    static String StringFormattingINATOR(String m) {
	m = m.toLowerCase();
	for (int i = 0; i < m.length(); i++) {
	    char c = m.charAt(i);
	    if (!Character.isLetter(c))
		m = m.replace(c, ' ');
	}
	m = m.replaceAll(" ","");
	return m;
    }

    static Boolean isPalindrome(String b) {
	int middle = b.length()/2 - b.length()%2;
	if (b.charAt(0) != b.charAt(b.length()-1))
		return false;
	for (int i = 1; i <= middle; i++) {
	    if (b.charAt(i) != b.charAt(b.length() - i - 1))
		return false;
	}
	return true;
    }

    public static void main(String[] args) {
	
	Scanner stdin = new Scanner(System.in);
	int n = stdin.nextInt();
	System.out.println(n);
	String s = stdin.nextLine();
	while (stdin.hasNextLine()) {

	    s = stdin.nextLine();
	    String newstring = StringFormattingINATOR(s);
	    if (isPalindrome(newstring)) 
	        System.out.println("sim");
	    else
		System.out.println("nao");

	}
    }
}