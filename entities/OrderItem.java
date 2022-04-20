package entities;

public class OrderItem {
	
	
	private Double price;
	private Integer quantity;

	private Product product;
	
	public OrderItem() {
		
	}



	public OrderItem(Double price, Integer quantity, Product product) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.product = product;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	//Methods
	public double subTotal() {
		return price*quantity;
	}

}
