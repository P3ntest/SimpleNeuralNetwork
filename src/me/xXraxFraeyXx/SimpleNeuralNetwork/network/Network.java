package me.xXraxFraeyXx.SimpleNeuralNetwork.network;

import me.xXraxFraeyXx.SimpleNeuralNetwork.network.exception.InvalidInputsException;
import me.xXraxFraeyXx.SimpleNeuralNetwork.network.exception.NoNetworkInputsException;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Layer> layers;

    public Network() {
        layers = new ArrayList<Layer>();
    }

    public void addLayer(int neurons) throws NoNetworkInputsException {
        if (layers.size() == 0)
            throw new NoNetworkInputsException("First Layer has to be Inputs Layer");

        layers.add(new Layer(neurons, layers.get(layers.size() - 1).getNeurons().size()));
    }

    public void addInputLayer(int size) {
        if (layers.size() > 0) {
            layers.set(0, new InputsLayer(size)); }
        else {
            layers.add(new InputsLayer(size));
        }
    }

    public List<Double> calculate() {
        return runSim();
    }

    public List<Double> calculate(List<Double> networkInputs) throws InvalidInputsException {
        System.out.println(networkInputs.size());
        System.out.println(layers.get(0).getNeurons().size());
        if (networkInputs.size() != layers.get(0).getNeurons().size())
            throw new InvalidInputsException("Size of Inputs does not match with Inputnodes");

        int i = 0;
        for (Neuron neuron : layers.get(0).getNeurons()) {
            ((NetworkInput) neuron).setValue(networkInputs.get(i));
        }

        return runSim();
    }

    public void debugNetwork() {
        info("Layers: " + layers.size());
        debug("Is first InputLayer: " + (layers.get(0) instanceof InputsLayer));
    }

    private List<Double> runSim() {
        List<Double> currentInput = layers.get(0).calculate(null);

        for (int i = 1; i < layers.size(); i++) {
            currentInput = layers.get(i).calculate(currentInput);
        }

        return currentInput;
    }

    private boolean debug = true;
    private boolean info = true;

    private void debug(String message) {
        if (debug)
            System.out.println(message);
    }

    private void info(String message) {
        if (info)
            System.out.println(message);
    }

}
