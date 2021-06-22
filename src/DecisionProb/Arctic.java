package DecisionProb;

import java.util.Arrays;
import java.util.Scanner;

public class Arctic {

    public static int[] check;
    public static int C,N;

    public static void decision(double[][] temp, int i, double gap)
    {
        double a;
        double b;

        for(int j = 1; j < temp.length; j++)
        {
            if(i == j) continue;

            a = temp[i][0] - temp[j][0];
            b = temp[i][1] - temp[j][1];

            if( Math.sqrt( (a * a) + (b * b) ) <= gap )
            {
                if(check[j] == 0)
                {
                    check[j] = 1;
                    decision(temp, j, gap);
                }
            }
        }


    }

    public static double optimize(double[][] temp, double low, double high)
    {
        double mid;
        int k;

        for(int i = 0; i < 100; i++)
        {
            Arrays.fill(check, 0);
            mid = ( low + high) / 2;
            decision(temp, 0, mid);
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
        double[][] temp;

        for(int i = 0; i < C; i++)
        {
            N = sc.nextInt();
            temp = new double[N][2];
            check = new int[N];

            for(int j = 0; j < N; j++)
            {
                temp[j][0] = sc.nextDouble();
                temp[j][1] = sc.nextDouble();
            }

            System.out.printf("%.2f\n", optimize(temp, 0, 1000*Math.sqrt(2) + 10));
        }
    }


}


