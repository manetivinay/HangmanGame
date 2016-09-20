package com.example.vinaymaneti.hangmangame;

/**
 * Created by vinaymaneti on 6/19/16.
 */
public class Game {
    public static final int MAX_MISSES = 7;
    public String mHits;
    public String mMisses;
    public String mAnswer;

    public Game(String answer) {
        this.mAnswer = answer;
        this.mHits = "";
        this.mMisses = "";
    }

    public boolean applyGuess(String letters) {
        if (letters.length() == 0) {
            throw new IllegalArgumentException("No letter Found");
        }
        return applyGuess(letters.charAt(0));
    }

    public boolean applyGuess(char letter) {
        letter = validateGuess(letter);
        boolean isHit = mAnswer.indexOf(letter) >= 0;
        if (isHit)
            mHits = mHits + letter; // mHits += letter;
        else
            mMisses = mMisses + letter; // mMisses += letters;
        return isHit;
    }

    public String getCurrentProgress() {
        String progess = "";
        for (char letter : mAnswer.toCharArray()) {
            char display = '-';
            if (mHits.indexOf(letter) >= 0) {
                display = letter;
            }
            progess = progess + display;
        }
        return progess;
    }

    public int getRemainingTries() {
        return MAX_MISSES - mMisses.length();
    }

    private char validateGuess(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if (mHits.indexOf(letter) >= 0 || mMisses.indexOf(letter) >= 0) {
            throw new IllegalArgumentException(letter + "has already been guessed");
        }
        return letter;
    }

    public boolean isSolved(){
        return getCurrentProgress().indexOf('-') == -1;
    }

    public String getAnswer() {
        return mAnswer;
    }
}
