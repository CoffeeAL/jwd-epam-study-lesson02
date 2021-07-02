package by.epamtc.loiko.lesson02;

import by.epamtc.loiko.lesson02.entity.Ball;
import by.epamtc.loiko.lesson02.entity.Basket;
import by.epamtc.loiko.lesson02.enumerable.Color;
import by.epamtc.loiko.lesson02.exception.NotPositiveValueException;
import by.epamtc.loiko.lesson02.service.BasketService;
import by.epamtc.loiko.lesson02.util.ListBallFactory;

import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */

/**
 * Создать классы Мяч и Корзина. Наполнить корзину мячами.
 * Найти общий вес мячей в корзине. Найти количество синих мячей.
 */
public class BasketBallRunner {

    public static final Color BLUE_COLOR = Color.BLUE;

    public static void main(String[] args) {
        List<Ball> balls = ListBallFactory.createListOfBalls();
        Basket basket = new Basket(20.0, 20.0);
        BasketService basketService = new BasketService(basket);
        basketService.putCollectionBalls(balls);
        double totalWeight = basketService.findTotalWeight();
        long amountBlueBalls = basketService.findColorBalls(BLUE_COLOR);
        try {
            printReport(totalWeight, BLUE_COLOR, amountBlueBalls);
        } catch (NotPositiveValueException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void printReport(double weight, Color color, long amount) throws NotPositiveValueException {
        if (weight < 0.0 || amount < 0) {
            throw new NotPositiveValueException("Вес и количество мячей должны иметь неотрицательное значение.");
        }
        System.out.printf("Общий вес всех мячей в корзине: %.2f\n", weight);
        System.out.printf("Количество %s мячей в корзине: %d\n", color.toString(), amount);
    }
}