import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int a = 0, b = 0, i = 0;
		while(str.charAt(i) != ','){
			a = a * 10 + str.charAt(i) - '0';
			i++;
		}
		i++;
		while(i < str.length()){
			b = b * 10 + str.charAt(i) - '0';
			i++;
		}
		System.out.println(reverseAdd(a, b));
	}

	public static int reverseAdd(int a, int b){		
		if(a < 1 || a > 70000 || b < 1 || b > 70000)
			return -1;
		int sum1 = 0, sum2 = 0;
		while(a > 0){					
			sum1 = sum1 * 10 + a % 10;
			a = a / 10;
		}
		while(b > 0){
			sum2 = sum2 * 10 + b % 10;
			b = b / 10;
		}
		return sum1 + sum2;

	}
}