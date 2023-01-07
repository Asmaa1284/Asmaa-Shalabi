

public class Items {    // M3 USING BUILDER
	private String brand,name, discreption,color;
	private int quatntity; 
	private float wieght; 
	private float price;
	private Items(ItemBuilder builder) {
		this.brand=builder.brand;
		this.name=builder.name;
		this.discreption=builder.discreption;
		this.color=builder.color;
		this.quatntity=builder.quatntity;
		this.wieght=builder.wieght;
		this.price=builder.price;
	}
	public static class ItemBuilder {
		private String brand,name;
		private float price;
		private String discreption="",color="";
		private int quatntity=1; 
		private float wieght=0.0f; 
		public ItemBuilder(String brand,String name ,float price) {
			this.brand=brand;
			this.name= name;
			this.price=price;
			
		}
		public ItemBuilder discreption(String disc) {
			this.discreption=disc;
			return this;
		}
		public ItemBuilder color(String c) {
			this.color=c;
			return this;
		}
		public ItemBuilder quantity(int q) {
			this.quatntity=q;
			return this;
		}
		public ItemBuilder weight(float w) {
			this.wieght=w;
			return this;
		}
		public Items build() {
			return new Items(this);
		}
		
		
	}

}
