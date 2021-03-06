package Test;

public class SomeMathFunction {
	public static int xSquare(int x){
        return x*x;
    }
    
    public static int xFactorial(int x){
        int result = 1;
        for (int i=1; i <= x; i++){
            result = result * i;
        }
        return result;
    }
    
    public static int xPowerXPlus1(int x){
        int result = 1;
        for(int i = 1; i <= x+1; i++){
            result *= x; 
        }
        return result;
    }
    
    public static int xFibonacci(int x){
    	
    	if(x <= 0){
    		return 0;     
        }
    	else if(x == 1){
    		return 1;
    	}else{
    		return xFibonacci(x-1) +xFibonacci(x-2);
    	}
    }
}
