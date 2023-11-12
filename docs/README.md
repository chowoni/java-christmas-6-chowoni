## 🚀 구현 기능 목록
### 게임 시작

# InputView.java

1. "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다. 12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"
- 1 이상 31 이하의 숫자 입력
- 입력 조건을 만족하지 않는 경우 IllegalArgumentException 발생
- "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." 출력
- 재입력 받기

2. "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"
- 메뉴판에 없는 메뉴 / 메뉴의 개수가 1개 이상이 아닌 경우 / 매뉴 형식이 예시와 다른 경우 / 중복 메뉴 입력 하는 경우 / 음료만 주문한 경우 / 메뉴의 총 합이 20개 초과인 경우 IllegalArgumentException 발생
- "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요." 출력
- 재입력 받기

# DiscountDetails.java

1. <할인 전 총주문 금액> 계산
- 총주문 금액이 10,000원을 넘지 않은 경우 이벤트 적용 X

2. <증정 메뉴> 확인
3. <혜택 내역> 확인 및 계산
4. <총혜택 금액>, (할인 금액의 합계 + 증정 메뉴의 가격) 계산
5. <할인 후 예상 결제 금액>, ( 할인 전 총주문 금액 - 할인 금액) 계산
6. 4.<총혜택 금액>에 따른 <12월 이벤트 배지> 확인


# OutputView.java

1. "12월 (day)일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"

- InputView에서 입력 받은 day 리턴
- InputView에서 입력 받은 주문 메뉴 입력 순서대로 출력 (<Map<String, int> orderMenu, amount>)
- DiscountDetails에서 계산한 <할인 전 총주문 금액> 출력 (totalAmount)
- DiscountDetails에서 확인한 <증정 메뉴> 출력 (giftMenu)
- DiscountDetails에서 확인 및 계산한 <혜택 내역> 출력 (christmasDiscount, weekdayDiscount, specialDiscount, giftEvent)
- DiscountDetails에서 계산한 <총혜택 금액> 출력 (totalDiscount = christmasDiscount + weekdayDiscount + specialDiscount + giftEvent)
- DiscountDetails에서 계산한 <할인 후 예상 결제 금액> 출력 (estimatedAmount)
- DiscountDetails에서 확인한 <12월 이벤트 배지> 출력 (eventBadge)

# enum Menu

SOUP("양송이수프", 6_000, "양송이수프(6,000)"),
TAPAS("타파스", 5_500, "타파스(5,500)"),
SALAD("시저샐러드", 8_000, "시저샐러드(8,000)"),
STEAK("티본스테이크", 55_000, "티본스테이크(55,000)"),
LIP("바베큐립", 54_000, "바베큐립(54,000)"),
SEAFOOD("해산물파스타", 35_000, "해산물파스타(35,000)"),
CHRISTMAS("크리스마스파스타", 25_000, "크리스마스파스타(25,000)"),
CAKE("초코케이크", 15_000, "초코케이크(15,000)"),
ICECREAM("아이스크림", 5_000, "아이스크림(5,000)"),
COKE("제로콜라", 3_000, "제로콜라(3,000)"),
WINE("레드와인", 60_000, "레드와인(60,000)"),
CHAMPAGNE("샴페인", 25_000, "샴페인(25,000)");


# enum Badge

MISS("없음", 0),
STAR("별", 5_000),
TREE("트리", 10_000),
SANTA("산타", 20_000);
