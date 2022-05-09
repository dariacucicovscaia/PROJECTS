package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentsReader {
	public String read(String argument) {
		String value = null;
		if (argument.contains("'")) {
			value = valueBetweenApostrohe(argument);
		}
		return value;
	}

	public static String valueBetweenApostrohe(String string) {
		String ValueWeNeed = null;
		String[] paras = string.split("\n");
		Pattern pattern = Pattern.compile("'(.*?)'");
		for (int i = 0; i < paras.length; i++) {
			Matcher matcher = pattern.matcher(paras[i]);
			while (matcher.find()) {
				ValueWeNeed = matcher.group(1);
			}
		}

		return ValueWeNeed;
	}
}
