package HW_1;

import static org.assertj.core.api.Assertions.*;

// Задание 1. ** В классе Calculator создайте метод calculateDiscount,
// который принимает сумму покупки и процент скидки и возвращает сумму
// с учетом скидки. Ваша задача - проверить этот метод с использованием
// библиотеки AssertJ. Если метод calculateDiscount получает недопустимые
// аргументы, он должен выбрасывать исключение ArithmeticException.
// Не забудьте написать тесты для проверки этого поведения.

public class Main {
    public static void main(String[] args) {

        assertThat(calculateDiscount(100, 20)
        ).isEqualTo(80);
        assertThat(calculateDiscount(1.0, 10.0)
        ).isEqualTo(0.9);
        assertThat(calculateDiscount(100.0, 0)
        ).isEqualTo(100.0);
        assertThat(calculateDiscount(100.0, 100.0)
        ).isEqualTo(0.0);

        assertThatThrownBy(
                () -> calculateDiscount(100, -5))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(
                () -> calculateDiscount(100, 101))
                .isInstanceOf(ArithmeticException.class);

        System.out.println("Цена со скидкой: " + calculateDiscount(
                100, 31));
    }

    public static double calculateDiscount(double purchaseAmount,
                                           double discountAmount) {
        if (discountAmount > 100) {
            throw new ArithmeticException("Скидка не может быть больше 100%");
        }
        if (discountAmount < 0) {
            throw new ArithmeticException("Скидка не может быть отрицательной");
        }
        return purchaseAmount * ((100 - discountAmount) / 100);
    }
}