package com.yang.lin.numberplace;


public class NumberPlace {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        int[][] s = sudoku.getNext();
        Sudoku.printSudoku(s);
        Sudoku.printSudoku(Sudoku.initSudokuGame(s));
    }

}
