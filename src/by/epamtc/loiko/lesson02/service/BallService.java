package by.epamtc.loiko.lesson02.service;

import by.epamtc.loiko.lesson02.entity.Ball;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson02
 */
public final class BallService {

    private Ball ball;

    public BallService() {
        ball = new Ball();
    }

    public BallService(Ball ball) {
        this.ball = ball;
    }

    public boolean areCorrectWeightAndVolume() {
        return ball.getWeight() > 0 && ball.getVolume() > 0;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}