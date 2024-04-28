import java.io.*;

public class Bai3 {
    public int getInput() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader inputBuff = new BufferedReader(input);
        String s = inputBuff.readLine();
        return Integer.parseInt(s);
    }

    public void TongDuongLe(int a[], int n) {
        int s = 0;
        for (int i = 0; i < n; i++) {
            if ((a[i] > 0) && (a[i] % 2 == 1)) {
                s += a[i];
            }
        }
        System.out.println("Tong cac phan tu duong le co trong mang S = " + s);
    }

    public void TimK(int a[], int n, int k) {
        int dem = 0;
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == k) {
                s = i;
                dem++;
                break;
            } else {
                dem = 0;
            }
        }
        if (dem != 0) {
            System.out.println("Phan tu " + k + " o vi tri " + s + " dau tien!");
        } else {
            System.out.println("Phan tu " + k + " khong co trong mang!");
        }
    }

    public void Sort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) { //
                    int swap = a[i];
                    a[i] = a[j];
                    a[j] = swap;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }

    public void Insert(int a[], int n, int p) {
        int[] b = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        b[n] = p;
        System.out.print("Mang sau khi chen phan tu " + p + " la: ");
        Sort(b, n + 1);
    }

    public static void main(String[] args) throws IOException {
        Bai3 myArr = new Bai3();
        int n = 0, k = 0, p = 0;
        try {
            do {
                System.out.print("Nhap vao so phan tu cua mang: ");
                n = myArr.getInput();
            } while (n < 0);
        } catch (IOException e) {
        }

        int a[] = new int[n];
        System.out.println("Nhap cac phan tu cho mang!");
        try {
            do {
                for (int i = 0; i < n; i++) {
                    System.out.print("Nhap phan tu thu " + i + ": ");
                    a[i] = myArr.getInput();
                }
            } while (n < 0);
        } catch (IOException e) {
        }

        myArr.TongDuongLe(a, n);

        try {
            do {
                System.out.print("Nhap phan tu muon tim k: ");
                k = myArr.getInput();
            } while (k < 0);
        } catch (IOException e) {
        }

        myArr.TimK(a, n, k);
        System.out.print("Mang sau khi sap xep theo thu tu tang dan la: ");
        myArr.Sort(a, n);

        try {
            do {
                System.out.print("\nNhap phan tu muon chen p: ");
                p = myArr.getInput();
            } while (p < 0);
        } catch (IOException e) {
        }
        myArr.Insert(a, n, p);
    }
}