import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		long temp = (c-b)/(a-b);
		
		if((c-b)%(a-b)!=0) {
			temp++;
			}
		System.out.println(temp);
		
	

	
		}
	
	}