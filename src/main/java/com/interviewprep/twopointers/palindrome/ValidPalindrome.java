package com.interviewprep.twopointers.palindrome;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Check if the characters at the left and right pointers are not letters or digits
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }
            // Check if the characters at the left and right pointers are not equal
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {

            // Check if the characters at the left and right pointers are not letters or digits
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            while (!Character.isLetterOrDigit(s.charAt(right)) && left < right) {
                right--;
            }

            // Check if the characters at the left and right pointers are not equal
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return isPalindrome(s.substring(left + 1, right + 1)) ||
                        isPalindrome(s.substring(left, right));
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));

        System.out.println(validPalindrome.isPalindrome2("A man, a plan, a canal: Panama"));
    }
}
