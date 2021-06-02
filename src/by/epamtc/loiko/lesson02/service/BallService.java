package by.epamtc.loiko.lesson02.service;

import by.epamtc.loiko.lesson02.entity.Ball;
import by.epamtc.loiko.lesson02.exception.NotPositiveValueException;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson02
 */
public final class BallService {

    private Ball ball;

    public BallService() {
    }

    public BallService(Ball ball) {
        this.ball = ball;
    }

    public void checkBallWeightVolume(Ball ball) throws NotPositiveValueException {
        if (ball.getWeight() <= 0 || ball.getVolume() <= 0) {
            throw new NotPositiveValueException("Вес и объём мяча должны принимать положительные значения.");
        }
    }

    public Ball getBall() {
        return ball;
    }
}