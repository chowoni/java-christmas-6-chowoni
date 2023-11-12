package christmas;

import java.util.Arrays;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Controll {
	public static int day;
	private static String order;

	public static void run() {
		day = InputView.getDay();
		order = InputView.getMenu();

		Validator.checkFormatting(order);
		Validator.checkOrderCondition(order);
	}
}
