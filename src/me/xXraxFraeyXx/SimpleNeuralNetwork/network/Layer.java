package me.xXraxFraeyXx.SimpleNeuralNetwork.network;

import me.xXraxFraeyXx.SimpleNeuralNetwork.network.exception.InvalidInputsException;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private List<Neuron> neurons;

    public Layer() {
        neurons = new ArrayList<Neuron>();
    }

    public List<Neuron> getNeurons() { return neurons; }
    public void setNeurons(List<Neuron> neurons) { this.neurons = neurons; }

    public Layer(int neurons, int inputs) {
        this.neurons = new ArrayList<Neuron>();
        for (int i = 0; i < neurons; i++)
            this.neurons.add(new Neuron(inputs));
    }

    public List<Double> calculate(List<Double> inputs) {
        List<Double> outputs = new ArrayList<Double>();
        for (Neuron neuron : neurons) {
            try {
                outputs.add(neuron.calculate(inputs));
            } catch (InvalidInputsException e) {
                e.printStackTrace();
            }
        }
        return outputs;
    }
}
