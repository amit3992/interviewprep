package com.interviewprep.greedy;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            if (totalGas < totalCost) {
                totalGas = 0;
                totalCost = 0;
                start = i + 1;
            }
        }
        return totalGas >= totalCost ? start : -1;
    }

    public static void main(String [] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(new int[]{5,2,0,3,3}, new int[]{1,5,5,1,1}));
    }
}
