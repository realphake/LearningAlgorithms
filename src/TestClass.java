
public class TestClass {
	
	public static void main(String[] args) {
		double[][] test = {{1,2,3},{4,5,6}};
		double[][] m = {{1,2}};
		double[][] n = {{3,4},{5,6}};
		double[][] result = {{13,16}};
		NeuralNetwork neurNet = new NeuralNetwork(2,1);
		double[] input = {4,2};
		double[] output = {6};
		
		if ( Matrix.cols(test) != 3 ) System.err.println("cols don't work");
		if ( Matrix.rows(test) != 2 ) System.err.println("rows don't work");
		if ( Matrix.multiply(n,m) != null ) System.err.println("multiply doesn't check size");
		if ( !Matrix.equal( Matrix.multiply(m,n), result ) ) System.err.println("multiply doesn't work");
		System.out.println( neurNet.giveOutput(input)[0] );
		System.out.println("All tests passed");
	}

}
