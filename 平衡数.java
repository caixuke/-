import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int flag = 0;
        int i = 0, sum = 1, sum1 = 1;
        int[] arr = new int[32];
        if(a < 10) flag = 0; 
        else 
        {
        	while(a != 0){
        		arr[i++] = a % 10;
        		a = a / 10;
        	}
        	for(int k = 1; k < i; k++){
        		for(int j = 0; j < k; j++){
        			sum *= arr[j];
        		}
        		for(int j = k; j < i; j++){
        			sum1 *= arr[j];
        		}
        		if(sum == sum1){
        			flag = 1;
        			break;
        		}
        	}
        }
        if(flag == 0)
        	System.out.println("NO");
        else
        	System.out.println("YES");
    }
}