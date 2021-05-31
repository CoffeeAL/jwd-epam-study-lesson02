package by.epamtc.loiko.lesson02.util;

import by.epamtc.loiko.lesson02.exception.NegativeValueException;
import by.epamtc.loiko.lesson02.emunerable.Color;
import by.epamtc.loiko.lesson02.entity.Ball;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class ListBallFactory {

    public static List<Ball> createListOfBalls() throws NegativeValueException {
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(Color.RED, 1.8, 2.5));
        balls.add(new Ball(Color.GREEN, 0.62, 0.4));
        balls.add(new Ball(Color.YELLOW, 1.3, 2.1));
        balls.add(new Ball(Color.PINK, 0.93, 1.5));
        balls.add(new Ball(Color.BLUE, 2.3, 3.0));
        balls.add(new Ball(Color.WHITE, 0.56, 2.1));
        balls.add(new Ball(Color.BLACK, 1.23, 0.8));
        balls.add(new Ball(Color.GREEN, 2.1, 1.1));
        balls.add(new Ball(Color.BLUE, 1.67, 1.11));
        balls.add(new Ball(Color.BLUE, 2.1, 1.89));
        balls.add(new Ball(Color.RED, 0.98, 1.14));
        balls.add(new Ball(Color.PURPLE, 1.2, 0.97));
        return balls;
    }
}