package christmas;

import java.util.Arrays;

public enum Menu {
	SOUP("양송이수프", 6_000),
	TAPAS("타파스", 5_500),
	SALAD("시저샐러드", 8_000),
	STEAK("티본스테이크", 55_000),
	LIP("바베큐립", 54_000),
	SEAFOOD("해산물파스타", 35_000),
	CHRISTMAS("크리스마스파스타", 25_000),
	CAKE("초코케이크", 15_000),
	ICECREAM("아이스크림", 5_000),
	COKE("제로콜라", 3_000),
	WINE("레드와인", 60_000),
	CHAMPAGNE("샴페인", 25_000),
	EMPTY("", 0);

	private String name;
	private int price;
	
	Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public static int matchNameWithPrice(String str) {
		return findName(str).getPrice();
	}

	public static Menu findName(String str) {
		return Arrays.stream(Menu.values())
				.filter(Menu -> Menu.name.equals(str))
				.findAny()
				.orElse(EMPTY);
	}
}
