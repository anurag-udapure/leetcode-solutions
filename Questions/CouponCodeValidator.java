import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        int n = code.length;

        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        List<String[]> valid = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (!isActive[i]) continue;

            if (!order.containsKey(businessLine[i])) continue;

            if (code[i].isEmpty()) continue;

            if (!code[i].matches("[a-zA-Z0-9_]+")) continue;

            valid.add(new String[]{businessLine[i], code[i]});
        }

        Collections.sort(valid, (a, b) -> {
            int cmp = order.get(a[0]) - order.get(b[0]);
            if (cmp != 0) return cmp;
            return a[1].compareTo(b[1]);
        });

        List<String> result = new ArrayList<>();
        for (String[] v : valid) {
            result.add(v[1]);
        }

        return result;
    }
}