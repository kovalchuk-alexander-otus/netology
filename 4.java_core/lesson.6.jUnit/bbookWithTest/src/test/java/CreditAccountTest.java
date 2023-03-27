import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.maki.CreditAccount;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreditAccountTest {

    CreditAccount account;
    static final long balance = -1000;
    static final long limit = 100_000;

    // тестируем открытие Кредитного счета (позитивный тест - отрицательный баланс)
    @BeforeEach
    public void testOpenAccount() {
        this.account = new CreditAccount(balance, limit);
    }

    // тестируем создание Кредитного счета с полоджительным остатком
    // TODO: смущает тот момент, что для этого конкретно теста не требуется выполнение @BeforeEach
    @Test
    public void testInitAccountWithPositiveBalance() {
        System.out.println("Запуск теста - testInitAccountWithPositiveBalance");
        // .. исправлен баг - возможность инициировать Кредитный счет с положительным балансом
        // given
        long positiveBalance = 1000;
        Class<RuntimeException> expected = RuntimeException.class;

        // when
        Executable executable = () -> {
            CreditAccount creditAccount = new CreditAccount(positiveBalance, limit);
        };

        // then
        Assertions.assertThrows(expected, executable);
    }

    // тестируем пополнение
    @ParameterizedTest
    @MethodSource("addTestParameters") // given
    public void testAdd(long amount, long expected) {
        // when
        System.out.println(this.account);
        this.account.add(amount);

        // then
        long actual = this.account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    public static Stream<Arguments> addTestParameters() {
        // .. исправлен баг - возможность пополнения на отрицательную сумму
        return Stream.of(Arguments.of(-balance, 0) // полное погашение
                , Arguments.of(0, balance) // пополнение на 0
                , Arguments.of(100, balance + 100) // пополнение на 100
                , Arguments.of(-1, balance) // пополнение на отрицательную сумму запрещено
                , Arguments.of(-balance + 1, balance) // попытка пополнить на сумму больше остатка
                , Arguments.of(-balance / 2, balance / 2) // пополнение на половину текущего остатка
        );
    }

    // тестируем списание
    @ParameterizedTest
    @MethodSource("payTestParameters") // given
    public void testPay(long amount, long expected) {
        // when
        System.out.println(this.account);
        this.account.pay(amount);

        // then
        long actual = account.getBalance();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("payTestParameters")
    public void testPayHamcrest(long amount, long expected) {
        // when
        this.account.pay(amount);

        // then
        long actual = account.getBalance();
        assertThat(actual, lessThanOrEqualTo(0L));
        assertThat(actual, equalTo(expected));
    }

    public static Stream<Arguments> payTestParameters() {
        return Stream.of(Arguments.of(0, balance) // списание 0
                , Arguments.of(100, balance - 100) // списание 100
                , Arguments.of(balance, balance) // списание отрицательной суммы запрещено
                , Arguments.of(limit + balance, -limit) // достижение лимита кредитных средств
                , Arguments.of(limit + balance + 1, balance) // проверка запрета списания больше кредитного лимита
        );
    }

    // проверка наличия поля Лимит и значения
    @Test
    public void testLimit() {
        assertThat(this.account, hasProperty("limit"));
        assertThat(this.account, hasProperty("limit", equalTo(limit)));
    }

}
