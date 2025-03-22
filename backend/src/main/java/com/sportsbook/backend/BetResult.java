package com.sportsbook.backend;

public class BetResult {
    private String result;
    private float winnings;
    private float newBalance; // <-- renamed this

    // Constructor
    public BetResult(String result, float winnings, float newBalance) {
        this.result = result;
        this.winnings = winnings;
        this.newBalance = newBalance;
    }

    // Getters and setters
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public float getWinnings() {
        return winnings;
    }

    public void setWinnings(float winnings) {
        this.winnings = winnings;
    }

    public float getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(float newBalance) {
        this.newBalance = newBalance;
    }
}
