package be.pxl.lambdaexpressions.opdracht1;

public class NumberSelector {
	private NumberMachine machine;
	
	public NumberSelector(NumberMachine machine){
		this.machine = machine;
	}
	
	public String showEvenNumbers(){	
		NumberFilter filter = new NumberFilter(){
			public boolean check(int number) {
				if(number%2 == 0){
					return true;
				} else
					return false;
				}		
		};		
		return machine.processNumbers(filter);
	}
	
	public String showNumbersAbove(int number){
		NumberFilter filter = s -> {
			if (number < s){
				return true;
			} else {
				return false;
			}
		};
		return machine.processNumbers(filter);
	}
	
	public String printHexNumbers(){
	    String result = "";
	    int counter = 0;
		for(Integer i : machine.getNumbers()) {
			result += machine.convertNumbers(String -> Integer.toHexString(i));
			if(!(counter == machine.getNumbers().size()-1)){
				result += "-";
			}
			counter++;
		}
		return result;		
	}
}
