import java.util.Random;


public class Population {

	NeuralNetwork denizens[];
	double fitness[];
	Random randGen;
	
	public Population(int numberOfDenizens) {
		denizens = new NeuralNetwork[numberOfDenizens];
		for( int i = 0; i < numberOfDenizens; i++ ) {
			fitness[i] = 0.0;
		}
		randGen = new Random();
	}
	
	public int populationSize() {
		return denizens.length;
	}
	
	public void giveReward(int denizenID, double reward) {
		fitness[denizenID] += reward;
	}
	
	public int rouletteSelectDenizen() {
		double rouletteBall = throwRouletteBall();
		return whatDenizenDidBallLandOn(rouletteBall);
	}

	private int whatDenizenDidBallLandOn(double rouletteBall) {
		double sumFitness = 0;
		for ( int id = 0; id < fitness.length; id++ ) {
			if ( rouletteBall <= fitness[id] + sumFitness ) {
				return id;
			} else {
				sumFitness += fitness[id];
			}
		}
		return -1;
	}

	private double throwRouletteBall() {
		double sumFitness = 0.0;
		for ( int id = 0; id < fitness.length; id++ ) {
			sumFitness += fitness[id];
		}
		return randGen.nextDouble()*sumFitness;
	}
	
	public NeuralNetwork returnDenizen( int denizenID ) {
		return denizens[denizenID];
	}
	
	public double[] askDenizen( int denizenID, double[] question ) {
		return denizens[denizenID].giveOutput(question);
	}
	
	public void generation() {
		NeuralNetwork newDenizens[] = denizens;
		for ( int id = 0; id < newDenizens.length; id++ ) {
			// TODO this needs to mutate and crossover!
			newDenizens[id] = denizens[rouletteSelectDenizen()];
		}
		denizens = newDenizens;
	}

}
