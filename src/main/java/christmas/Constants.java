package christmas;

public class Constants {
	// InputView, Validator
	public static final String INPUT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
	public static final String INPUT_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
	public static final String DAY_ERROR_MSG = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
	public static final String ORDER_ERROR_MSG = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

	// Discount
	public static final int CHAMPAGNE_PRICE = 25000;
	public static final int DISCOUNT_BASE_AMOUNT = 120000;
	public static final String WON = "원";
	public static final String MINUS = "-";
	public static final String NO_DISCOUNT = "0원";
	public static final String SPECIAL_DISCOUNT = "-1,000원";
	public static final String GIFT_EVENT_DISCOUNT = "-25,000원";
	public static final String GET_GIFT = "샴페인 1개";
	public static final String NOTHING = "없음";

	// OutputView
	public static final String DECEMBER = "12월";
	public static final String UNIT = "개";
	public static final String PREVIEW_BENEFIT_MSG = "우테코 식당에서 받을 이벤트 혜택 미리 보기!";
	public static final String ORDER_MENU_MSG = "<주문 메뉴>";
	public static final String TOTAL_AMOUNT_MSG = "<할인 전 총주문 금액>";
	public static final String GIFT_MENU_MSG = "<증정 메뉴>";
	public static final String BENEGIT_DETAILS_MSG = "<혜택 내역>";
	public static final String TOTAL_BENEFITS_MSG = "<총혜택 금액>";
	public static final String ESTIMATED_AMOUNT_MSG = "<할인 후 예상 결제 금액>";
	public static final String EVENT_BADGE_MSG = "<12월 이벤트 배지>";
	public static final String CHRISTMAS_DAY_DISCOUNT_MSG = "크리스마스 디데이 할인: ";
	public static final String WEEKDAY_DISCOUNT_MSG = "평일 할인: ";
	public static final String WEEKEND_DISCOUNT_MSG = "주말 할인: ";
	public static final String SPECIAL_DISCOUNT_MSG = "특별 할인: ";
	public static final String GIFT_EVENT = "증정 이벤트: ";
}
