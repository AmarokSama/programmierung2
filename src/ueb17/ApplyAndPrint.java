package ueb17;

import java.util.function.*;

public class ApplyAndPrint {

	public ApplyAndPrint(){}
	
	public void applyAndPrint(int i, int j, IntFunction<Integer> function){
		String sResult = "";
		int result = 0;
		for (int r= i; r<j; r++){
			result = function.apply(r);
			sResult += sResult.format("%d: %d \n",r, result);
		}
		System.out.print(sResult);
	}
	
	
}
