import java.io.*;

public class Bai2 {
    public int nhapso() throws IOException{
        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ISR);
        return Integer.parseInt(br.readLine());
    }

    public void Tongtichcacchuso(int m){
        int s=0, P =1;
        while(m != 0){
            int chuso = m % 10;
            s += chuso;
            P *= chuso;
            m /= 10;
        }
        System.out.println("Tong cac chu so: " + s);
        System.out.println("Tich cac chu so: " + P);
    }

    public int Reverse(int num) {
        int j = 0;
        while (num != 0) {
            int k = num % 10;
            j = j * 10 + k;
            num /= 10;
        }
        return j;
    }

    public Boolean CheckDoiXung(int num) {
        if (num == Reverse(num)) {
            return true;
        }
        return false;
    }

    public void CheckFibo(int num) {
        int fib1 = 1;
        int fib2 = 1;
        int fib = 2;
        int i = 2;
        while (fib1 + fib2 <= num) {
            fib = fib1 + fib2;
            fib2 = fib1;
            fib1 = fib;
            i++;
        }
        if (fib == num) {
            System.out.println("La so fibonacci thu " + i);
        } else {
            System.out.println("Khong thuoc day so fibonacci");
        }
    }
    public static void main(String[] args) {
        Bai2 dt = new Bai2();
        int n=0;
        try {
            do{
                System.out.println("Nhap mot so nguyen duong: ");
                n = dt.nhapso();
            }while(n<0);
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
        System.out.println("So vua nhap: " + n);
        dt.Tongtichcacchuso(n);
        int ds = dt.Reverse(n);
        System.out.println("So dao nguoc: " + ds);
        if(dt.CheckDoiXung(n)) {
            System.out.println("La so doi xung");
        }else{
            System.out.println("Khong phai la so doi xung");
        }
        dt.CheckFibo(n);
    }
}