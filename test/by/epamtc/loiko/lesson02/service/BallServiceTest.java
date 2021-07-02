package by.epamtc.loiko.lesson02.service;

import by.epamtc.loiko.lesson02.entity.Ball;
import by.epamtc.loiko.lesson02.enumerable.Color;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson02
 */
public class BallServiceTest {

    private BallService service = new BallService();

    @Test
    public void checkLegalBallParameters() {
        Ball ball = new Ball(Color.BLACK, 56.0, 19.3);
        service.setBall(ball);
        Assert.assertTrue(service.areLegalWeightAndVolume());
    }

    @Test
    public void checkIllegalBallParameters() {
        Ball ball = new Ball(Color.RED, -56.0, 19.3);
        service.setBall(ball);
        Assert.assertFalse(service.areLegalWeightAndVolume());
    }
}