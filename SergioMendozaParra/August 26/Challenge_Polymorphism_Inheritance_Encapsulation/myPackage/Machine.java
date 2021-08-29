package myPackage;

public class Machine {

	private String speed;
	private String color;	

	public void	printSpeed(String speed){
		System.out.println(speed);
	}
	public void	printColor(String color){
		System.out.println(color);
	}

	public void setSpeed(String car_speed){
		speed = car_speed;
	}

	public void setColor(String car_color){
		color = car_color;
	}

	public String getSpeed(){
		return speed;
	}

	public String getColor(){
		return color;
	}	
}