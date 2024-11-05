import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputSplit = input.split(" ");
        int arrLength = Integer.parseInt(inputSplit[0]);
        int forLength = Integer.parseInt(inputSplit[1]);
        
        // result 배열 초기값 설정
        int[] result = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            result[i] = i + 1;
        }
        
        // forLength 만큼 반복문
        for (int i = 0; i < forLength; i++) {
            String forInput = sc.nextLine();
            String[] forInputSplit = forInput.split(" ");
            int firstIndex = Integer.parseInt(forInputSplit[0]);
            int secondIndex = Integer.parseInt(forInputSplit[1]);
            // swap 메소드 호출
            swap(result, firstIndex, secondIndex);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < result.length; i++) {
            sb.append(result[i]);
            if (i != result.length - 1) {
                sb.append(" ");
            }
        }
        
        System.out.println(sb);
    }
    
    public static void swap(int[] result, int firstIndex, int secondIndex) {
        int temp = result[firstIndex - 1];
        result[firstIndex - 1] = result[secondIndex - 1];
        result[secondIndex - 1] = temp;
    }
}