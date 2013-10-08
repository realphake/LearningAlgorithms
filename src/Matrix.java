
public class Matrix {

	public static double[][] multiply(double[][] m, double[][] n) {
		if ( cols(m) == rows(n) ) {
			double[][] output = fillAnswerMatrix(m, n);
			return output;
		} else {
			return null;
		}
	}

	static int rows(double[][] m) {
		return m.length;
	}

	static int cols(double[][] m) {
		return m[0].length;
	}

	static boolean equal( double[][] m, double[][] n ) {
		if ( sizesDontMatch(m, n) ) return false;
		for (int i = 0; i < Matrix.rows(m); i++ ){
			for (int j = 0; j < Matrix.cols(n); j++ ){
				if ( m[i][j] != n[i][j] ) return false;
			}
		}
		return true;
	}
	
	private static double[][] fillAnswerMatrix(double[][] m, double[][] n) {
		double[][] output = new double[rows(m)][cols(n)];
		for ( int i = 0; i < rows(m); i++ ) {
			for ( int j = 0; j < cols(n); j++ ) {
				output[i][j] = calculateElement(m, n, i, j);
			}
		}
		return output;
	}

	private static double calculateElement(double[][] m, double[][] n, int i, int j) {
		double runningTotal = 0;
		for ( int place = 0; place < cols(m); place++ ) {
			runningTotal += m[i][place]*n[place][j];
		}
		return runningTotal;
	}

	private static boolean sizesDontMatch(double[][] m, double[][] n) {
		return !(cols(m) == cols(n) && rows(m) == rows(n));
	}

}
