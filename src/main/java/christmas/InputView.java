package christmas;

import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String INPUT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
	private static final String INPUT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
	private static final String DAY_ERROR_MSG = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
	private static final String ORDER_ERROR_MSG = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
	private static String num;
	private static String str;

	public static int getDay() {
		String tmp = "^[0-9]*$";
		System.out.println(INPUT_DAY);
		num = Console.readLine();
		System.out.println();

		try {
			if (Integer.parseInt(num) <= 0 || Pattern.matches(tmp, num) == false)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(DAY_ERROR_MSG + "\n");
			return getDay();
		}
		return Integer.parseInt(num);
	}

	public static String getMenu() {
		System.out.println(INPUT_MENU);
		str = Console.readLine();
	
		String[] name_quantity = str.split(",");

		try {
			if (str.contains(" ") == true || (str.charAt(str.length() - 1) == ','))
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(ORDER_ERROR_MSG + "\n");
			return getMenu();
		}
		return str;
	}
}