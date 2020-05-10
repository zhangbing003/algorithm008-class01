package containerWithMostWater;

public class Solution {

    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     */

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};

        // 暴力 两层循环
//        System.out.println(maxArea1(height));
        // 双指针
        System.out.println(maxArea2(height));

    }

    public static int maxArea2(int[] height) {
        int max = 0;
//        for (int i = 0, j = height.length - 1; i < j;){
//            int area = (j - i) * Math.min(height[i], height[j]);
//            max = Math.max(max, area);
//            if (height[i] > height[j]){
//                j --;
//            } else {
//                i ++;
//            }
//        }
        for (int i = 0, j = height.length - 1; i < j;){
            int minHeight = height[i] > height[j] ? height[j--] : height[i++];
            int area = (j - i + 1) * minHeight;
            max = Math.max(area, max);

        }
        return max;
    }

    public static int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }




}
