package Discount;

import java.text.NumberFormat;
import View.Validator;
import christmas.Badge;
import christmas.Constants;
import christmas.Menu;

public class DiscountDetails {
	private static int day;
	private static int totalAmount;
	private static int totalBenefit = 0;
	private static boolean giftStatus;
	private static String[] name = Validator.getName();
	private static String[] quantity = Validator.getQuantity();

	private static NumberFormat numberFormat = NumberFormat.getInstance();

	public DiscountDetails(int day) {
		this.day = day;
	}

	public static String getBeforeTheDiscount() {
		String result;
		totalAmount = 0;

		for (int i = 0; i < quantity.length; i++) {
			totalAmount += (Menu.matchNameWithPrice(name[i]) * Integer.parseInt(quantity[i]));
		}

		result = numberFormat.format(totalAmount) + Constants.WON;
		return result;
	}

	public static String getGiftMenu() {
		if (totalAmount >= Constants.DISCOUNT_BASE_AMOUNT) {
			giftStatus = true;
			return Constants.GET_GIFT;
		}

		giftStatus = false;
		return Constants.NOTHING;
	}

	public static String getGiftEventDiscount() {
		if (giftStatus == true) {
			totalBenefit += Constants.CHAMPAGNE_PRICE;
			;
			return Constants.GIFT_EVENT_DISCOUNT;
		}
		return Constants.NO_DISCOUNT;
	}

	public static String getTotalBenefit() {
		setTotalBenefit();

		if (totalBenefit != 0) {
			String result = Constants.MINUS + numberFormat.format(totalBenefit) + Constants.WON;
			return result;
		}

		return Constants.NO_DISCOUNT;
	}

	public static String getAfterDiscount() {
		int result = totalAmount - totalBenefit;

		if (giftStatus == true)
			result += Constants.CHAMPAGNE_PRICE;

		return numberFormat.format(result) + Constants.WON;
	}

	public static String getEventBadge() {
		return Badge.matchAmountWithBadge(totalBenefit);
	}

	private static void setTotalBenefit() {
		if (WeekDiscount.setWeekDiscount() == true) {
			totalBenefit += (ChristmasDiscount.getChristmasDiscount() 
					+ WeekDiscount.getWeekendDiscount()
					+ SpecialDiscount.getSpecialDiscount());
		}
		
		totalBenefit += (ChristmasDiscount.getChristmasDiscount() 
				+ WeekDiscount.getWeekdayDiscount()
				+ SpecialDiscount.getSpecialDiscount());
	}

}