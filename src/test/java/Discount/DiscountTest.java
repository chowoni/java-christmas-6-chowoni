package Discount;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;

import org.junit.jupiter.api.Test;

class DiscountTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 증정_메뉴_테스트() {
        assertSimpleTest(() -> {
            run("2", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains("<증정 메뉴>" + LINE_SEPARATOR + "샴페인 1개");
        });
    }

    @Test
    void 크리스마스_디데이_테스트() {
        assertSimpleTest(() -> {
            run("6", "해산물파스타-2,레드와인-1,초코케이크-1");
            assertThat(output()).contains("크리스마스 디데이 할인: ", "-1,500");
        });
    }

    @Test
    void 평일할인_출력_테스트() {
        assertSimpleTest(() -> {
            run("14", "해산물파스타-2,초코케이크-1,아이스크림-1");
            assertThat(output()).contains("평일 할인: ", "-4,046");
        });
    }

    @Test
    void 평일할인_없음_테스트() {
        assertSimpleTest(() -> {
            run("14", "티본스테이크-1,바비큐립-1,해산물파스타-1,레드와인-1");
            assertThat(output()).contains("평일 할인: ", "0원");
        });
    }

    @Test
    void 주말할인_출력_테스트() {
        assertSimpleTest(() -> {
            run("15", "해산물파스타-2,초코케이크-1,아이스크림-1");
            assertThat(output()).contains("주말 할인: ", "-4,046");
        });
    }

    @Test
    void 주말할인_없음_테스트() {
        assertSimpleTest(() -> {
            run("15", "시저샐러드-1,초코케이크-1,아이스크림-1");
            assertThat(output()).contains("주말 할인: ", "0원");
        });
    }

     @Test
    void 특별할인_없음_테스트() {
        assertSimpleTest(() -> {
            run("18", "크리스마스파스타-1,바비큐립-1,초코케이크-1,레드와인-1");
            assertThat(output()).contains("특별 할인: ", "0원");
        });
    }

    @Test
    void 특별할인_테스트() {
        assertSimpleTest(() -> {
            run("24", "크리스마스파스타-1,바비큐립-1,레드와인-1");
            assertThat(output()).contains("특별 할인: ", "-1,000");
        });
    }

    @Test
    void 증정_이벤트_테스트() {
        assertSimpleTest(() -> {
            run("24", "티본스테이크-1,바비큐립-1,레드와인-2,제로콜라-1");
            assertThat(output()).contains("증정 이벤트: ", "-25,000");
        });
    }

    @Test
    void 증정_이벤트_없음_테스트() {
        assertSimpleTest(() -> {
            run("24", "바비큐립-1,제로콜라-1");
            assertThat(output()).contains("증정 이벤트: ", "0원");
        });
    }

    @Test
    void 이벤트_배지_테스트() {
        assertSimpleTest(() -> {
            runException("25", "티본스테이크-2,시저샐러드-1,초코케이크-1,제로콜라-1");
            assertThat(output()).contains("<12월 이벤트 배지>" + LINE_SEPARATOR + "산타");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
