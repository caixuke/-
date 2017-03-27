import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> hSet = new HashSet<>();
        char[][] ab = new char[32][32];
        int n = in.nextInt();
        String qString = in.nextLine();
        while(n > 0){
        	String a = in.nextLine();
        	char[] b = new char[32];
        	b = a.toCharArray();
        	Arrays.sort(b);
        	a = new String(b, 0, b.length);
        	hSet.add(a);
        	n--;
        }
        System.out.println(hSet.size());
        
    }
}