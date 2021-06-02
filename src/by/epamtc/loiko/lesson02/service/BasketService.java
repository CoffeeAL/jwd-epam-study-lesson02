package by.epamtc.loiko.lesson02.service;

import by.epamtc.loiko.lesson02.enumerable.Color;
import by.epamtc.loiko.lesson02.entity.Ball;
import by.epamtc.loiko.lesson02.entity.Basket;
import by.epamtc.loiko.lesson02.exception.NotAvailableBallException;
import by.epamtc.loiko.lesson02.exception.NotPositiveValueException;
import by.epamtc.loiko.lesson02.exception.OverVolumeException;
import by.epamtc.loiko.lesson02.exception.OverWeightException;

import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson02
 */
public final class BasketService {

    private static final BallService ballService = new BallService();
    private Basket basket;

    public BasketService() {
    }

    public BasketService(Basket basket) {
        this.basket = basket;
    }

    public double findTotalWeight(List<Ball> balls) {
        return balls.stream()
                .mapToDouble(w -> w.getWeight())
                .sum();
    }

    public double findTotalVolume(List<Ball> balls) {
        return balls.stream()
                .mapToDouble(v -> v.getVolume())
                .sum();
    }

    public long findColorBalls(Color color) {
        return basket.getBalls().stream()
                .filter(c -> c.getColor() == color)
                .count();
    }

    public void putBall(Ball ball) throws NotPositiveValueException, OverWeightException, OverVolumeException,
                                          NotAvailableBallException {
        ballService.checkBallWeightVolume(ball);
        checkBasketMaxWeightVolumeCapacity(basket);
        checkPossibilityPutBallInBasket(basket, ball);
        basket.putBallInBasket(ball);
    }

    public void pullBall(Ball ball) throws NotPositiveValueException, NotAvailableBallException {
        ballService.checkBallWeightVolume(ball);
        checkPossibilityPullBallFromBasket(basket, ball);
        basket.pullBallFromBasket(ball);
    }

    public void checkBasketMaxWeightVolumeCapacity(Basket basket) throws NotPositiveValueException {
        if (basket.getMaxWeightCapacity() <= 0 || basket.getMaxVolumeCapacity() <= 0) {
            throw new NotPositiveValueException("Максимальный вес, который можно положить в корзину, и " +
                    "объём, вмещаемый в корзину, должны принимать положительные значения.");
        }
    }

    public void checkPossibilityPutBallInBasket(Basket basket, Ball ball)
            throws NotAvailableBallException, OverWeightException, OverVolumeException {
        if (basket.getBalls().contains(ball) || ball.isInBasket()) {
            throw new NotAvailableBallException("Этот мяч уже лежит в этой или другой корзине.");
        }
        if (basket.weightLeft() < ball.getWeight()) {
            throw new OverWeightException("Корзина не выдержит вес этого мяча.");
        }
        if (basket.volumeLeft() < ball.getVolume()) {
            throw new OverVolumeException("В корзине нет места для этого мяча.");
        }
    }

    public void checkPossibilityPutBallsInBasket(Basket basket, List<Ball> balls)
            throws NotAvailableBallException, OverWeightException, OverVolumeException {
        if (balls.stream().mapToDouble(w -> w.getWeight()).sum() > basket.getMaxWeightCapacity()) {
            throw new OverWeightException("Мячи слишком тяжёлые для добавления в корзину.");
        }
        if (balls.stream().mapToDouble(v -> v.getVolume()).sum() > basket.getMaxVolumeCapacity()) {
            throw new OverVolumeException("Мячи не помещаются в корзину.");
        }
    }

    public void checkPossibilityPullBallFromBasket(Basket basket, Ball ball) throws NotAvailableBallException {
        if (!basket.getBalls().contains(ball)) {
            throw new NotAvailableBallException("Мяча в этой корзине нет.");
        }
    }

    public Basket getBasket() {
        return basket;
    }
}