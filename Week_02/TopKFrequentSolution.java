import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
public class TopKFrequentSolution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // 统计出现次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 存入优先队列 （堆）
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            pq.add(me);
        }
        
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            res.add(pq.poll().getKey());
        }
        return res;
    }
}
