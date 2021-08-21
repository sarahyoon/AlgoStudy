public class LC_509_FibonacciNum {

    static int[] memo;
    public static void main(String[] args){

         int ans = 0;

         //ans = fib(4);
        ans = memoization(4);
        System.out.println(ans);

    }

    static int fib(int n){

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    static int memoization(int n){

        if(n<1){
            return n;
        }

        memo = new int[n+1];
        memo[1] = 1;

        for(int i=2;i<=n;i++){

            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

}
