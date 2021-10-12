package backjoon;

import java.io.*;

public class CountSort {
    static class MyReader {
        private final InputStream in;
        private final byte[] buffer;
        private final int bufferSize;
        private int bufferIdx, readCount;
        public MyReader() {
            this.bufferSize = 8192;
            this.buffer = new byte[bufferSize];
            this.in = System.in;
        }
        public MyReader(int BufferSize) {
            this.bufferSize = BufferSize;
            this.buffer = new byte[BufferSize];
            this.in = System.in;
        }

        private void fill() throws IOException {
            readCount = in.read(buffer, bufferIdx =0, bufferSize);
            if(readCount == -1) buffer[0] = -1;
        }
        private byte read() throws IOException {
            if(bufferIdx == readCount) fill();
            return buffer[bufferIdx++];
        }
        public int nextInt() throws IOException {
            int a;
            byte c = read();
            while(c <= ' ') c = read();
            
            boolean isNeg = c == '-';
            if(isNeg) c = read();
            a = c-'0';
            while((c = read()) >= '0' && c <= '9')
                a = a*10 + c-'0';
            return isNeg?-a:a;
        }
        public void close() throws IOException {
            in.close();
        }
    }
    public static void main(String[] args) throws IOException {
    	CountSort.MyReader mr = new CountSort.MyReader(4096);
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = mr.nextInt();
        int[] arr = new int[2000001];
        for(int i=0; i<N; i++)
        	arr[mr.nextInt()+1000000]++;
        for(int i=0; i<2000001; i++)
        	while(arr[i]>0) {
        		arr[i]--;
        		sb.append(i-1000000).append("\n");
        	}
        bw.write(sb.toString());
        bw.flush();
    }
}