package com.acme;

import javafx.util.Pair ;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Strs {
    public boolean IsPalindrom(String s) {
        char[] ac = s.toLowerCase().toCharArray();
        for (int l = 0, r = ac.length-1; l < r; l++, r--) {
            for (;l < r && !(Character.isDigit(ac[l]) || Character.isLetter(ac[l])); l++);
            for (;l < r && !(Character.isDigit(ac[r]) || Character.isLetter(ac[r])); r--);
            if (ac[l] != ac[r]) {
                return false;
            }
        }
        return  true;
    }

    public int lenLongestSubstringNoRepeatedChars(String s) {
        // sliding window
        if (s.length() <= 1)
            return s.length();

        int[] seen = new int[255];
        Arrays.fill(seen, Integer.MAX_VALUE);
        char[] chars = s.toCharArray();
        int maxLen = 0;
        for (int r = 0, l = 0; r < chars.length; r++) {
            int pos = seen[chars[r]];
            if (pos >= l && pos != Integer.MAX_VALUE) {
                l = pos +1;
            }
            seen[chars[r]] = r;
            maxLen = Math.max(maxLen,  r-l +1) ;
        }
        return maxLen;
    }

    public String longestPalindromicSubstring(String s) {
        // <--- lr ---->, shift -> , repeat
        BiFunction<Integer, Integer, Pair<String, Integer>> fn = (Integer l, Integer r) -> {
            for (; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++) ;
            return new Pair<String, Integer>(s.substring(l + 1, r), r - l - 1);
        };

        int maxLen = 0;
        String longestResult = "";
        for (int i = 0; i < s.length(); i++) {
            //  check for odd and event length
            for (Pair<String, Integer> p : Arrays.asList(fn.apply(i, i), fn.apply(i, i + 1))) {
                if (p.getValue() >= maxLen) {
                    maxLen = p.getValue();
                    longestResult = p.getKey();
                }
            }
        }
        return longestResult;
    }

    public String reverseString(String s) {
        // <--- /2-1 ----> exchange
        char[] res = s.toCharArray();
        for (int i = res.length /2 -1; i >=0; i--) {
            int idx = res.length -i-1;
            char tmp = res[i];
            res[i] = res[idx];
            res[idx] = tmp;
        }
        return new String(res);
    }

    public Boolean backSpaceEdit(String s1, String s2) {
        Function<String, String> fnBuild = (String s) -> {
            StringBuilder b = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (ch != '#') b.append(ch);
                else if (b.length() > 0) {
                    b.deleteCharAt(b.length() -1);
                }
            }
            return  b.toString();
        };
        return fnBuild.apply(s1).equals(fnBuild.apply(s2));
    }

    public Integer longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length() +1];
        for (int i = 0; i < s1.length() ; i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    void __allPermutations(char[] s, int l, int r, ArrayList<String> acc) {
        if (l ==r) {
            acc.add(new String(s));
        } else {
            for (int i = l; i <= r; i++) {
                char tmp = s[l];
                s[l] = s[i];
                s[i] = tmp;
                __allPermutations(s, l+1, r, acc);
                tmp = s[l];
                s[l] = s[i];
                s[i] = tmp;
            }
        }
    }

    public String[] allPermutations(String s) {
        ArrayList<String> acc = new ArrayList<String>();
        __allPermutations(s.toCharArray(), 0, s.length() -1, acc);
        return  acc.toArray(new String[0]);
    }

}
