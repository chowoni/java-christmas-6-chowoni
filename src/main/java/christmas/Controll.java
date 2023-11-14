package christmas;

import View.InputView;
import View.OutputView;

public class Controll {
	public static void run() {
		InputView.inputDay();
		InputView.inputOrder();

		calculatedDiscount();
	}

	private static void calculatedDiscount() {
		OutputView.privewGuide();
		OutputView.printOrderMenu();
		OutputView.printDiscountResult();
	}
}
