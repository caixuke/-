import java.util.Scanner;
public class Main{
	static String root = "5";
	static int cost = 0;

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		String tmp = sc.nextLine();
		int y = sc.nextInt();
		int[][] matrix = {{0,0,0,0,0,0,0},{0,0,2,10,5,3,1000},{0,1000,0,12,1000,1000,10},{0,1000,1000,0,1000,7,1000},{0,2,1000,1000,0,2,1000},{0,4,1000,1000,1,0,1000},{0,3,1000,1,1000,2,0}};
		if(y != 0){
			for (int i = 1; i <= 6; i++) {
				matrix[y][i] = 0;
				matrix[i][y] = 0;
			}
		}
		if(x == 5){
			System.out.println(0);
			System.out.println("[ ]");
		}else if(x == y){
			System.out.println(1000);
			System.out.println("[ ]");
		}else{
			if(matrix[5][x] != 1000){
				cost = matrix[5][x];
				root += ", " + x;
			}else{
				seek(matrix, 5, x, 6, cost, root);
			}
		}
			
	}
	public static void seek(int[][] matrix, int start, int end, int n, int cost, String root){
		for(int i= 1; i <= n; i++){
			if(i == start || i == 5) continue;
			cost += matrix[start][i];
			root += ", " + i;
			if(cost < 1000 && i == end) {
				System.out.println(cost);
				System.out.println("[" + root + "]");
				return;
			}
			if(cost > 1000){
				root = "[ ]";
				return;
			}
			else
				seek(matrix, i, end, n, cost, root);			
		}		
	}
	
}