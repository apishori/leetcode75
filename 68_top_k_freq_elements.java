import java.util.*;
/*
Create frequency map and use a minheap to store k most freq elements.
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );
        
        int c = 0;
        for(int val : freq.keySet()) {
            pq.add(val);
            if(c++ >= k) pq.poll();
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; ++i) res[i] = pq.poll();
        return res;
    }
}