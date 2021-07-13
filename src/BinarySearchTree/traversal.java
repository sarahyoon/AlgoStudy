package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class traversal {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
            for (int i = 0; i < testCase; i++) {
                int n = scan.nextInt();
                ArrayList<Integer> preorder = new ArrayList<Integer>();
                ArrayList<Integer> inorder = new ArrayList<Integer>();

                for (int j = 0; j < n; j++) {
                    preorder.add(scan.nextInt());
                }
                for (int j = 0; j < n; j++) {
                    inorder.add(scan.nextInt());
                }
                printPostOrder(preorder, inorder);
            }
    }


    static void printPostOrder(List preorder, List inorder) {
        int N = preorder.size();

        if (preorder.isEmpty())
            return;

        int root = (int)preorder.get(0);
        int L = inorder.indexOf(root);

        printPostOrder(preorder.subList(1, L+1), inorder.subList(0, L));
        printPostOrder(preorder.subList(L+1, N), inorder.subList(L+1, N));

        System.out.print(root + " ");

    }
}
