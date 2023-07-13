package Anagrans;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
            Scanner scan = new Scanner(System.in);
            String a = scan.next();
            String b = scan.next();
            scan.close();
            boolean ret = isAnagram(a, b);
            System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        }
    
    static boolean isAnagram(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() != b.length()) return false;
        
        HashMap<Character, Integer> charsMapA = new HashMap<>();
        HashMap<Character, Integer> charsMapB = new HashMap<>();
        
        for (int i = 0; i < a.length(); i++) {
            if (!processCurrentChar(charsMapA, a, b, i)) return false;
            if (!processCurrentChar(charsMapB, b, a, i)) return false;
        }
        
        for (Character key: charsMapA.keySet()) {
            Integer countA = charsMapA.get(key);
            Integer countB = charsMapB.get(key);
            
            if (countA != countB) return false;
        }
        
        return true;
    }
    
    static boolean processCurrentChar(
        HashMap<Character, Integer> map, String textA, String textB, int index
        ) {
        Character aChar = textA.charAt(index);
        
        if (!textB.contains(aChar.toString())) return false;
        addToMap(map, aChar);
        return true;
    }

  static void addToMap(HashMap<Character, Integer> map, Character key) {
    if (map.containsKey(key)) {
            Integer count = map.get(key);
            map.put(key, ++count);
        } else {
            map.put(key, 1);                
        }
}
}
