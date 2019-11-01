package me.xXraxFraeyXx.SimpleNeuralNetwork.network;

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
        layers.add(new InputsLayer());
    }

}
