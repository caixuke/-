/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(romanToInt(str));
				
	}
	public static int romanToInt(String s){
		int sum = 0, i;
		for(i = 0; i < s.length() - 1; i++){
			if(s.charAt(i) == 'M') sum += 1000;
			else if(s.charAt(i) == 'D') sum += 500;
			else if(s.charAt(i) == 'C' && s.charAt(i+1) == 'M'){
				sum += 900;
				i++;
			}
			else if(s.charAt(i) == 'C' && s.charAt(i+1) == 'D'){
				sum += 400;
				i++;
			}
			else if(s.charAt(i) == 'C') sum += 100;
			else if(s.charAt(i) == 'L') sum += 50;
			else if(s.charAt(i) == 'X' && s.charAt(i+1) == 'C'){
				sum += 90;
				i++;
			}
			else if(s.charAt(i) == 'X' && s.charAt(i+1) == 'L'){
				sum += 40;
				i++;
			}
			else if(s.charAt(i) == 'X') sum += 10;
			else if(s.charAt(i) == 'V') sum += 5;
			else if(s.charAt(i) == 'I' && s.charAt(i+1) == 'V'){
				sum += 4;
				i++;
			}
			else if(s.charAt(i) == 'I' && s.charAt(i+1) == 'X'){
				sum += 9;
				i++;
			}
			else if(s.charAt(i) == 'I') sum += 1;
		}
		if(i == s.length() - 1){
			switch (s.charAt(i))
			{
				case 'M': sum += 1000;break;
				case 'D': sum += 500;break;
				case 'C': sum += 100;break;
				case 'L': sum += 50;break;
				case 'X': sum += 10;break;
				case 'V': sum += 5;break;
				case 'I': sum += 1;break;
				default: break;
			}
		}
		return sum;
	}
}

public int romantoInt(String s){
	int nums[] = new int[s.length()];
	for(int i = 0; i < s.length(); i++){
		switch (s.charAt(i)){
			case 'M': nums[i] = 1000; break;
			case 'D': nums[i] = 500; break;
			case 'C': nums[i] = 100; break;
			case 'L': nums[i] = 50; break;
			case 'X': nums[i] = 10; break;
			case 'V': nums[i] = 5; break;
			case 'I': nums[i] = 1; break;
			default: break;
		}
	}
	int sum = 0;
	for(int i = 0; i < s.length() - 1; i++){
		if(nums[i] < nums[i+1]) sum -= nums[i];
		else sum += nums[i];
	}
	return sum + nums[nums.length - 1]
}






