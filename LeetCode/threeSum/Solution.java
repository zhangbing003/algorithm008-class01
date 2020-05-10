package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     */

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        // 暴力 三层循环 (未解决重复问题)
//        System.out.println(threeSum1(nums));

        // 排序+双指针
        System.out.println(threeSum2(nums));



    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // 数组排序
        for (int x = 0; x < nums.length - 2; x ++){
            if (nums[x] > 0) break; // 右面都是更大的数
            if (x > 0 && nums[x] == nums[x -1]) continue; //去重
            int i = x + 1, j = nums.length - 1;
            while (i < j){
                int sum = nums[x] + nums[i] + nums[j];
                if (sum > 0){
                    while (i < j && nums[j] == nums[--j]);
                } else if (sum < 0){
                    while (i < j && nums[i] == nums[++i]);
                } else {
                    res.add(Arrays.asList(nums[x], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return res;
    }

}
