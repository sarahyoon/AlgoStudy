public class LC_344_ReverseString {


    public static void main(String[] args){

        String s[] = {"h","e","l","l","o"};
        String[] ans = new String[s.length];
        //ans = reverseString(s);
        ans = twoPointers(s);

        System.out.print("[");
        for(int i=0;i<ans.length;i++){
            System.out.print( "'" + ans[i] + "'" + ",");
        }
        System.out.print("]");
    }

    //swap [1ms]
    static String[] reverseString(String[] s){

        int len = s.length;

        for(int i=0;i<len/2;i++){
            String temp = s[len-1-i];
            s[len-1-i] = s[i];
            s[i] = temp;
        }

        return s;
    }

    //two pointers[0ms]
    static String[] twoPointers(String[] s){
        int left = 0;
        int right = s.length-1;

        while(left<right){
            String temp = s[right];
            s[right] = s[left];
            s[left] = temp;

            right--;
            left++;
        }
        return s;
    }

}
