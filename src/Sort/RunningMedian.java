package Sort;

import java.util.*;

public class RunningMedian {

    public static int N, a, b;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();

        for (int t = 0; t < testCase; t++) {
            N = scan.nextInt();
            a = scan.nextInt();
            b = scan.nextInt();

            System.out.println(runningMedian(N, a, b));
        }
    }

    public static Long runningMedian(int N, int a, int b) {

        Comparator<Long> maxComp = new Comparator<Long>() {

            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2)
                    return -1;
                else
                    return 1;
            }
        };

        Comparator<Long> minComp = new Comparator<Long>() {

            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2)
                    return 1;
                else
                    return -1;
            }
        };

        PriorityQueue<Long> maxHeap = new PriorityQueue<>(maxComp);
        PriorityQueue<Long> minHeap = new PriorityQueue<>(minComp);

        long mod = 1983;
        Long result = 0L;

        for (int i = 0; i < N; i++) {
            if (maxHeap.size() == minHeap.size()){
                maxHeap.offer(mod);
            }
            else{
                minHeap.offer(mod);
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.element() < maxHeap.element()) {
                Long maxElement = maxHeap.poll();
                Long minElement = minHeap.poll();

                maxHeap.offer(minElement);
                minHeap.offer(maxElement);
            }

            mod = (mod * (long) a + b) % 20090711;
            result = (result + maxHeap.element()) % 20090711;
        }

        return result;
    }
}


