package com.yang.lin.numberplace;


public class NumberPlace {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        for(int i=0;i<20;i++){
            Sudoku.printSudoku(sudoku.getNext());
        }
    }

}
