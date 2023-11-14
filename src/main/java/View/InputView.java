package View;

import christmas.Controll;

public class InputView {
	public static int day;
	private static String order;

	public static void inputDay() {
		day = SettingInput.setDay();
	}

	public static void inputOrder() {
		order = SettingInput.setMenu();

		Validator.checkFormatting(order);
		Validator.checkOrderCondition(order);
	}
}