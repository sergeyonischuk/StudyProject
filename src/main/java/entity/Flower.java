package entity;

public class Flower extends Plant {
	
	private boolean isTopDressingNeeded;
	private boolean isBackingNeeded;

	private enum BloomType {
		SINGLE_COLOR, MULTICOLOR
	}

	public Flower(boolean isTopDressingNeeded, boolean isBackingNeeded) {
		this.isTopDressingNeeded = isTopDressingNeeded;
		this.isBackingNeeded = isBackingNeeded;
	}
	
	
	
}
