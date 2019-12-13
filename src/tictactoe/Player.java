package tictactoe;

public class Player {
	// constant(s)
	private static final String DEFAULT_NAME = "Player";
	
	// variable declaration
	private String name;
	private String sign;
	
	Player(String sign) {
		this.sign = sign;
		this.name = DEFAULT_NAME;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
	String getSign() {
		return this.sign;
	}
}
