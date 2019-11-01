package me.xXraxFraeyXx.SimpleNeuralNetwork.network;

import java.util.List;

public class NetworkInput extends Neuron {
    private double value;

    public NetworkInput() {
        value = 0;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double calculate(List<Double> inputs) {
        return value;
    }

}
