package me.xXraxFraeyXx.SimpleNeuralNetwork.network;

import me.xXraxFraeyXx.SimpleNeuralNetwork.network.Layer;
import me.xXraxFraeyXx.SimpleNeuralNetwork.network.exception.InvalidInputsException;

import java.util.ArrayList;
import java.util.List;

public class InputsLayer extends Layer {
    private List<NetworkInput> neurons;

    public InputsLayer(int size) {
        neurons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            neurons.add(new NetworkInput());
        }
    }

    @Override
    public List<Double> calculate(List<Double> inputs) {
        List<Double> outputs = new ArrayList<Double>();
        for (NetworkInput neuron : neurons) {
            outputs.add(neuron.getValue());
        }
        return outputs;
    }

}
