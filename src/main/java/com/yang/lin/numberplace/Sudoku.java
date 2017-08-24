package com.yang.lin.numberplace;


import org.springframework.stereotype.Service;

@Service
public class Sudoku {
    private static final int SIZE = 9;
    private int[][] sudoku = new int[SIZE][SIZE];
    private  int OUT_PUT_NUMBER = Integer.MAX_VALUE;
    private boolean nextFlag = false;
    private int G_X = 0;
    private int G_y = 0;


    private int[][] next;
    /**
     * 输出数独
     * @param salt
     */
    public void process(Integer salt) {
        if (salt != null && salt >= 1 && salt <= 9) {
            sudoku[0][0] = salt;
        }
        process(0, 0, false);
    }

    /**
     * 获取下一个结果
     *
     * @return
     */
    public int[][] getNext() {
        process(G_X, G_y, true);
        return next;
    }

    /**
     * 找出所有可能的数独
     *
     * @param stopble 是不是在找到一个结果之后中断，如果不中断则会一直打印出结果
     */
    private void process(int global_x, int global_y, boolean stopble) {
        int out = 0;
        boolean backFLag = false;
        for (int x = global_x; x < SIZE; x++) {
            for (int y = backFLag ? 8 : global_y; y < SIZE; y++) {
                backFLag = false;
                //是不是需要中断，保存当前的下表值，一遍下一次重新恢复当前状态。
                if (nextFlag && stopble) {
                    G_X = x;
                    G_y = y;
                    nextFlag = false;
                    return;
                }
                //如果是从中断中恢复的，依然从0开始遍历
                if(!nextFlag&&global_y!=0){
                    global_y = 0;
                }

                //如果已经是9了 直接回溯到上一个数
                if (sudoku[x][y] == 9) {
                    sudoku[x][y] = 0;
                    if (y == 0) {
                        x -= 2;
                        y = 9;
                        backFLag = true;
                    } else {
                        y -= 2;
                    }
                    continue;
                }
                //数字加1
                sudoku[x][y]++;
                //如果已经到了最后一个数字，且最后一个数字。而且是合法的。打印出来。
                if (x == 8 && y == 8 && checkPositionValid(x, y)) {
                    if (!stopble) printSudoku(sudoku);
                    nextFlag = true;
                    next = copy();
                    if (++out == OUT_PUT_NUMBER) {
                        return;
                    }
                    //回溯到上一个数
                    sudoku[x][y] = 0;
                    if (y == 0) {
                        x -= 2;
                        y = 9;
                        backFLag = true;
                    } else {
                        y -= 2;
                    }
                    continue;
                }
                //如果这个位置的数字是合法的.继续往下走
                if (checkPositionValid(x, y)) {
                    continue;
                }
                //如果不合法
                else {
                    //值没有到9，则值加1.到合法或者到9为直
                    while (sudoku[x][y] < 9) {
                        sudoku[x][y]++;
                        if (checkPositionValid(x, y)) {
                            //如果已经到了最后一个数字，且最后一个数字。而且是合法的。打印出来。
                            if (x == 8 && y == 8 && checkPositionValid(x, y)) {
                                if (!stopble) printSudoku(sudoku);
                                nextFlag = true;
                                next = copy();
                                if (++out == OUT_PUT_NUMBER) {
                                    return;
                                }
                                //回溯到上一个数
                                sudoku[x][y] = 0;
                                if (y == 0) {
                                    x -= 2;
                                    y = 8;
                                    backFLag = true;
                                } else {
                                    y -= 2;
                                }
                                continue;
                            }
                            break;
                        }
                    }

                    //如果值已经到9，且不合法。
                    if (sudoku[x][y] >= 9 && !checkPositionValid(x, y)) {
                        //回到上一个位置。且当前位置的值设为0.
                        sudoku[x][y] = 0;
                        //已经是这个列的第一一个数,返回上一列的最后一个数。
                        if (y == 0) {
                            x -= 2;
                            y = 8;//设置为8结束当前循环
                            backFLag = true;
                        }
                        //回到这一列的上一个数
                        else {
                            y -= 2;
                        }
                        continue;
                    }

                }

            }
        }
    }

    /**
     * 检查指定位置的数,是否是合法的。
     *
     * @param x
     * @param y
     * @return
     */
    private boolean checkPositionValid(int x, int y) {
        if (x < 0 || y < 0 || x > 8 || y > 8) {
            throw new IllegalArgumentException();
        }

        //行列重复检测
        for (int i = 0; i < 9; i++) {
            if ((i != y && sudoku[x][i] == sudoku[x][y]) || (i != x && sudoku[i][y] == sudoku[x][y])) {
                return false;
            }
        }

        //1.获取单元格起始位置
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int xx = startX; xx < startX + 3; xx++) {
            for (int yy = startY; yy < startY + 3; yy++) {
                if (xx != x && yy != y && sudoku[x][y] == sudoku[xx][yy]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 打印数独
     *
     * @param in
     */
    public static void printSudoku(int[][] in) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(in[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int[][] copy(){
        int[][] copySudoku = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                copySudoku[i][j] = sudoku[i][j];
            }
        }
        return copySudoku;
    }

}
