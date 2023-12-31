package View;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;

import org.junit.jupiter.api.Test;

class ViewTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("r", "32", "0");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("1", "제로콜라-1,샴페인-1", "해산물파스타=1", "티본스테이크-2,", "크리스마스파스타-1 타파스-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_개수_테스트() {
        assertSimpleTest(() -> {
            runException("1", "티본스테이크-5,바비큐립-5,초코케이크-5,제로콜라-5,샴페인=-1", "해산물파스타-21");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
