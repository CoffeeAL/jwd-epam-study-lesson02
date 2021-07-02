package by.epamtc.loiko.lesson02.service;

import by.epamtc.loiko.lesson02.entity.Ball;
import by.epamtc.loiko.lesson02.entity.Basket;
import by.epamtc.loiko.lesson02.enumerable.Color;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson02
 */
public class BasketServiceTest {

    private Ball redBall;
    private Basket basket = new Basket();
    private BasketService service = new BasketService(basket);

    @Before
    public void fillBasket() {
        redBall = new Ball(Color.RED, 4.0, 2.0);
        service.getBasket().setMaxVolumeCapacity(30.0);
        service.getBasket().setMaxWeightCapacity(20.0);
        service.putBall(new Ball(Color.WHITE, 3.7, 2.9));
        service.putBall(redBall);
        service.putBall(new Ball(Color.WHITE, 4.1, 9.4));
        service.putBall(new Ball(Color.BLUE, 5.2, 7.2));
        service.putBall(new Ball(Color.BLUE, 1.5, 5.2));
    }

    @Test
    public void checkFindTotalWeight() {
        double totalWeight = service.findTotalWeight();
        Assert.assertTrue(totalWeight == 18.5);
    }

    @Test
    public void checkFindTotalVolume() {
        double totalVolume = service.findTotalVolume();
        Assert.assertTrue(totalVolume == 26.7);
    }

    @Test
    public void checkFindColorBalls() {
        int whiteBallsAmount = service.findColorBalls(Color.WHITE);
        Assert.assertTrue(whiteBallsAmount == 2);
    }

    @Test
    public void checkNullColor() {
        int nullColorAmount = service.findColorBalls(null);
        Assert.assertTrue(nullColorAmount == -1);
    }

    @Test
    public void checkPutLegalBall() {
        Ball ball = new Ball(Color.BLACK, 1.0, 3.0);
        Assert.assertTrue(service.putBall(ball));
    }

    @Test
    public void checkAttemptPutIllegalBall() {
        Ball ball = new Ball(Color.BLACK, 0.0, 3.0);
        Assert.assertFalse(service.putBall(ball));
    }

    @Test
    public void checkAttemptPutOverweightBall() {
        Ball ball = new Ball(Color.YELLOW, 2.0, 3.0);
        Assert.assertFalse(service.putBall(ball));
    }

    @Test
    public void checkAttemptPutBigBall() {
        Ball ball = new Ball(Color.PURPLE, 1.0, 5.0);
        Assert.assertFalse(service.putBall(ball));
    }

    @Test
    public void checkAttemptPutNullBall() {
        Assert.assertFalse(service.putBall(null));
    }

    @Test
    public void checkAttemptPullBall() {
        Assert.assertTrue(service.pullBall(redBall));
    }

    @Test
    public void checkPullNullBall() {
        Assert.assertFalse(service.pullBall(null));
    }

    @Test
    public void checkPutCollectionOfBalls() {
        List<Ball> ballsFromSource = service.getBasket().getBalls();
        Basket targetBasket = new Basket(50.0, 50.0);
        service.setBasket(targetBasket);
        Assert.assertTrue(service.putCollectionBalls(ballsFromSource));
    }

    @Test
    public void checkPutNullCollectionOfBalls() {
        Basket targetBasket = new Basket(50.0, 50.0);
        service.setBasket(targetBasket);
        Assert.assertFalse(service.putCollectionBalls(null));
    }
}