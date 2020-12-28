package labuladong.mustread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后问题
 */
class NQueenChecks {

    List<List<String>> outputs;

    public static void main(String[] args) {
        List<List<String>> queens = new NQueenChecks().solveNQueens(8);
        System.out.println(Arrays.deepToString(queens.toArray()).replaceAll(", ","]\n ["));
        System.out.println(queens.size());
    }

    public List<List<String>> solveNQueens(int n) {
        outputs = new ArrayList<List<String>>();
        String[][] board = new String[n][n];
        backtrace(board, 0);
        return outputs;
    }

    private void backtrace(String[][] board, int row) {
        int length = board[0].length;
        if (row == length) {
            resolve(board);
            return;
        }
        for (int column = 0; column < length; column++) {
            if (!isValid(board, row, column)) {
                continue;
            }
            board[row][column] = "Q";
            backtrace(board, row + 1);
            board[row][column] = ".";
        }
    }

    private void resolve(String[][] board) {
        List<String> result = new ArrayList<>();
        int length = board[0].length;
        for (int i = 0; i < length; i++) {
            String res = "";
            for (int j = 0; j < length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = ".";
                }
                res = res + board[i][j];
            }
            result.add(res);
        }
        outputs.add(result);
    }


    private boolean isValid(String[][] board, int row, int column) {
        //左方没有棋子
        for (int i = 0; i < row; i++) {
            if (board[i][column] == "Q") {
                return false;
            }
        }
        //右方没有棋子
        for (int i = 0; i < column; i++) {
            if (board[row][i] == "Q") {
                return false;
            }
        }
        //左上没有棋子
        int j = row;
        int k = column;
        while (j > 0 && k > 0) {
            if (board[j - 1][k - 1] == "Q") {
                return false;
            }
            j--;
            k--;
        }
        //右上方没有棋子
        j = row;
        k = column;
        while (j > 0 && k < board[0].length - 1) {
            if (board[j - 1][k + 1] == "Q") {
                return false;
            }
            j--;
            k++;
        }

        return true;
    }
}
