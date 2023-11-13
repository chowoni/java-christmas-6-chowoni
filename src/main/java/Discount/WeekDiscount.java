package Discount;

import java.text.NumberFormat;

import View.Validator;
import christmas.Constants;
import christmas.Controll;
import christmas.Menu;

public class WeekDiscount {
	private static int discount = 0;
	private static String[] name = Validator.getName();
	private static String[] quantity = Validator.getQuantity();

	private static NumberFormat numberFormat = NumberFormat.getInstance();

	public static boolean setWeekDiscount() {
		int remainder = (Controll.day - 1) % 7;

		if (remainder == 0 || remainder == 1) {
			return true;
		}

		return false;
	}

	public static int getWeekdayDiscount() {
		setWeekdayDiscount();
		return discount;
	}

	public static int getWeekendDiscount() {
		setWeekendDiscount();
		return discount;
	}

	public static String printDiscount() {
		setWeekdayDiscount();
		if (discount != 0)
			return Constants.MINUS + numberFormat.format(discount) + Constants.WON;

		return Constants.NO_DISCOUNT;
	}

	public static void setWeekdayDiscount() {
		int cnt = 0;

		for (int i = 0; i < name.length; i++) {
			Menu menu = Menu.findName(name[i]);
			if (menu == Menu.CAKE || menu == Menu.ICECREAM)
				cnt += Integer.parseInt(quantity[i]);
		}

		discount = cnt * 2023;
	}

	public static void setWeekendDiscount() {
		int cnt = 0;

		for (int i = 0; i < name.length; i++) {
			Menu menu = Menu.findName(name[i]);
			if (menu == Menu.STEAK || menu == Menu.LIP || menu == Menu.SEAFOOD || menu == Menu.CHRISTMAS)
				cnt += Integer.parseInt(quantity[i]);
		}

		discount = cnt * 2023;
	}

}