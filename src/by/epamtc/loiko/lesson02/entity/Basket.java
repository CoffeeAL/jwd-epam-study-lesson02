package by.epamtc.loiko.lesson02.entity;

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
        maxVolumeCapacity = 1.0;
        maxVolumeCapacity = 1.0;
    }

    public Basket(double maxWeightCapacity, double maxVolumeCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
        this.maxVolumeCapacity = maxVolumeCapacity;
    }

    public boolean putBallInBasket(Ball ball) {
        return balls.add(ball);
    }

    public boolean putBallsInBasket(List<Ball> balls) {
        return this.balls.addAll(balls);
    }

    public boolean pullBallFromBasket(Ball ball) {
        return balls.remove(ball);
    }

    public double calculateBallsInBasketWeight() {
        double totalWeight = 0.0;
        for (Ball ball : balls) {
            totalWeight += ball.getWeight();
        }
        return totalWeight;
    }

    public double calculateBallsInBasketVolume() {
        double totalVolume = 0.0;
        for (Ball ball : balls) {
            totalVolume += ball.getVolume();
        }
        return totalVolume;
    }

    public double weightLeft() {
        return maxWeightCapacity - calculateBallsInBasketWeight();
    }

    public double volumeLeft() {
        return maxVolumeCapacity - calculateBallsInBasketVolume();
    }

    public double getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public void setMaxWeightCapacity(double maxWeightCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public double getMaxVolumeCapacity() {
        return maxVolumeCapacity;
    }

    public void setMaxVolumeCapacity(double maxVolumeCapacity) {
        this.maxVolumeCapacity = maxVolumeCapacity;
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;
        Basket basket = (Basket) o;
        return this.maxWeightCapacity == basket.maxWeightCapacity && this.maxVolumeCapacity == basket.maxVolumeCapacity
        && this.balls.equals(basket.balls);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(maxWeightCapacity);
        result = 31 * result + Double.hashCode(maxVolumeCapacity);
        result = 31 * result + balls.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Basket{maxWeightCapacity = " + maxWeightCapacity + ", maxVolumeCapacity = " + maxVolumeCapacity +
                ", balls = " + balls + "}";
    }
}