package PaternSyntaxChecker;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var testsNumber = Integer.parseInt(sc.nextLine());
        
        while (testsNumber > 0) {
            var pattern = sc.nextLine();
            
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
                
            } catch (Exception e) {
                System.out.println("Invalid");
            }
            
            testsNumber--;
        }
    }
}
