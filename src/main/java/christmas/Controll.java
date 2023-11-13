package christmas;

import Discount.DiscountDetails;
import View.InputView;
import View.OutputView;
import View.Validator;

public class Controll {
	public static int day;
	private static String order;

	public static void run() {
		inputDay();
		inputOrder();
	}

	public static void inputDay() {
		day = InputView.setDay();
	}

	public static void inputOrder() {
		order = InputView.setMenu();

		Validator.checkFormatting(order);
		Validator.checkOrderCondition(order);
	}
}
