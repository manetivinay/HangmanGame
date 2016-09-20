package com.example.vinaymaneti.hangmangame;

/**
 * Created by vinaymaneti on 6/19/16.
 */
public class Hangman {

    public static void main(String[] args) {

        if(args.length  == 0){
            System.out.printf("Please enter the word :");
            System.exit(0);
        }

        Game game = new Game(args[0]);
        Prompter prompter = new Prompter(game);
        prompter.play();
//        prompter.displayProgress();
//        boolean isHIt = prompter.promptFotGuess();
//        if (isHIt) {
//            System.out.print("We got a hit");
//        } else {
//            System.out.print("Whoops that is miss");
//        }
//        prompter.displayProgress();

    }

}
