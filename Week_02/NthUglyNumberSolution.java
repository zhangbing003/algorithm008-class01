import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by zhangbing on 2020/4/26.
 */
public class NthUglyNumberSolution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int[] primes = new int[]{2,3,5};
        for (int prime : primes){
            pq.offer(prime);
            set.add(prime);
        }
        
        int num = 1;
        for (int i = 1; i < n; i ++) {
            num = pq.poll();
            for (int prize : primes){
                if (!set.contains(prize * num)){
                    set.add(prize * num);
                    pq.offer(prize * num);
                }
            }
        }
        return num;
    }
}
