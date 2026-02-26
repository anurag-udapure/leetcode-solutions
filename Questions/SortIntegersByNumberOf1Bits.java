class Solution {
    public int[] sortByBits(int[] arr) {
        Integer []wrapped = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(wrapped,(a,b) -> Integer.bitCount(a) == Integer.bitCount(b)? a - b : Integer.bitCount(a) - Integer.bitCount(b));
        return Arrays.stream(wrapped).mapToInt(Integer :: intValue).toArray();
    }
}