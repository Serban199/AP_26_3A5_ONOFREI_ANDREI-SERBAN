import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int x = reader.nextInt();
        if (x == 1)
            patrat();
        else if(x==2)
            cerc();
        else
            borderLine();
    }
    public static void borderLine() {
        Scanner reader = new Scanner(System.in);

        System.out.print("numarul de randuri: ");
        int n = reader.nextInt();

        System.out.print(" numarul de coloane: ");
        int m = reader.nextInt();
        int[][] matrice = new int[n][m];
        int imax = 0;
        int imin = n;
        int jmax = 0;
        int jmin = m;
        System.out.println("introduceti elementele matricei:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrice[i][j] = reader.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrice[i][j]==1) {
                    if (i > imax)
                        imax = i;
                    if (i < imin)
                        imin = i;
                    if (j > jmax)
                        jmax = j;
                    if (j < jmin)
                        jmin = j;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((imax == i || imin == i) && (jmax >= j && jmin <= j))
                    System.out.print(1 + " ");
                else if ((jmax == j || jmin == j) && (imax >= i && imin <= i))
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();

        }
    }
    public static void patrat() {
        Scanner reader = new Scanner(System.in);
        System.out.print("dimensiune matrice:");
        int n = reader.nextInt();

        long start = System.currentTimeMillis();

        if (n <= 30) {
            String white = "██";
            String black = "░░";
            String reset = "\u001B[0m";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i >= 2 && j >= 2 && i <= n - 3 && j <= n - 3)
                        System.out.print(black + " " + reset);
                    else
                        System.out.print(white + " " + reset);
                }
                System.out.println();
            }
        } else {
            try {
                int[][] mat = new int[n][n];
                long end = System.currentTimeMillis();
                System.out.println("timp executie: " + (end - start));
            } catch (OutOfMemoryError e) {
                System.out.println("out of memory");
            }
        }
    }

    public static String coordinates(int i, int j, int n) {
        double centru = n / 2.0;
        double raza = n / 4.0;
        double distanta = Math.pow(i - centru, 2) + Math.pow(j - centru, 2);
        if (distanta <= Math.pow(raza, 2)) {
            return "██";
        } else {
            return "  ";
        }
    }

    public static void cerc() {
        Scanner reader = new Scanner(System.in);
        System.out.print("Marime matrice: ");
        int n = reader.nextInt();

        long start = System.currentTimeMillis();

        if (n <= 30) {
            String reset1 = "\u001B[0m";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    String col = coordinates(i, j, n);
                    System.out.print(col + " " + reset1);
                }
                System.out.println();
            }
        } else {
            try {
                int[][] mat = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        coordinates(i, j, n);
                    }
                }
                long end = System.currentTimeMillis();
                System.out.println("timp executie: " + (end - start));
            } catch (OutOfMemoryError e) {
                System.out.println("out of memory error");
            }
        }
    }
}
/*
0 0 0 0 0
0 1 0 1 0
1 0 1 1 0
0 0 0 0 0
0 0 0 0 0
 */