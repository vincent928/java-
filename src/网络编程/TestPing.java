package 网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPing {

	public static void main(String[] args) throws IOException {
		Process exec = Runtime.getRuntime().exec("ping "+"127.0.0.1");
		InputStreamReader in = new InputStreamReader(exec.getInputStream(),"gbk");
		BufferedReader bReader = new BufferedReader(in);
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = bReader.readLine()) != null) {
			if (line.length() !=0) {
				sb.append(line+"\r\n");
			}
		}
		System.out.println("命令返回消息：");
		System.out.println(sb.toString());
	}
}
