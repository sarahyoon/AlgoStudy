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
        String answer = "";

        for(int i=0;i<testCase;i++){

            int n = scan.nextInt();
            k = scan.nextInt();

            list = new ArrayList<>();
            for(int idx=1;idx<=n;idx++){
                list.add(idx);
            }

            int cur = 0;

            list.remove(0);
            cur = cur+k-1;
            josephus(cur);


            if(list.get(0)<list.get(1)){
                answer += list.get(0) + " " + list.get(1) + "\n";
            }
            else{
                answer  += list.get(1) + " " + list.get(0) + "\n";
            }
        }
        System.out.print(answer);
    }

    public static void josephus(int cur){

        if(list.size() == 2){
            return;
        }

        //remove
        list.remove(cur);

        if(cur+k-1>=list.size()){
            cur= (k-(list.size()-1-cur)-1)-1;
        }else{
            cur = cur+k-1;
        }

        josephus(cur);

    }
}
