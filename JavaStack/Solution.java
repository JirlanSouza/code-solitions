package JavaStack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.Stream;

public class Solution {
    private static final Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> strings = in.lines();

        strings.map(Solution::processString).forEach(System.out::println);
    }

    private static boolean processString(String str) {
        if (!stack.isEmpty()) stack.clear();

        for (int i = 0; i < str.length(); i++) {
            char strItem = str.charAt(i);

            if (strItem == '{' || strItem == '[' || strItem == '(') {
                stack.push(strItem);
                continue;
            }

            if (stack.isEmpty()) return false;

            char lastStr = stack.pop();

            if (!isReversedStr(strItem, lastStr)){
                return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isReversedStr(char str1, char str2) {
        switch (str1) {
            case '}' -> {
                return str2 == '{';
            }
            case '{' -> {
                return str2 == '}';
            }
            case ']' -> {
                return str2 == '[';
            }
            case '[' -> {
                return str2 == ']';
            }
            case ')' -> {
                return str2 == '(';
            }
            case '(' -> {
                return str2 == ')';
            }

            default -> {
                return false;
            }
        }
    }
}
