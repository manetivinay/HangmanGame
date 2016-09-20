package com.example.vinaymaneti.hangmangame;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vinaymaneti on 6/19/16.
 */
public class Prompter {

    public Game mGame;

    public Prompter(Game game) {
        this.mGame = game;
    }

    public void play() {
        while (mGame.getRemainingTries() > 0 && !mGame.isSolved()) {
            displayProgress();
            promptFotGuess();
        }
        if (mGame.isSolved()) {
            System.out.printf("Congratulations you won the game with %d tries remaining. \n ", mGame.getRemainingTries());
        } else {
            System.out.printf("Bummer the word was %s :  :( \n", mGame.getAnswer());
        }
    }

    public boolean promptFotGuess() {
//        Console console = System.console();
//        String guessAsString = console.readLine("Enter the letter:");
        String guessAsString;
        char guess = 0;
        boolean isHit = false;
        boolean isValidateGuess = false;
        while (!isValidateGuess) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a letter : ");
            try {
                guessAsString = bufferedReader.readLine();
//                guess = guessAsString.charAt(0);
                isHit = mGame.applyGuess(guessAsString);
                isValidateGuess = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf(" %s. please try again: \n ", iae.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries to solve %s \n ", mGame.getRemainingTries(), mGame.getCurrentProgress());
    }


}
