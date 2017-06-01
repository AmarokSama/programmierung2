package ueb17;

import java.util.function.*;


public class Iterator {
	
	public Iterator(){}
	
	public double iterator(double x0, int n,  DoubleFunction<Double> function){
		double result = x0;
		for(int i=0; i < n; i++){
			result = function.apply(result);
		}
		return result;
	}
}
