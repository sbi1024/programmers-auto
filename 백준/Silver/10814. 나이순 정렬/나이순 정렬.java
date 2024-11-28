import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BufferedWriter, StringBuilder 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int forCount = Integer.parseInt(br.readLine());
        Member[] members = new Member[forCount];
        for (int i = 0; i < forCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(members, (o1, o2) -> {
            if (o1.age != o2.age) {
                return o1.age - o2.age;
            } else {
                return o1.index - o2.index;
            }
        });

        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Member {
        int age;
        String name;
        int index;

        public Member(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
}