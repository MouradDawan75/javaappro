package association;

public class Adresse {
	
	private int num;
	private String street;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Adresse(int num, String street) {
		super();
		this.num = num;
		this.street = street;
	}
	public Adresse() {
		super();
	}
	
	

}
