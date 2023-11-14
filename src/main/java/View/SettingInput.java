package View;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;
import christmas.Constants;

public class SettingInput {
	private static String num;
	private static String str;
	
	public static int setDay() {
		String tmp = "^[0-9]*$";
		System.out.println(Constants.INPUT_DAY);
		num = Console.readLine();
		System.out.println();

		try {
			if (Integer.parseInt(num) <= 0 || Integer.parseInt(num) > 31 || Pattern.matches(tmp, num) == false)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.DAY_ERROR_MSG + "\n");
			return setDay();
		}
		return Integer.parseInt(num);
	}

	public static int getDay() {
		return Integer.parseInt(num);
	}

	public static String setMenu() {
		System.out.println(Constants.INPUT_MENU);
		str = Console.readLine();

		try {
			if (str.contains(" ") == true || (str.charAt(str.length() - 1) == ','))
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(Constants.ORDER_ERROR_MSG + "\n");
			return setMenu();
		}
		return str;
	}

	public static String getMenu() {
		return str;
	}
}
