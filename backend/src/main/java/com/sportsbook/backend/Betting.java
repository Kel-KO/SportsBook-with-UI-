package com.sportsbook.backend;

import java.util.*;

public class Betting {
    public static List<String> simulateBet(String bet, float stake) {
        double spread = 7.5;
        String[] game = {"Lakers", "Lakers", "Lakers", "Clippers", "Clippers"};
        Random rand = new Random();
        String winner = game[rand.nextInt(game.length)];
        int margin = rand.nextInt(20) + 1;

        float winnings;
        List<String> result = new ArrayList<>();

        switch (bet) {
            case "LakersLine":
                if (winner.equals("Lakers")) {
                    winnings = stake * (100f / 110);
                    result.add("W");
                    result.add(Float.toString(winnings + stake));
                } else {
                    result.add("L");
                    result.add("0");
                }
                break;
            case "ClippersLine":
                if (winner.equals("Clippers")) {
                    winnings = stake * (200f / 100);
                    result.add("W");
                    result.add(Float.toString(winnings + stake));
                } else {
                    result.add("L");
                    result.add("0");
                }
                break;
            case "LakersSpread":
                if (winner.equals("Lakers") && margin > spread) {
                    winnings = stake * (110f / 100);
                    result.add("W");
                    result.add(Float.toString(winnings + stake));
                } else {
                    result.add("L");
                    result.add("0");
                }
                break;
            default: // ClippersSpread
                if (winner.equals("Clippers") || margin < spread) {
                    winnings = stake * (110f / 100);
                    result.add("W");
                    result.add(Float.toString(winnings + stake));
                } else {
                    result.add("L");
                    result.add("0");
                }
                break;
        }

        return result;
    }
}
