class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        String srev = new StringBuilder(s1).reverse().toString();
        return s1.equals(srev);
    }
}
