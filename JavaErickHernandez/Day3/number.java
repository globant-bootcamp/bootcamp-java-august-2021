package bootcamp;

public class number {
	int coordinateX;
	int coordinateY;
	int value;
	public number(int coordinateX, int coordinateY, int value) {
		this.value = value;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}
	public int getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateXX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	public int getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
