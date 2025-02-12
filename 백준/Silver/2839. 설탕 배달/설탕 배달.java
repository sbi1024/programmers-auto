import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int count = 0 ;
		
		while(true){
			if(a%5==0) {
				System.out.println(a/5+count);
				break;
				}else if(a<=0){
					System.out.println("-1");
					break;
				}
			a=a-3;
			count++;
			}
		
		}
	
	}
