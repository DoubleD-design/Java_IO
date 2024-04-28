import java.io.*;

public class Bai4 {

    public int getInput() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputBuff = new BufferedReader(input);
        String s = inputBuff.readLine();
        return Integer.parseInt(s);
    }

    public void TichBoiBa(int a[][], int m, int n) {
        int s = 1;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] % 3 == 0) {
                    s *= a[i][j];
                }
            }
        }
        System.out.print("Tich cac phan tu boi 3 nam tren dong dau tien cua ma tran la: " + s);
    }

    public void MaxArr(int a[][], int m, int n) {
        int b[] = new int[m];
        int c[] = new int[m - 1];

        for (int i = 0; i < m; i++) {
            int max = a[i][0];
            for (int j = 0; j < n; j++) {
                if (a[i][0] < a[i][j]) {
                    max = a[i][j];
                }
            }
            b[i] = max;
        }
        System.out.print("\nMang mot chieu chua GTLN tren cac dong cua ma tran:");
        for (int i = 0; i < m; i++) {
            System.out.print(" " + b[i]);
        }

        System.out.print("\nMang sau khi xoa tu dau tien: ");
        for (int i = 1; i < m; i++) {
            c[i - 1] = b[i];
        }
        m--;
        for (int i = 0; i < m; i++) {
            System.out.print(" " + c[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Bai4 myMatrix = new Bai4();
        int m = 0, n = 0, i = 0, j = 0;
        try {
            do {
                System.out.print("Nhap so hang m: ");
                m = myMatrix.getInput();
                System.out.print("Nhap so cot n: ");
                n = myMatrix.getInput();
            } while (m < 0 || n < 0);
        } catch (IOException e) {
        }

        int a[][] = new int[m][n];
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                System.out.print("Nhap phan tu thu a[" + i + "][" + j + "]: ");
                try {
                    a[i][j] = myMatrix.getInput();
                } catch (IOException e) {
                }
            }
        }

        myMatrix.TichBoiBa(a, m, n);
        myMatrix.MaxArr(a, m, n);
    }
}