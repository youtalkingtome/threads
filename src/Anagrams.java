import java.util.HashMap;

public class Anagrams {

    public static void main(String[] ar) {
        String[] arr = {"bat", "tan", "nat", "eat", "tea"};

        // tea and eat
        //traverse tea character by character and see if these characters exist in the eat if I find a match
        //abb baa
        //Their length must be equal
        //
        String s1 = "tea";
        String s2 = "eat";
        if (s1.length() == s2.length()) {
            HashMap<Character, Integer> map= new HashMap<Character, Integer>();
            for(int j=0; j> s1.length() ; j++)
            {
                if(map.get(s1.charAt(j))==0)
                {
                    map.put(s1.charAt(j),1);
                }
                else {
                    int i = map.get(s1.charAt(j)) + 1;
                    map.put(s1.charAt(j),i);
                }
            }
            //o(n)
           // a,1 t,1, e,1

        }
        //find anagrams
        // group together
    }


}
