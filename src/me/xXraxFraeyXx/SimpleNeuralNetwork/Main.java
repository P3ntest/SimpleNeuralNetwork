package me.xXraxFraeyXx.SimpleNeuralNetwork;

import me.xXraxFraeyXx.SimpleNeuralNetwork.network.Network;
import me.xXraxFraeyXx.SimpleNeuralNetwork.network.exception.InvalidInputsException;
import me.xXraxFraeyXx.SimpleNeuralNetwork.network.exception.NoNetworkInputsException;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoNetworkInputsException, InvalidInputsException {
	    Network network = new Network();

	    network.addInputLayer(2);
	    network.addLayer(2);
	    network.addLayer(1);

	    List<Double> inputs = new ArrayList<Double>();
	    inputs.add(1.0);
	    inputs.add(1.0);

	    network.debugNetwork();

	    System.out.println(network.calculate(inputs));
    }
}
