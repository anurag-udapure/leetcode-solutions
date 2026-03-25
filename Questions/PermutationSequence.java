class Solution {
    public String getPermutation(int n, int k) {
        // Step 1: store numbers
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);

        // Step 2: make k zero-based
        k = k - 1;

        StringBuilder ans = new StringBuilder();

        while (true) {
            int index = k / fact;
            ans.append(numbers.get(index));
            numbers.remove(index);

            if (numbers.size() == 0) break;

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans.toString();
    }
}   