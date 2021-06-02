package by.epamtc.loiko.lesson02.entity;

import by.epamtc.loiko.lesson02.emunerable.Color;

import java.io.Serializable;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Ball implements Serializable {

    private Color color;
    private double weight;
    private double volume;
    private boolean isInBasket;

    public Ball() {
    }

    public Ball(Color color, double weight, double volume) {
        this.color = color;
        this.weight = weight;
        this.volume = volume;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean isInBasket() {
        return isInBasket;
    }

    public void setInBasket(boolean inBasket) {
        isInBasket = inBasket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball) o;
        return weight == ball.weight && volume == ball.volume && color == ball.color;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(weight);
        result = 31 * result + Double.hashCode(volume);
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ball{color = " + color + ", weight = " + weight + ", volume = " + volume + "}";
    }
}