import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        // Step 2: Get adjacency matrix
        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix (0 if no direct edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0 && i != j)
                    cost[i][j] = Integer.MAX_VALUE;
            }
        }

        // Step 3: Get source vertex
        System.out.print("Enter source vertex (0 to " + (n - 1) + "): ");
        int src = sc.nextInt();

        int[] dist = new int[n]; // shortest distance from source
        int[] visited = new int[n]; // 1 if visited, 0 if not

        // Step 4: Initialize distances
        for (int i = 0; i < n; i++)
            dist[i] = cost[src][i];

        visited[src] = 1;
        dist[src] = 0;

        // Step 5: Dijkstra’s main logic
        for (int count = 1; count < n - 1; count++) {
            int min = 999, u = -1;

            // Find the nearest unvisited vertex
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            visited[u] = 1;

            // Update distances
            for (int v = 0; v < n; v++) {
                if (visited[v] == 0 && dist[u] + cost[u][v] < dist[v]) {
                    dist[v] = dist[u] + cost[u][v];
                }
            }
        }

        System.out.println("\nShortest distance from source " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To vertex " + i + " = " + dist[i]);
        }

        sc.close();
    }
}

//import java.util.*;
//
//public class Dijkstra {
//    public static void main(String[] args) {
//        int[][] cost = {
//                {0, 4, 0, 0, 0, 0, 0, 8, 0},
//                {4, 0, 8, 0, 0, 0, 0, 11, 0},
//                {0, 8, 0, 7, 0, 4, 0, 0, 2},
//                {0, 0, 7, 0, 9, 14, 0, 0, 0},
//                {0, 0, 0, 9, 0, 10, 0, 0, 0},
//                {0, 0, 4, 14, 10, 0, 2, 0, 0},
//                {0, 0, 0, 0, 0, 2, 0, 1, 6},
//                {8, 11, 0, 0, 0, 0, 1, 0, 7},
//                {0, 0, 2, 0, 0, 0, 6, 7, 0}
//        };
//
//        int n = cost.length;
//        int src = 0;
//        int[] dist = new int[n];
//        boolean[] visited = new boolean[n];
//
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[src] = 0;
//
//        for (int count = 0; count < n - 1; count++) {
//            int u = -1, min = Integer.MAX_VALUE;
//
//            for (int i = 0; i < n; i++) {
//                if (!visited[i] && dist[i] < min) {
//                    min = dist[i];
//                    u = i;
//                }
//            }
//
//            if (u == -1) break;
//            visited[u] = true;
//
//            for (int v = 0; v < n; v++) {
//                if (!visited[v] && cost[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
//                    dist[v] = Math.min(dist[v], dist[u] + cost[u][v]);
//                }
//            }
//        }
//
//        System.out.println("Shortest distances from source " + src + ":");
//        for (int i = 0; i < n; i++) {
//            System.out.println("Vertex " + i + ": " + dist[i]);
//        }
//    }
//}