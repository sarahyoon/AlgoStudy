package BinarySearch;

import java.io.*;
import java.util.*;

    public class  Loan {
        static double n,p;
        static int m;
        public static void main(String[] args)throws Exception {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;
            int T = Integer.parseInt(br.readLine());

            for(int tc =1; tc<=T; tc++) {
                st = new StringTokenizer(br.readLine());
                n= Double.parseDouble(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                p = Double.parseDouble(st.nextToken());
                System.out.println(payment(n,m,p));
            }
        }
        static double balance(double amount, int duration, double rates, double monthlyPament) {
            double balance = amount;
            for(int i=0; i<duration; ++i) {
                //이자가 붙는다.
                balance*= (1.0 + (rates/12.0)/100.0);
                //상환액을 잔금에서 제한다.
                balance -= monthlyPament;
            }
            return balance;
        }
        static double payment(double amount, int duration, double rates) {
            //불변조건
            //1. lo원씩 갚으면 duration개월 안에 갚을수 없다.
            //2. hi원씩 갚으면 duration개월 안에 갚을 수 잇다.
            double lo =0, hi = amount*(1.0+ (rates/12.0)/100.0);
            for(int iter = 0; iter<50; ++iter) {
                double mid = (lo+hi)/2.0;
                if(balance(amount, duration, rates, mid)<=0) {
                    hi= mid;
                }else {
                    lo =mid;
                }
            }
            return hi;
        }
    }
