package BruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class picnic {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        int num_of_std =0;
        int f_pair = 0;
        String friends = "";

        for(int i=0;i<testCase;i++){
            scan.nextLine();

            String cases = scan.nextLine();

            num_of_std = Integer.parseInt(cases.split(" ")[0]);
            f_pair = Integer.parseInt(cases.split(" ")[1]);
            friends = scan.nextLine();

            solve(num_of_std, f_pair, friends);
        }

    }

    public static int solve(int num_of_std, int f_pair, String friends){

        int team = num_of_std/2;

        if(team == f_pair){
            return 1;
        }

        List<List> friend = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        //make pair
        String[] arr = friends.split(" ");
        for(int i=0;i<arr.length-1; i+=2){
            int f = Integer.parseInt(arr[i]);
            int f_p = Integer.parseInt(arr[i+1]);

            List<Integer> pair = new ArrayList<>();
            if(f<f_p){
                pair.add(f);
                pair.add(f_p);
            }
            else{
                pair.add(f_p);
                pair.add(f);
            }
            friend.add(pair);
            sum.add(f+f_p);

        }

        int answer = 0;
        int tot = (num_of_std-1 * num_of_std)/2;

        //1. sum list에 있는 숫자들 중에 team의 갯수만큼 뽑아 tot를 만들 수 있는 모든 경우의 수를 구하기
        //2. 만들수 있는 경우의 수를 구할 때, 각각의 인덱스에 해당하는 friend의 페어들을 확인하여 중복되는 숫자가 없는지 확인
        //3. 중복되는 숫자가 없으면 answer++



        return 0;
    }

    public static void find(int team, List friend, List sum, int answer, int tot, int temp){




    }
}
