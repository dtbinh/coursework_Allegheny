public class Polo {
	private int degrees;
	private double distance;
	private double value;
	
	public Polo(double dis, int deg) {
		distance = dis;
		degrees = deg;
		value = 1/distance;
	}
	
	public double getDist() {
		return distance;
	}

	public double getVal() {
		return value;
	}
	
	public int getDeg() {
		return degrees;
	}
	
	
	public void setDist(double d){
		distance = d;
	}
	
	public void setDeg(int sd){
		degrees = sd;
	}
}