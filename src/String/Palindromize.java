package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromize
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int testCase = Integer.parseInt(br.readLine());

        for(int t=0;t<testCase;t++)
        {
            String str = br.readLine();
            String rev = new StringBuffer().append(str).reverse().toString();

            int len = str.length();
            int j = 0;

            int[] fail = new int[100001];

            for(int i=1; i<len; i++)
            {
                while(j > 0 && rev.charAt(i) != rev.charAt(j))
                    j = fail[j-1];

                if(rev.charAt(i) == rev.charAt(j))
                    fail[i] = ++j;
            }

            int begin = 0, matched = 0;

            while(begin < len)
            {
                if(matched < len && str.charAt(begin + matched) == rev.charAt(matched))
                {
                    ++matched;
                    if(begin + matched == len)
                    {
                        sb.append(2*len - matched).append('\n');
                        break;
                    }
                }
                else
                {
                    if(matched == 0)
                        ++begin;
                    else {
                        begin += matched - fail[matched-1];
                        matched = fail[matched-1];
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }
}


