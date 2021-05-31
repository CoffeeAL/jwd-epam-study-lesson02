package by.epamtc.loiko.lesson02;

import by.epamtc.loiko.lesson02.exception.NegativeValueException;
import by.epamtc.loiko.lesson02.emunerable.Color;
import by.epamtc.loiko.lesson02.entity.Ball;
import by.epamtc.loiko.lesson02.entity.Basket;
import by.epamtc.loiko.lesson02.exception.EmptyListException;
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

    public static void main(String[] args) {
        Basket emptyBasket = new Basket(17.0, 20);
        double totalWeight;
        long amountBlueBalls;
        try {
            List<Ball> balls = ListBallFactory.createListOfBalls();
            Basket basketWithBalls = fillInBasketByBalls(emptyBasket, balls);
            totalWeight = findTotalWeight(basketWithBalls.getBalls());
            amountBlueBalls = findColorBalls(Color.BLUE, basketWithBalls);
            printReport(totalWeight, Color.BLUE, amountBlueBalls);
        } catch (EmptyListException | NegativeValueException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Basket fillInBasketByBalls(Basket basket, List<Ball> balls)
            throws EmptyListException {
        if (balls == null || balls.size() == 0) {
            throw new EmptyListException("Нет доступных мячей для добавления в корзину.");
        }
        balls.stream().forEach(b -> basket.putBallInBasket(b));
        return basket;
    }

    public static double findTotalWeight(List<Ball> balls) {
        return balls.stream()
                .mapToDouble(w -> w.getWeight())
                .sum();
    }

    public static long findColorBalls(Color color, Basket basket) {
        return basket.getBalls().stream()
                .filter(c -> c.getColor() == color)
                .count();
    }

    public static void printReport(double weight, Color color, long amount) throws NegativeValueException {
        if (weight < 0.0 || amount < 0) {
            throw new NegativeValueException("Вес и количество мячей должны иметь неотрицательное значение.");
        }
        System.out.printf("Общий вес всех мячей в корзине: %.2f\n", weight);
        System.out.printf("Количество %s мячей в корзине: %d", color.toString(), amount);
    }
}