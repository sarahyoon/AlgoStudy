package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Brackets2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for (int i = 0; i < testCase; i++) {

            String brackets = scan.next();

            if (isValid(brackets)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    static boolean isValid(String brackets) {

        if (brackets.length() == 0) {
            return true;
        }

        if (brackets.length() % 2 != 0) {
            return false;
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < brackets.length(); i++) {

            String bracket = String.valueOf(brackets.charAt(i));

            if ("(".equals(bracket) || "{".equals(bracket) || "[".equals(bracket)) {
                stack.push(bracket);
            }

            if (")".equals(bracket) || "}".equals(bracket) || "]".equals(bracket)) {

                if(stack.isEmpty()){
                    return false;
                }

                if ("(".equals(stack.peek()) && ")".equals(bracket)) {
                    stack.pop();
                } else if ("{".equals(stack.peek()) && "}".equals(bracket)) {
                    stack.pop();
                } else if ("[".equals(stack.peek()) && "]".equals(bracket)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }

        return false;
    }
}
