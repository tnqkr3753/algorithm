package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = 0;
        int price = 0;

        n = Integer.parseInt(st.nextToken());
        price = Integer.parseInt(st.nextToken());
        int[] coinArr = new int[n];
        for (int i = 0; i < n; i++){
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = n-1; i > -1; i--) {
            if (coinArr[i] > price) continue;
            else{
                int tm = price/coinArr[i];
                result += tm;
                price -= tm*coinArr[i];
            }
        }
        System.out.println(result);
    }
}
