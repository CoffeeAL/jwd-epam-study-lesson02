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
    private List<Ball> balls;

    public Basket() {
    }

    public Basket(double maxWeightCapacity, double maxVolumeCapacity) {
        this.maxWeightCapacity = maxWeightCapacity;
        this.maxVolumeCapacity = maxVolumeCapacity;
        balls = new ArrayList<>();
    }

    public void putBallInBasket(Ball ball) {
        balls.add(ball);
        ball.setInBasket(true);
    }

    public void putBallsInBasket(List<Ball> balls) {
        this.balls.addAll(balls);
        balls.forEach(b -> b.setInBasket(true));
    }

    public void pullBallFromBasket(Ball ball) {
        balls.remove(ball);
        ball.setInBasket(false);
    }

    public double calculateBallsInBasketWeight() {
        double totalWeight = balls.stream().mapToDouble(w -> w.getWeight()).sum();
        return totalWeight;
    }

    public double calculateBallsInBasketVolume() {
        double totalVolume = balls.stream().mapToDouble(v -> v.getVolume()).sum();
        return totalVolume;
    }

    public double weightLeft() {
        return maxWeightCapacity - this.calculateBallsInBasketWeight();
    }

    public double volumeLeft() {
        return maxVolumeCapacity - this.calculateBallsInBasketVolume();
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
        if (maxWeightCapacity != basket.maxWeightCapacity || maxVolumeCapacity != basket.maxVolumeCapacity) {
            return false;
        }
        return balls.equals(basket.balls);
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