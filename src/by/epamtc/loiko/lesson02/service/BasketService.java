package by.epamtc.loiko.lesson02.service;

import by.epamtc.loiko.lesson02.entity.Ball;
import by.epamtc.loiko.lesson02.entity.Basket;
import by.epamtc.loiko.lesson02.enumerable.Color;

import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson02
 */
public final class BasketService {

    private BallService ballService = new BallService();
    private Basket basket;

    public BasketService(Basket basket) {
        this.basket = basket;
    }

    public double findTotalWeight() {
        return basket.calculateBallsInBasketWeight();
    }

    public double findTotalVolume() {
        return basket.calculateBallsInBasketVolume();
    }

    public int findColorBalls(Color color) {
        if (color == null) {
            return -1;
        }
        List<Ball> balls = basket.getBalls();
        int counter = 0;
        for (Ball ball : balls) {
            if (ball.getColor() == color) {
                counter++;
            }
        }
        return counter;
    }

    public boolean putBall(Ball ball) {
        if (ball == null) {
            return false;
        }
        ballService.setBall(ball);
        if (isNotValidBallOrBasketParameters()) {
            return false;
        }
        return checkPossibilityPutBallInBasket(ball) ? basket.putBallInBasket(ball) : false;
    }

    private boolean isNotValidBallOrBasketParameters() {
        return !ballService.areLegalWeightAndVolume() || !areLegalMaxWeightAndVolumeCapacity();
    }

    private boolean areLegalMaxWeightAndVolumeCapacity() {
        return basket.getMaxWeightCapacity() > 0 && basket.getMaxVolumeCapacity() > 0;
    }

    private boolean checkPossibilityPutBallInBasket(Ball ball) {
        return !basket.getBalls().contains(ball) && basket.weightLeft() >= ball.getWeight() &&
                basket.volumeLeft() >= ball.getVolume();
    }

    public boolean putCollectionBalls(List<Ball> balls) {
        if (balls == null) {
            return false;
        }
        for (Ball ball : balls) {
            ballService.setBall(ball);
            if (isNotValidBallOrBasketParameters()) {
                return false;
            }
        }
        return checkPossibilityPutCollectionOfBallsInBasket(balls) ? basket.putCollectionOfBalls(balls) : false;
    }

    private boolean checkPossibilityPutCollectionOfBallsInBasket(List<Ball> balls) {
        double totalWeightBalls = 0.0;
        double totalVolumeBalls = 0.0;
        for (Ball ball : balls) {
            totalWeightBalls += ball.getWeight();
            totalVolumeBalls += ball.getVolume();
        }
        return totalWeightBalls <= basket.weightLeft() && totalVolumeBalls <= basket.volumeLeft();
    }

    public boolean pullBall(Ball ball) {
        if (ball == null) {
            return false;
        }
        ballService.setBall(ball);
        if (isNotValidBallOrBasketParameters()) {
            return false;
        }
        return checkPossibilityPullBallFromBasket(ball) ? basket.pullBallFromBasket(ball) : false;
    }

    private boolean checkPossibilityPullBallFromBasket(Ball ball) {
        return basket.getBalls().contains(ball);
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}