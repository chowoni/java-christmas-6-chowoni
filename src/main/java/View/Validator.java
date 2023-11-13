package christmas;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Validator {
	private static final String DAY_ERROR_MSG = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
	private static final String ORDER_ERROR_MSG = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
	private static String[] name;
	private static String[] quantity;
	
	public static String[] getName() {
		return name;
	}

	public static String[] getQuantity() {
		return quantity;
	}

	public static void checkFormatting(String tmp) {
		try {
			if (tmp.contains(" ") == true || tmp.contains("-") == false)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(ORDER_ERROR_MSG + "\n");
			InputView.getMenu();
		}
	}

	public static void checkOrderCondition(String str) {
		String[] orderHistory = str.split("-|,"); // index 0포함 짝수는 메뉴 이름, 홀수는 개수
		name = new String[orderHistory.length / 2];
		quantity = new String[orderHistory.length / 2];

		for (int j = 0; j < name.length; j++) {
			name[j] = orderHistory[j * 2];
			quantity[j] = orderHistory[(j * 2) + 1];
		}

		for (int n = 0; n < quantity.length; n++) {
			checkName(name[n]);
			checkCnt(quantity[n]);
		}
	}

	private static void checkName(String menuName) {
		try {
			Menu menu = Menu.findName(menuName);
			
			if (menu == Menu.EMPTY || name.length != Arrays.stream(name).distinct().count())
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(ORDER_ERROR_MSG + "\n");
			InputView.getMenu();
		}
		checkDrink(name);
	}

	private static void checkCnt(String quantity) {
		String tmp = "^[1-9]*$";

		try {
			if (Integer.parseInt(quantity) == 0 || Pattern.matches(tmp, quantity) == false)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(ORDER_ERROR_MSG + "\n");
			InputView.getMenu();
		}
	}

	private static void checkDrink(String[] name) {
		int cnt = 0;

		for (int k = 0; k < name.length; k++) {
			Menu menu = Menu.findName(name[k]);
			if (menu == Menu.COKE || menu == Menu.WINE || menu == Menu.CHAMPAGNE)
				cnt++;
		}
		isJustDrink(cnt);
	}

	private static void isJustDrink(int size) {
		try {
			if (name.length == size)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			System.out.println(ORDER_ERROR_MSG + "\n");
			InputView.getMenu();
		}
	}
}
