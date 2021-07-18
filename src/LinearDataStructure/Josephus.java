package LinearDataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Josephus {

    static List<Integer> list;
    static int k;
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            int n = scan.nextInt();
            k = scan.nextInt();

            list = new ArrayList<>();
            for(int idx=1;idx<=n;idx++){
                list.add(idx);
            }

            josephus(0);

            if(list.get(0)<list.get(1)){
                System.out.println(list.get(0) + " "+ list.get(1));
            }
            else{
                System.out.println(list.get(1) + " "+ list.get(0));
            }

        }
    }

    public static void josephus(int cur){

        if(list.size() == 2){
            return;
        }

        list.remove(cur);

        cur = (cur + k - 1) % list.size();

        josephus(cur);
    }
}
