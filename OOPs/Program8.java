// Demonstration of Lambda Expressions

import java.io.*;
import java.util.*;
interface performOperation
{
    int check(int a);
}
class Math{
    public static int checker(performOperation p ,int num){
        return p.check(num);
    }

    performOperation checkEvenOdd()
    {
        performOperation p = (a) -> {return a%2;};
        return p;
    }
    performOperation checkPrime ()
    {
        performOperation p = (a) -> {
            if (a == 1) return 1;
            for(int i = 2;i<a/2+1;i++){
                if((a%i)==0) return 1;
            }
            return 0;
        };
        return p;
    }
    performOperation checkPalindrome()
    {
        performOperation p = (a) -> {
            String word = ""+a;
            boolean isPalindrome = true;
            for(int i = 0;i<(int)word.length()/2;i++)
            {
                if(word.charAt(i) != word.charAt(word.length()-1-i)){
                    isPalindrome = false;
                    break;
                }
            }
            return isPalindrome?0:1;
        };
        return p;
    }
}
public class Main {
    public static void main(String[] args)throws IOException {
        Math ob = new Math();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        performOperation op;
        int ret =0;
        String ans=null;
        while(T-->0){
            String s=br.readLine().trim();
            StringTokenizer st=new StringTokenizer(s);
            int ch=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken());
            if(ch==1){
                op = ob.checkEvenOdd();
                ret = ob.checker(op,num);
                ans = (ret == 0)?"EVEN":"ODD";
            }
            else if(ch==2){
                op = ob.checkPrime();
                ret = ob.checker(op,num);
                ans = (ret == 0)?"PRIME":"COMPOSITE";
            }
            else if(ch==3){
                op = ob.checkPalindrome();
                ret = ob.checker(op,num);
                ans = (ret == 0)?"PALINDROME":"NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
