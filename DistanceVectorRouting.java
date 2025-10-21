import java.util.*;

public class DistanceVectorRouting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Input cost matrix
        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix (999 for no direct link):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        // Initialize distance and next-hop tables
        int[][] dist = new int[n][n];
        int[][] nextHop = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = cost[i][j];
                nextHop[i][j] = j;
            }
        }

        // Distance Vector Algorithm
        boolean updated;
        do {
            updated = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (dist[i][j] > cost[i][k] + dist[k][j]) {
                            dist[i][j] = cost[i][k] + dist[k][j];
                            nextHop[i][j] = nextHop[i][k];
                            updated = true;
                        }
                    }
                }
            }
        } while (updated);

        System.out.println("\nRouting tables:");
        for (int i = 0; i < n; i++) {
            System.out.println("\nFor node " + i + ":");
            System.out.println("Destination\tNext Hop\tDistance");
            for (int j = 0; j < n; j++) {
                System.out.println(j + "\t\t" + nextHop[i][j] + "\t\t" + dist[i][j]);
            }
        }

        sc.close();
    }
}