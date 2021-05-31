package by.epamtc.loiko.lesson02.entity;

import by.epamtc.loiko.lesson02.exception.OverVolumeException;
import by.epamtc.loiko.lesson02.exception.OverWeightException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Basket implements Serializable {

    private double maxWeightCapacity;

    private double maxVolumeCapacity;

    private List<Ball> balls = new ArrayList<>();

    public Basket() {
    }

    public Basket(double maxWeightCapacity, double maxVolumeCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
        this.maxVolumeCapacity = maxVolumeCapacity;
    }

    public void putBallInBasket(Ball ball) {
        if (this.balls.stream().mapToDouble(w -> w.getWeight()).sum() + ball.getWeight() > this.maxWeightCapacity) {
            throw new OverWeightException("При добавлении мяча корзина будет перегружена.");
        }
        if (this.balls.stream().mapToDouble(w -> w.getVolume()).sum() + ball.getVolume() > this.maxVolumeCapacity) {
            throw new OverVolumeException("Мяч уже не помещается в корзину.");
        }
        this.balls.add(ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }
}