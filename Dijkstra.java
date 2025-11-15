import java.util.*;

class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        int[] dist = new int[n];
        int[] vis = new int[n];

        for (int i = 0; i < n; i++)
            dist[i] = cost[src][i];
        dist[src] = 0;
        vis[src] = 1;

        for (int k = 1; k < n; k++) {
            int min = 999, u = 0;
            for (int i = 0; i < n; i++)
                if (vis[i] == 0 && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            vis[u] = 1;

            for (int v = 0; v < n; v++)
                if (vis[v] == 0 && dist[u] + cost[u][v] < dist[v])
                    dist[v] = dist[u] + cost[u][v];
        }

        System.out.println("\nShortest Distances:");
        for (int i = 0; i < n; i++)
            System.out.println("To " + i + " = " + dist[i]);
    }
}
