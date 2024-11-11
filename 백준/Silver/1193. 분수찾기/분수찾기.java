import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int diagonal = 1;
        int total = 0;

        while (total + diagonal < X) {
            total += diagonal;
            diagonal++;
        }

        int positionInDiagonal = X - total;
        if (diagonal % 2 == 0) {
            System.out.println(positionInDiagonal + "/" + (diagonal - positionInDiagonal + 1));
        } else {
            System.out.println((diagonal - positionInDiagonal + 1) + "/" + positionInDiagonal);
        }
    }
}
