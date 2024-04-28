import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Bai1 {
    public String nhapchuoi() throws IOException{
        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ISR);
        String s = br.readLine();
        System.out.println("Chuoi vua nhap: " + s);
        return s;
    }
    public void chuoidao(String s){
        String s2 = "";
        for(int i=s.length()-1; i>=0; i--){
            s2 += s.charAt(i);
        }
        System.out.print("Chuoi dao: " + s2);
        System.out.println();
    }

    public void UpperCase(String s){
        System.out.println("Chuoi viet hoa: ");
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                c = (char)(c - 32);
            }
            System.out.print(c);
        }
        System.out.println();
    }

    public void UpperLower(String s){
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                c = (char)(c + 32);
            }
            else if(c >= 'a' && c <= 'z'){
                c = (char)(c - 32);
            }
            System.out.print(c);
        }
    }
    public int countWords(String input) {
        int wordCount = 0;
        boolean isWord = false;
        int endOfLine = input.length() - 1;

        for (int i = 0; i < input.length(); i++) {
            // Nếu ký tự hiện tại là một chữ cái và nó không phải là cuối cùng của chuỗi,
            // đặt isWord thành true.
            if (Character.isLetter(input.charAt(i)) && i != endOfLine) {
                isWord = true;
                // Nếu ký tự hiện tại không phải là một chữ cái và isWord đã được đặt,
                // tăng wordCount lên 1 vì đã kết thúc một từ.
            } else if (!Character.isLetter(input.charAt(i)) && isWord) {
                wordCount++;
                isWord = false;
                // Nếu ký tự cuối cùng là một chữ cái thì tăng wordCount lên 1 vì nó cũng là một từ.
            } else if (Character.isLetter(input.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public void wordFrequency(String input){
        boolean isWord = false;
        int endOfLine = input.length() - 1;
        ArrayList<String> words = new ArrayList<>();
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                isWord = true;
                wordBuilder.append(c);
                if (i == endOfLine) {
                    words.add(wordBuilder.toString());
                }
            } else if (isWord) {
                words.add(wordBuilder.toString());
                wordBuilder.setLength(0);
                isWord = false;
            }
        }
        System.out.println(words);
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String word : words){
            Integer count = frequencyMap.getOrDefault(word, 0);
            frequencyMap.put(word, count + 1);
        }

        for(Map.Entry<String, Integer> entry : frequencyMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args){
        Bai1 dt = new Bai1();
        String s="";
        try {
            System.out.print("Nhap mot chuoi: ");
            s=dt.nhapchuoi();
        } catch (Exception e) {
            System.out.println("Loi: " + e.toString());
        }
        dt.chuoidao(s);
        dt.UpperCase(s);
        dt.UpperLower(s);
        int count = dt.countWords(s);
        System.out.println("\nSo tu trong chuoi: " + count);
        dt.wordFrequency(s);
    }
}
