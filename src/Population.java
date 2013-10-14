
public class Population {

	NeuralNetwork denizens[];
	double fitness[];
	
	public Population(int numberOfDenizens) {
		denizens = new NeuralNetwork[numberOfDenizens];
		for( int i = 0; i < numberOfDenizens; i++ ) {
			fitness[i] = 0.0;
		}
	}

}
