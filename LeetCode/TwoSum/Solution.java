package TwoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        // 暴力方法 两层循环
        int[] res = m1(nums, target);

        // 使用hash表 两遍
//        int[] res = m2(nums, target);

        // 使用hash表 1遍
//        int[] res = m3(nums, target);
        System.out.println(Arrays.toString(res));

    }

    private static int[] m3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int n2 = target - nums[i];
            if (map.containsKey(n2)){
                return new int[]{map.get(n2), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    private static int[] m2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i ++){
            int n2 = target - nums[i];
            if (n2 != nums[i] && map.get(n2) != null){
                return new int[]{i, map.get(n2)};
            }
        }
        return new int[2];
    }

    private static int[] m1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i+ 1; j < nums.length; j ++){
                if (nums[i] != nums[j] && (nums[i] + nums[j]) == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }


}
