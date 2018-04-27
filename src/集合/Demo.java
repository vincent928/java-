package 集合;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) {
		String string = "1";
		Pattern compile = Pattern.compile("[0-9]");
		Matcher isNum = compile.matcher(string);
		if (!isNum.matches()) {
			System.out.println(false);
		}else {
			System.out.println(true);
		}
	}
}

/*
 0000 1010 = 10
 0000 0101 = 5

 0000 1011 = 11
 0000 0101 = 5
*/