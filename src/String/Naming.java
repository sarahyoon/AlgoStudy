package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Naming {

    public static void main(String args[] ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();

        String father = br.readLine();
        String mother = br.readLine();

        String name = sb.append(father).append(mother).toString();

        sb = new StringBuffer();

        int[] fail = new int[400001];
        int len = name.length();
        int j = 0;
        for(int i = 1; i < len; i++)
        {
            while(j > 0 && name.charAt(i) != name.charAt(j))
                j = fail[j-1];

            if(name.charAt(i) == name.charAt(j))
                fail[i] = ++j;
        }

        int k = len;
        while(k > 0)
        {

            sb.insert(0, new StringBuffer().append(k).append(' ').toString());
            k = fail[k-1];
        }

        System.out.println(sb.toString());
    }
}
