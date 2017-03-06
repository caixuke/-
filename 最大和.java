/*
在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值 
输入描述:
每个测试输入包含1个测试用例，第一行包括两个整数 N 和 D :
3 <= N <= 100
1 <= D <= N
接下来有N行，每行N个数字d:
0 <= d <= 100


输出描述:
输出一个整数，表示找到的和的最大值
*/
import java.util.Scanner;

public class Main {
	public static int convert(int[][] matrix,int n, int d)
    {
		int sum = 0;
		int tmp = 0, tmp1 = 0;
		//横向、纵向
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= n - d; j++){
				for(int k = 0; k < d; k++){
					tmp += matrix[i][j + k];
					tmp1 += matrix[j + k][i];
				}
				if(tmp > sum) sum = tmp;
				if(tmp1 > sum) sum = tmp1;
				tmp = tmp1 =0;
			}
		}
		//斜向
		for(int i = 0; i <= n - d; i++){
			for(int j = 0; j <= n -d; j++){
				for(int k = 0; k < d; k++){
					tmp += matrix[i + k][j + k];
				}
				if(tmp > sum) sum = tmp;
				tmp = 0;
			}
		}
		for(int i = d - 1; i < n; i++){
			for(int j = 0; j <= n - d; j++){
				for(int k = 0; k < d; k++){
					tmp += matrix[i - k][j + k];
				}
				if(tmp > sum) sum = tmp;
				tmp = 0;
			}
		}
		
		return sum;
        
    }
	public static void main(String[] args ){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int d = scanner.nextInt();
		int[][] matrix = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				matrix[i][j] = scanner.nextInt();
		}
		System.out.println(convert(matrix, n ,d));
	}
}