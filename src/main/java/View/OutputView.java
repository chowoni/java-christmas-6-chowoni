package View;

import Discount.*;
import christmas.Constants;
import christmas.Controll;

public class OutputView {
	private static String[] name = Validator.getName();
	private static String[] quantity = Validator.getQuantity();

	public static void privewGuide() {
		System.out.println(Constants.DECEMBER + Controll.day + Constants.PREVIEW_BENEFIT_MSG);
		System.out.println();
	}

	public static void printOrderMenu() {
		System.out.println(Constants.ORDER_MENU_MSG);
		for (int i = 0; i < name.length; i++) {
			System.out.print(name[i] + " ");
			System.out.println(quantity[i] + Constants.UNIT);
		}
		System.out.println();
	}

	public static void printDiscountResult() {
		printBeforeTheDiscount();
		printGiftEvent();
		printBenefitDetails();
		// 혜택내역
		if (DiscountDetails.getTotalBenefit() == "0원") {
			System.out.println(Constants.NOTHING + "\n");

			printTotalBenefit();
			printEstimatedAmount();
			printEventBadge();
			return;
		}

		printChristmasDiscount();
		setWeekDiscount();
		printSpecialDiscount();
		printGiftlDiscount();
		printTotalBenefit();
		printEstimatedAmount();
		printEventBadge();
	}

	private static void printBeforeTheDiscount() {
		System.out.println(Constants.TOTAL_AMOUNT_MSG);
		System.out.println(DiscountDetails.getBeforeTheDiscount() + "\n");
	}

	private static void printGiftEvent() {
		System.out.println(Constants.GIFT_MENU_MSG);
		System.out.println(DiscountDetails.getGiftMenu() + "\n");
	}

	private static void printBenefitDetails() {
		System.out.println(Constants.BENEGIT_DETAILS_MSG);
	}

	private static void printChristmasDiscount() {
		System.out.print(Constants.CHRISTMAS_DAY_DISCOUNT_MSG);
		System.out.println(ChristmasDiscount.printDiscount());
	}

	private static void setWeekDiscount() {
		if (WeekDiscount.setWeekDiscount() == true) {
			printWeekendDiscount();
			return;
		}

		printWeekdayDiscount();
	}

	private static void printWeekdayDiscount() {
		WeekDiscount weekDay = new WeekDiscount();

		System.out.print(Constants.WEEKDAY_DISCOUNT_MSG);
		weekDay.setWeekdayDiscount();
		System.out.println(weekDay.printDiscount());
	}

	private static void printWeekendDiscount() {
		WeekDiscount weekEnd = new WeekDiscount();

		System.out.print(Constants.WEEKEND_DISCOUNT_MSG);
		weekEnd.setWeekendDiscount();
		System.out.println(weekEnd.printDiscount());
	}

	private static void printSpecialDiscount() {
		System.out.print(Constants.SPECIAL_DISCOUNT_MSG);
		System.out.println(SpecialDiscount.printDiscount());
	}

	private static void printGiftlDiscount() {
		System.out.print(Constants.GIFT_EVENT);
		System.out.println(DiscountDetails.getGiftEventDiscount() + "\n");
	}

	private static void printTotalBenefit() {
		System.out.println(Constants.TOTAL_BENEFITS_MSG);
		System.out.println(DiscountDetails.getTotalBenefit() + "\n");
	}

	private static void printEstimatedAmount() {
		System.out.println(Constants.ESTIMATED_AMOUNT_MSG);
		System.out.println(DiscountDetails.getAfterDiscount() + "\n");
	}

	private static void printEventBadge() {
		System.out.println(Constants.EVENT_BADGE_MSG);
		System.out.print(DiscountDetails.getEventBadge());
	}
}