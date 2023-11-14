package Discount;

import java.text.NumberFormat;

import View.InputView;
import christmas.Constants;

public class ChristmasDiscount {
	private static int discount = 0;

	private static NumberFormat numberFormat = NumberFormat.getInstance();

	public static String printDiscount() {
		setChristmasDiscount();
		if (discount != 0)
			return Constants.MINUS + numberFormat.format(getChristmasDiscount()) + Constants.WON;

		return Constants.NO_DISCOUNT;
	}

	public static int getChristmasDiscount() {
		return discount;
	}

	private static void setChristmasDiscount() {
		int day = InputView.day;
		int init = 1000;
		int interest = (day - 1) * 100;

		if (day <= 25) {
			discount = (init + interest);
		}
	}
}