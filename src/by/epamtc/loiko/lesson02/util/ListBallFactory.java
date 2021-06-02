package by.epamtc.loiko.lesson02.util;

import by.epamtc.loiko.lesson02.enumerable.Color;
import by.epamtc.loiko.lesson02.entity.Ball;
import by.epamtc.loiko.lesson02.exception.NotPositiveValueException;
import by.epamtc.loiko.lesson02.service.BallService;

import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class ListBallFactory {

    public static List<Ball> createListOfBalls() throws NotPositiveValueException {
        List<Ball> balls = List.of(new Ball(Color.RED, 1.8, 2.5),
                                   new Ball(Color.GREEN, 0.62, 0.4),
                                   new Ball(Color.YELLOW, 1.3, 2.1),
                                   new Ball(Color.PINK, 0.93, 1.5),
                                   new Ball(Color.BLUE, 2.3, 3.0),
                                   new Ball(Color.WHITE, 0.56, 2.1),
                                   new Ball(Color.BLACK, 1.23, 0.8),
                                   new Ball(Color.GREEN, 2.1, 1.1),
                                   new Ball(Color.BLUE, 1.67, 1.11),
                                   new Ball(Color.BLUE, 2.1, 1.89),
                                   new Ball(Color.RED, 0.98, 1.14),
                                   new Ball(Color.PURPLE, 1.2, 0.97));
        BallService ballService = new BallService();
        for (Ball ball : balls) {
            ballService.checkBallWeightVolume(ball);
        }
        return balls;
    }
}