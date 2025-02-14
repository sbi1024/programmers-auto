import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V, E, SUM;
    static Edge[] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        parent = new int[V + 1]; // 정점 배열 초기화
        edges = new Edge[E]; // 간선 배열 초기화

        // 간선 리스트 입력 처리
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int co = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(v1, v2, co);
        }

        makeSet();

        Arrays.sort(edges, (o1, o2) -> o1.c - o2.c);
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if (union(edge.v1, edge.v2)) {
                SUM += edge.c;
                count++;
                if (count == V - 1) {
                    break;
                }
            }
        }

        System.out.println(SUM);
    }

    static void makeSet() {
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    static boolean union(int x, int y) {
        int findX = findSet(x);
        int findY = findSet(y);
        if (findX == findY) return false;
        if (findX < findY) parent[findY] = findX;
        else parent[findX] = findY;
        return true;
    }


    static class Edge {
        int v1, v2, c;

        public Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "v1=" + v1 +
                    ", v2=" + v2 +
                    ", c=" + c +
                    '}';
        }
    }
}