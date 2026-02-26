class Solution {
    public boolean hasAllCodes(String s, int k) {
         Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }

        // total possible combinations = 2^k
        int totalPossible = 1 << k;  // same as Math.pow(2, k)

        return set.size() == totalPossible;
    }
}