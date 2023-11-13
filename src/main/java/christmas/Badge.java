package christmas;

import java.util.Arrays;

public enum Badge {
	MISS("없음", 0),
	STAR("별", 5_000),
	TREE("트리", 10_000),
	SANTA("산타", 20_000);
	
	private String badge;
	private int baseAmount;
	private static int num;
	
	Badge(String badge, int baseAmount) {
		this.badge = badge;
		this.baseAmount = baseAmount;
	}
	
	public String getBadge() {
		return this.badge;
	}
	
	public int getBaseAmount() {
		return this.baseAmount;
	}
	
	public static String matchAmountWithBadge(int inputNum) {
		isSanta(inputNum);
		
		if(inputNum < 5000) {
			num = inputNum;
			return findBadge(num).getBadge();
		}
		
		return findBadge(num).getBadge();
	}
	
	private static Badge findBadge(int amount) {
		return Arrays.stream(Badge.values())
				.filter(Badge -> Badge.baseAmount == amount)
				.findAny()
				.orElse(MISS);
	}
	
	private static void isSanta(int inputNum) {
		if(inputNum >= 20000) {
			num = 20000;
			return;
		}
		
		searchBadge(inputNum);
	}
	
	private static void searchBadge(int inputNum) {
		if(inputNum >= 10000) {
			num = 10000;
			return;
		}
		
		num = 5000;
	}
}
