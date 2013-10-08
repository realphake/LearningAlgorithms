import java.util.Random;

public class NeuralNetwork {
	
	int inAmount;
	int outAmount;
	double weights[][];
	Random randGen;
	
	public NeuralNetwork( int inputArguments, int outputArguments ) {
		inAmount = inputArguments;
		outAmount = outputArguments;
		randGen = new Random();
		// weights[columns][rows] = weights[output][input]
		weights = new double[inAmount][outAmount];
		for ( int i = 0; i < inAmount; i++ ) {
			for ( int o = 0; o < outAmount; o++ ) {
				weights[i][o] = randGen.nextDouble();
			}
		}
	}
	
	public double[] giveOutput( double[] input ) {
		double[][] inputMatrix = {input};
		double[] output = Matrix.multiply(inputMatrix, weights)[0];
		return output;
		
	}

}
