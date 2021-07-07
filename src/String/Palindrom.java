package String;

import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        for(int i=0;i<testCase;i++){

            String word = scan.next();

            int count = 0;
            int end = word.length()-1;
            boolean ispalindrom = true;

            for(int j=0;j<word.length();j++){

                if(end == j){
                    break;
                }

                if(word.charAt(j) != word.charAt(end)){
                    ispalindrom = false;
                    count++;
                }
                else{
                    end--;
                    continue;
                }
            }
            if(ispalindrom){
                System.out.println(1);
            }
            else{
                System.out.println(count+word.length());
            }
        }
    }
}
