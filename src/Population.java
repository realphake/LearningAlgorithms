
public class Population {

	NeuralNetwork denizens[];
	double fitness[];
	
	public Population(int numberOfDenizens) {
		denizens = new NeuralNetwork[numberOfDenizens];
		for( int i = 0; i < numberOfDenizens; i++ ) {
			fitness[i] = 0.0;
		}
	}
	
	public giveReward(int denizenID, double reward) {
		fitness[denizenID] += reward;
	}
	
	public int rouletteSelectDenizen() {
		double sumFitness = 0.0;
		for ( int id = 0; id < fitness.length; id++ ) {
			sumFitness += fitness[id];
		}
		rouletteBall = new Random().nextDouble(sumFitness); //TODO does this work?
		for ( int id = 0; id < fitness.length; id++ ) {
			if ( rouletteBall <= fitness[id] ) { //TODO less or equal or just less?
				return id;
			} else {
				sumFitness -= fitness[id]; // TODO enough?
			}
		}
	}
	
	public NeuralNetwork returnDenizen( int denizenID ) {
		return denizens[denizenID];
	}

}
