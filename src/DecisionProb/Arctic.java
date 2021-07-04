package DecisionProb;

import java.util.Arrays;
import java.util.Scanner;

public class Arctic {

    public static int[] check;
    public static int C,N;

    public static void decision(double[][] dist, int i, double gap)
    {
        double a;
        double b;

        for(int j = 1; j < dist.length; j++)
        {
            if(i == j) continue;

            a = dist[i][0] - dist[j][0];
            b = dist[i][1] - dist[j][1];

            if( Math.sqrt( (a * a) + (b * b) ) <= gap )
            {
                if(check[j] == 0)
                {
                    check[j] = 1;
                    decision(dist, j, gap);
                    decision(dist, j, gap);
                }
            }
        }


    }

    public static double optimize(double[][] dist, double low, double high)
    {
        double mid;
        int k;

        for(int i = 0; i < 100; i++)
        {
            Arrays.fill(check, 0);
            mid = ( low + high) / 2;
            decision(dist, 0, mid);
            for(k = 1; k < N; k++)
            {
                if(check[k] != 1) break;
            }
            if (k == N) high = mid;
            else low = mid;

        }
        return high;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        double[][] dist;

        for(int i = 0; i < C; i++)
        {
            N = sc.nextInt();
            dist = new double[N][2];
            check = new int[N];

            for(int j = 0; j < N; j++)
            {
                dist[j][0] = sc.nextDouble();
                dist[j][1] = sc.nextDouble();
            }

            System.out.printf("%.2f\n", optimize(dist, 0, 1000*Math.sqrt(2) + 10));
        }
    }


}


