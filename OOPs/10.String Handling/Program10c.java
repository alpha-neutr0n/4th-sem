//Splitting a string into number of substrings using split() method.

public class Main{

    public static void main(String args[]){

        String s = "Ma;ni,kh;a#n$th";
        String[] str = s.split("[,;#$]");

        //Total how many substrings? The array length
        System.out.println("Number of substrings: "+str.length);

        for (int i=0; i < str.length; i++) {
            System.out.println("Str["+i+"]:"+str[i]);
        }
    }
}
