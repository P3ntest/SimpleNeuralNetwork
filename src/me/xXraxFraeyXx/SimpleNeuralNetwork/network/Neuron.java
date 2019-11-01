package me.xXraxFraeyXx.SimpleNeuralNetwork.network;

import me.xXraxFraeyXx.SimpleNeuralNetwork.network.exception.InvalidInputsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Neuron {

    private double bias;
    private List<Double> weights;

    public Neuron() {}

    public Neuron(int inputs) {
        Random r = new Random();
        bias = r.nextDouble();
        weights = new ArrayList<Double>();
        for (int i = 0; i < inputs; i++) {
            weights.add(r.nextDouble());
        }
    }

    public Neuron(List<Double> weights) {
        Random r = new Random();
        bias = r.nextDouble();
        this.weights = weights;
    }

    public Neuron(List<Double> weights, double bias) {
        this.bias = bias;
        this.weights = weights;
    }

    public Neuron(int inputs, double bias) {
        Random r = new Random();
        this.bias = bias;
        weights = new ArrayList<Double>();
        for (int i = 0; i < inputs; i++) {
            weights.add(r.nextDouble());
        }
    }

    public double calculate(List<Double> inputs) throws InvalidInputsException {
        if (inputs.size() >= weights.size())
            throw new InvalidInputsException("Size of inputs and wights do not match");

        double returnValue = bias;

        for (int i = 0; i < weights.size(); i++) {
            returnValue += weights.get(i) * inputs.get(i);
        }

        return returnValue;
    }

    public double getBias() { return bias; }
    public void setBias(double bias) { this.bias = bias; }

    public List<Double> getWeights() { return weights; }
    public void setWeights() { this.weights = weights; }

}
