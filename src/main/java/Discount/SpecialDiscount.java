package Discount;

import java.text.NumberFormat;

import christmas.Constants;
import christmas.Controll;

public class SpecialDiscount {
	private static int discount = 0;

	private static NumberFormat numberFormat = NumberFormat.getInstance();

	public static String printDiscount() {
		setSpecialDiscount();
		if (discount != 0)
			return Constants.MINUS + numberFormat.format(getSpecialDiscount()) + Constants.WON;

		return Constants.NO_DISCOUNT;
	}

	public static int getSpecialDiscount() {
		setSpecialDiscount();
		return discount;
	}

	private static void setSpecialDiscount() {
		int day = Controll.day;
		int remainder = (day - 1) % 7;

		if (day == 25 || remainder == 2) {
			discount = 1000;
		}
	}
}