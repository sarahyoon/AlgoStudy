public class LC_338_CountingBits {

    static int count = 0;

    public static void main(String[] args){

        int n = 5;
        int[] ans = new int[n+1];

        for(int i=0;i<=n;i++){
            countingBits(i);
            ans[i] = count;
            count=0;
        }

        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+", ");
        }

    }

    static void countingBits(int n){
        if(n==1){
            count++;
        }
        if(n>1){
            if(n%2 == 1){
                count++;
            }
            countingBits(n/2);
        }
    }
}
