import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums1, nums2, 0, Integer.MIN_VALUE, 0, 1, memo);
    }

    private int dfs(int[] nums1, int[] nums2, int i, int previous, int currentCount, int maxCount, Map<String, Integer> memo) {
        if (i == nums1.length) {
            return maxCount;
        }

        if(memo.containsKey(i + " " + previous + " " + currentCount + " " + maxCount)){
            return memo.get(i + " " + previous + " " + currentCount + " " + maxCount);
        }
        int result = 1;
        int remaining = Math.max(nums1.length, nums2.length) - i - 1;
        if (maxCount - currentCount > remaining) {
            memo.put(i + " " + previous + " " + currentCount + " " + maxCount, maxCount);
            return maxCount;
        }

        if(nums1[i] >= previous && nums2[i] >= previous) {
            result = dfs(nums1, nums2, i + 1, Math.min(nums1[i], nums2[i]), currentCount + 1, Math.max(currentCount + 1, maxCount), memo);
        }else {
            if (nums1[i] >= previous && nums2[i] < previous) {
                result = Math.max(dfs(nums1, nums2, i + 1, nums1[i], currentCount + 1, Math.max(currentCount + 1, maxCount), memo),
                        dfs(nums1, nums2, i + 1, nums2[i], 1, maxCount, memo));
            } else if (nums2[i] >= previous && nums1[i] < previous) {
                result = Math.max(dfs(nums1, nums2, i + 1, nums2[i], currentCount + 1, Math.max(currentCount + 1, maxCount), memo),
                        dfs(nums1, nums2, i + 1, nums1[i], 1, maxCount, memo));
            }else{
                result = dfs(nums1, nums2, i + 1, Math.min(nums1[i], nums2[i]), 1, maxCount, memo);
            }
        }

        memo.put(i + " " + previous + " " + currentCount + " " + maxCount, result);

        return result;

    }
}
