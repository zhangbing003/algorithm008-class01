package climbingStairs;

public class Solution {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。
     * 你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     */
    public static void main(String[] args) {
        System.out.println(climbStairs2(9));
    }

    public static int climbStairs2(int n) {
        int[] cache = new int[n];
        return climbStair2(0, n, cache);
    }

    /**
     * 暴力递归
     * @param n
     * @return
     */
    public static int climbStair2(int level, int n, int[] cache) {
        if (level > n){
            return 0;
        }
        if (level == n){
            return 1;
        }
        int cacheVal = cache[level];
        if (cacheVal > 0){
            return cacheVal;
        } else {
            cache[level] = climbStair2(level + 1, n, cache) + climbStair2(level + 2, n, cache);
            return cache[level];
        }

    }

    public static int climbStairs(int n) {
        return climbStair1(0, n);
    }

    /**
     * 暴力递归
     * @param n
     * @return
     */
    public static int climbStair1(int level, int n) {
        if (level > n){
            return 0;
        }
        if (level == n){
            return 1;
        }
        return climbStair1(level + 1, n) + climbStair1(level + 2, n);
    }
}
