package by.epamtc.loiko.lesson02.entity;

import by.epamtc.loiko.lesson02.exception.NegativeValueException;
import by.epamtc.loiko.lesson02.emunerable.Color;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study
 */
public class Ball implements Serializable {

    private Color color;
    private double weight;
    private double volume;

    public Ball() {
    }

    public Ball(Color color, double weight, double volume) throws NegativeValueException {
        if (weight < 0.0 || volume < 0) {
            throw new NegativeValueException("Вес и объём мяча не могут принимать отрицательные значения.");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                Double.compare(ball.volume, volume) == 0 &&
                color == ball.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, weight, volume);
    }

    @Override
    public String toString() {
        return "Ball{color = " + color + ", weight = " + weight + ", volume = " + volume + "}";
    }
}