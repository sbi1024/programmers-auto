import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value1 = Integer.parseInt(br.readLine());
        int value2 = Integer.parseInt(br.readLine());
        int value3 = Integer.parseInt(br.readLine());

        if ((value1 == 60) && (value2 == 60) && (value3 == 60)) {
            System.out.println("Equilateral");
        } else if ((value1 + value2 + value3) == 180) {
            if (value1 != value2 && value2 != value3 && value1 != value3) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        } else if ((value1 + value2 + value3) != 180){
            System.out.println("Error");
        }
    }
}