package com.acme;

import javafx.beans.binding.BooleanExpression;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrsTest {
    @Test
    void testIsPalindrome() {
        Map<String, Boolean> tests = new HashMap<String, Boolean>() {{
            put("A man, a plan, a canal: Panama" , true);
            put("race a car" , false);
            put("atbbga" , false); put("aba" , true);
            put("abba" , true); put("abs", false);
        }};
        Strs strs = new Strs();
        for (Map.Entry<String, Boolean> e : tests.entrySet()) {
            assertEquals(strs.IsPalindrom(e.getKey()), e.getValue(), e.getKey());
        }
    }

    //
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    //
    // Given a string s, find the length of the longest substring without repeating characters.
    // Sliding window
    //
    @Test
    void testLenLongestSubstringNoRepeatedChars() {
        Map<String, Integer> tests = new HashMap<String, Integer>() {{
            put("bbbbb" , 1); put("abcdef" , 6); put("abcabcbb", 3); put("pwwkew", 3);
        }};
        Strs strs = new Strs();
        for (Map.Entry<String, Integer> e : tests.entrySet()) {
            assertEquals(e.getValue(), strs.lenLongestSubstringNoRepeatedChars(e.getKey()), e.getValue());
        }
    }

    @Test
    void testLongestPalindromicSubstring() {
        Map<String, String> tests = new HashMap<String, String>() {{
            put("Geeks" , "ee"); put("forgeeksskeegfor" , "geeksskeeg");
        }};
        Strs strs = new Strs();
        for (Map.Entry<String, String> e : tests.entrySet()) {
            assertEquals(e.getValue(), strs.longestPalindromicSubstring(e.getKey()), e.getValue());
        }
    }

    @Test
    void testReverseString() {
        Map<String, String> tests = new HashMap<String, String>() {{ put("123456" , "654321"); }};
        for (Map.Entry<String, String> e : tests.entrySet()) {
            assertEquals(e.getValue(), new Strs().reverseString(e.getKey()), e.getValue());
        }
    }

    // https://leetcode.com/problems/backspace-string-compare/
    // Given two strings s and t, return true if they are equal when both are typed into empty text editors.
    // '#' means a backspace character.
    @Test
    void testBackSpaceEdit() {
       // "ab#c", "ad#c"
        Map<String[], Boolean> tests = new HashMap<String[], Boolean>() {{
            put( new String[] {"ab#c" , "ad#c"}, true);
        }};
        for (Map.Entry<String[], Boolean> e : tests.entrySet()) {
            assertEquals(e.getValue(), new Strs().backSpaceEdit(e.getKey()[0], e.getKey()[1]));
        }
    }

    @Test
    void testLongestCommonSubsequence() {
        Map<String[], Integer> tests = new HashMap<String[], Integer>() {{
            put(new String[] {"abcde" , "ace"}, 3);
            put(new String[] {"abc" , "abc"}, 3);
            put(new String[] {"abc" , "def"}, 0);
        }};
        for (Map.Entry<String[], Integer> e : tests.entrySet()) {
            assertEquals(e.getValue(), new Strs().longestCommonSubsequence(e.getKey()[0], e.getKey()[1]));
        }
    }

    //
    // Print all permutations of a given string
    //
    @Test
    void testAllPermutations() {
        assertArrayEquals(new String[] {"ABC", "ACB", "BAC", "BCA", "CBA", "CAB" } ,
                    new Strs().allPermutations("ABC"));
    }
}
