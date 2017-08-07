package flowerShop;

import java.util.List;


public class Bouquet {
	
	private List<Flower> flowerList;
	private List<Accessory> accessories;
	private Price bouquet;
	private Type type;
	private Stems stems;
	private Size size;
	private Freshness freshness;
	
	public enum Price {
		CHEAP, BUDGETARY, EXPENSIVE, VIP
	}
	public enum Type {
		ALL, WEDDING, FUNERAL, FESTIVE
	}
	public enum Stems {
		WITHOUT, SHORT, MIDDLE, LONG
	}
	public enum Size {
		SMALL, MEDIUM, LARGE, VERY_LARGE
	}
	
	public Bouquet(List<Flower> flowerList, List<Accessory> accessories, Price bouquet, Type type, Stems stems,
			Size size, Freshness freshness) {
		this.flowerList = flowerList;
		this.accessories = accessories;
		this.bouquet = bouquet;
		this.type = type;
		this.stems = stems;
		this.size = size;
	}

	public Price getBouquet() {
		return bouquet;
	}
	public void setBouquet(Price bouquet) {
		this.bouquet = bouquet;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Stems getStems() {
		return stems;
	}
	public void setStems(Stems stems) {
		this.stems = stems;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}

}
