package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    @DisplayName("첫번째 좌표 right-true를 생성할 수 있다.")
    void createFirstTrueTest() {

        // given
        Direction expected = Direction.from(false, true);

        // when
        Direction result = Direction.first(() -> true);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("첫번째 좌표 right-false를 생성할 수 있다.")
    void createFirstFalseTest() {

        // given
        Direction expected = Direction.from(false, false);

        // when
        Direction result = Direction.first(() -> false);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("현재 Direction right-true을 가지고 다음 Direction을 생성할 수 있다.")
    void createNestRigthTest() {

        // given
        Direction first = Direction.first(() -> true);
        Direction expected = Direction.from(true, false);

        // when
        Direction result = first.next(() -> true);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("equals, hashcode 테스트")
    void equalsHashCodeTest() {

        // given
        Direction direction = Direction.from(false, true);
        Direction copyDirection = Direction.from(false, true);

        // when & then
        assertThat(direction)
            .isEqualTo(copyDirection)
            .hasSameHashCodeAs(copyDirection);
    }

}