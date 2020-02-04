package volodymyr;

public class Human {

	private double weight;
	private double height;
	
	public Human(double weight, double height) {
		super();
		this.weight = weight;
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Human [weight=" + weight + ", height=" + height + "]";
	}
	
}
