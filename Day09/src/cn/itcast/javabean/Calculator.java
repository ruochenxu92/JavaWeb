package cn.itcast.javabean;

public class Calculator {
	private String firstNum;
	private String secondNum;
	private String operator;
	private double result;
	public String getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(String firstNum) {
		this.firstNum = firstNum;
	}
	public String getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(String secondNum) {
		this.secondNum = secondNum;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public double getResult() {
		double first = Double.parseDouble(firstNum);
		double second=Double.parseDouble(secondNum);
		if(operator.equals("+")){
			result = first + second;
		}else if(operator.equals("-")){
			result = first - second;
		}else if(operator.equals("*")){
			result = first * second;
		}else{
			result = first/second;
		}
		return result;

	}
	public void setResult(double result) {
		this.result = result;
	}
	
	
	
}
