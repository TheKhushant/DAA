import java.util.*;
public class ChainMatrix {
    public static int matrixChainOrder(int[] dims) {
        int n = dims.length;        
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];        
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }
        for (int chainLength = 2; chainLength < n; chainLength++) {
            for (int i = 1; i < n - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        return m[1][n - 1];
    }
    public static void printOptimalParenthesis(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + (i));
        } else {
            System.out.print("(");
            printOptimalParenthesis(s, i, s[i][j]);
            printOptimalParenthesis(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
    public static void main(String[] args) {
        int[] dims = {40, 20, 30, 10, 30};
        int n = dims.length;
        int minCost = matrixChainOrder(dims);        
        System.out.println("Minimum number of scalar multiplications is: " + minCost);
        System.out.print("Optimal parenthesization is: ");
        int[][] s = new int[n][n];
        matrixChainOrderHelper(dims, s);
        printOptimalParenthesis(s, 1, n - 1);
    }
    private static void matrixChainOrderHelper(int[] dims, int[][] s) {
        int n = dims.length;
        int[][] m = new int[n][n];
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }
        for (int chainLength = 2; chainLength < n; chainLength++) {
            for (int i = 1; i < n - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
}
