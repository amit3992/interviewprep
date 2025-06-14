package com.interviewprep.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidAnagram {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Set up
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Populate pCharMap
        for (char c : p.toCharArray())
            pCount[c - 'a']++;

        // Set windowSize
        int window = p.length();

        for (int i = 0; i < s.length(); i++) {

            // Expand the window
            sCount[s.charAt(i) - 'a']++;

            // Shrink the window
            if (i >= window)
                sCount[s.charAt(i - window) - 'a']--;

            // Compare arrays and add result
            if (Arrays.equals(sCount, pCount))
                result.add(i - window + 1);
        }

        return result;
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        // Set up
        int [] sCharMap = new int[26];
        for (char ch : s.toCharArray()) {
            int charLocation = ch - 'a';
            sCharMap[charLocation] += 1;
        }

        int [] tCharMap = new int[26];
        for (char ch : t.toCharArray()) {
            int charLocation = ch - 'a';
            tCharMap[charLocation] += 1;
        }

        // Validation
        for (char ch : t.toCharArray()) {
            int charLocation = ch - 'a';

            if (sCharMap[charLocation] != tCharMap[charLocation]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("ab", "a"));
    }
}
