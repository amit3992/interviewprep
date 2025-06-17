package com.interviewprep.heaps;

import java.util.*;

public class TopKWords {

    public List<String> topKFrequent(String[] words, int k) {
        // 1. Count frequency
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // 2. Min Heap with custom comparator
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int freqCompare = freqMap.get(w1) - freqMap.get(w2);
            if (freqCompare == 0) {
                return w2.compareTo(w1); // reverse lexicographical
            }
            return freqCompare;
        });

        // 3. Keep top K in the heap
        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 4. Build result from heap (reversed)
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        TopKWords topKWords = new TopKWords();
        System.out.println(topKWords.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
