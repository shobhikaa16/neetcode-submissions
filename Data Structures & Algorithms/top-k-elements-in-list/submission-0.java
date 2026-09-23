class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // freq -> list of numbers
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        // Get top K
        int[] ans = new int[k];
        int index = 0;

        for (int freq = bucket.length - 1; freq >= 0 && index < k; freq--) {

            if (bucket[freq] != null) {

                for (int num : bucket[freq]) {
                    ans[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}