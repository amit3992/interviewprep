package com.interviewprep.misc;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomSet {

    Set<Integer> set;

    public RandomSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {

        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) {
            return false;
        } else {
            set.remove(val);
            return true;
        }
    }

    public int getRandom() {
        Random rand = new Random();
        if (set.size() > 0) {
            return set.toArray(new Integer[0])[rand.nextInt(set.size())];
        }
        return 0;
    }


    public static void main(String[] args) {

    }


}
