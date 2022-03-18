package com.blz;

import java.util.Objects;
import java.util.Scanner;

public class TicTacToeGame {
    public static char inputUser;
    public static char inputC;
    public static char[] board = new char[10];
    public static String toss;
    public static Scanner in = new Scanner(System.in);
    public static String status;
    public static String check;
    public static int select;

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
        inputUser = input();
        if (inputUser == 'X') {
            inputC = 'O';
        } else {
            inputC = 'X';
        }
        TicTacToeGame.showBoard();
        String turn = toss();

        if (turn.equals("Won")) {
            TicTacToeGame.uSelection();
            TicTacToeGame.showBoard();
            firstMove();
            for (int i = 1; i <= 4; i++) {
                TicTacToeGame.showBoard();
                TicTacToeGame.uSelection();
                TicTacToeGame.showBoard();
                check = check();
                if (Objects.equals(check, "Done")) {
                    break;
                }
                TicTacToeGame.cSelection();
                TicTacToeGame.showBoard();
            }
        } else {
            firstMove();
            for (int i = 1; i <= 5; i++) {
                TicTacToeGame.showBoard();
                TicTacToeGame.uSelection();
                TicTacToeGame.showBoard();
                check = check();
                if (Objects.equals(check, "Done")) {
                    break;
                }
                TicTacToeGame.cSelection();
            }
        }
    }
    public static char input() {
        System.out.println("Please enter your input in X / O");
        char inputU = in.next().charAt(0);
        return inputU;
    }

    public static void showBoard() {
        System.out.println("TicTacToe Board");
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("---------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("---------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }

    public static void uSelection() {
        int j = 0;
        while (j < 1) {
            System.out.println("Please enter the index from 1 to 9 to make the move");
            int select = in.nextInt();
            if (board[select] == ' ') {
                board[select] = inputUser;
                j = 1;
            } else {
                System.out.println("Seat Occupied, please enter a different input");
            }
        }
    }

    public static void cSelection() {
        int i = 0;
        while (i < 1) {
            int select = (int) ((Math.floor(Math.random() * 10) % 9) + 1);
            if (board[select] == ' ') {
                board[select] = inputC;
                i = 1;
            }
        }
    }

    public static String toss() {
        System.out.println("Please enter your call H for Heads/ T for Tails");
        String call = in.next();
        int choice = (int) ((Math.floor(Math.random() * 10) % 2));
        if (choice == 1) {
            toss = "H";
        } else {
            toss = "T";
        }
        if (toss.equals(call)) {
            System.out.println("You Won");
            toss = "Won";
        } else {
            System.out.println("You Lose");
            toss = "Lose";
        }
        return toss;
    }

    public static String check() {
        if (board[1] == inputUser) {
            if ((board[2] == inputUser) && (board[3] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            } else if ((board[5] == inputUser) && (board[9] == inputUser)) {
                System.out.println("PLayer Won");
                status = "Done";
            } else if ((board[4] == inputUser) && (board[7] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            }
        } else if (board[3] == inputUser) {
            if ((board[6] == inputUser) && (board[9] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            } else if ((board[5] == inputUser) && (board[7] == inputUser)) {
                System.out.println("PLayer Won");
                status = "Done";
            }
        } else if (board[7] == inputUser) {
            if ((board[8] == inputUser) && (board[9] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            }
        } else if (board[5] == inputUser) {
            if ((board[2] == inputUser) && (board[8] == inputUser)) {
                System.out.println("Player Won");
                status = "Done";
            } else if ((board[4] == inputUser) && (board[6] == inputUser)) {
                System.out.println("PLayer Won");
                status = "Done";
            }
        }
        return status;
    }

    public static void firstMove() {
        select = (int) ((Math.floor(Math.random() * 10) % 9) + 1);
        if (board[5] == ' ') {
            board[5] = inputC;
        } else {
            int r = 0;
            while (r < 1) {
                if (select % 2 == 0) {
                    System.out.println(select);
                    if (board[select + 1] == ' ') {
                        board[select + 1] = inputC;
                        r = 1;
                    } else {
                        select = (int) ((Math.floor(Math.random() * 10) % 9) + 1);
                    }
                } else {
                    select = (int) ((Math.floor(Math.random() * 10) % 9) + 1);
                }
            }
        }
    }
}
