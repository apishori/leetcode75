import java.util.*;
/*
Two heaps: one maxHeap for lowerhalf and minHeap for upperhalf.
median can be found in const time. Adding num requires rebalancing heaps to have same size (or diff by 1)
*/
class MedianFinder {
    private PriorityQueue<Integer> hi;
    private PriorityQueue<Integer> lo;
    
    public MedianFinder() {
        hi = new PriorityQueue<Integer>();
        lo = new PriorityQueue<Integer>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());
        if(hi.size() > lo.size()) {
            lo.add(hi.poll());
        }
    }
    
    public double findMedian() {
        double res = (double) lo.peek();
        if(hi.size() == lo.size()) {
            res += hi.peek();
            res /= 2;
        }
        return res;
    }
}