package com.myschool.model;

public class PlayResponse {

    private boolean result;

    private int currentScore;

    private int total;

    private Word nextWord;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Word getNextWord() {
        return nextWord;
    }

    public void setNextWord(Word nextWord) {
        this.nextWord = nextWord;
    }
}
