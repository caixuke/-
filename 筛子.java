import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int a = 1, b = 2, c = 3, d = 4, e = 5, f = 6, i = 0;
		while(i < str.length()){
			if(str.charAt(i) == 'L'){
				int tmp = a;
				a = e;
				e = b;
				b = f;
				f = tmp;
			}else if(str.charAt(i) == 'R'){
				int tmp = b;
				b = e;
				e = a;
				a = f;
				f = tmp;
			}else if(str.charAt(i) == 'F'){
				int tmp = c;
				c = e;
				e = d;
				d = f;
				f = tmp;
			}else if(str.charAt(i) == 'B'){
				int tmp = c;
				c = f;
				f = d;
				d = e;
				e = tmp;
			}else if(str.charAt(i) == 'A'){
				int tmp = a;
				a = d;
				d = b;
				b = c;
				c = tmp;
			}else{
				int tmp = a;
				a = c;
				c = b;
				b = d;
				d = tmp;
			}
			i++;
		}
		System.out.println(a*100000+b*10000+c*1000+d*100+e*10+f);
	}

	
}