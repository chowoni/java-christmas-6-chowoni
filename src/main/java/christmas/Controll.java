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

		DiscountDetails calculation = new DiscountDetails(day);
		printResult();
	}

	public static void inputDay() {
		day = InputView.setDay();
	}

	public static void inputOrder() {
		order = InputView.setMenu();

		Validator.checkFormatting(order);
		Validator.checkOrderCondition(order);
	}

	private static void printResult() {
		OutputView.privewGuide();
		OutputView.printOrderMenu();
		OutputView.printDiscountResult();
	}
}