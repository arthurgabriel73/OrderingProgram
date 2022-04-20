package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Product product = new Product();
	private Date moment;
	private OrderStatus status;

	// associações

	private List<OrderItem> orders = new ArrayList<OrderItem>();
	private Client client;

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrders() {
		return orders;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// methods

	public void addOrder(OrderItem order) {
		orders.add(order);

	}

	public void removeOrder(OrderItem order) {
		orders.remove(order);
	}

	public double Total() {
		double sum = 0;

		for (OrderItem ord : orders) {

			sum += ord.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Order moment: ");
		sb.append(sdf.format(moment));
		sb.append("\nOrder status: ");
		sb.append(status);
		sb.append("\nClient: ");
		sb.append(client +"\n");
		sb.append("Order items:\n");
		
		for (OrderItem ord:orders) {
			sb.append(ord.getProduct());
			sb.append(", Quantity: ");
			sb.append(ord.getQuantity());
			sb.append(String.format(", Subtotal: $%.2f",ord.subTotal()));
			sb.append("\n");
		}
		sb.append(String.format("Total price: $%.2f", Total()));
		
		return sb.toString();
	}

}
