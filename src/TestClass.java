
public class TestClass {
	
	public static void main(String[] args) {
		double[][] test = {{1,2,3},{4,5,6}};
		double[][] m = {{1,2}};
		double[][] n = {{3,4},{5,6}};
		double[][] result = {{13,16}};
		int[] outputs = {5,2};
		
		NeuralNetwork nn = new NeuralNetwork(3,outputs);
		System.out.println( nn.toString() );
		if ( Matrix.cols(test) != 3 ) System.err.println("cols don't work");
		if ( Matrix.rows(test) != 2 ) System.err.println("rows don't work");
		if ( Matrix.multiply(n,m) != null ) System.err.println("multiply doesn't check size");
		if ( !Matrix.equal( Matrix.multiply(m,n), result ) ) System.err.println("multiply doesn't work");
		System.out.println("All tests passed");
	}

}
