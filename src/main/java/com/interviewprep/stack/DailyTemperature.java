package com.interviewprep.stack;

import java.util.Stack;

public class DailyTemperature {


    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prev = stack.pop();
                result[prev] = i - prev;
            }

            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperature.dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
