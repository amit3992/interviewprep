package com.interviewprep.math;

import java.util.Random;

public class ShuffleDeck {

    public void shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // Swap i & j
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public static void main(String[] args) {
        ShuffleDeck shuffleDeck = new ShuffleDeck();
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        String[] deck = new String[suits.length * ranks.length];
        int i = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[i++] = rank + suit;
            }
        }

        System.out.println("Original Deck:");
        for (String card : deck) {
            System.out.print(card + " ");
        }
        System.out.println();

        shuffleDeck.shuffleDeck(deck);

        System.out.println("Shuffled Deck:");
        for (String card : deck) {
            System.out.print(card + " ");
        }
        System.out.println();


    }
}
