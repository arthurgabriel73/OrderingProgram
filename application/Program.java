package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException{
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		//client
		
		System.out.println("Enter client data");
		
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		
		System.out.print("Birth date: ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, birthDate);
		
		
		//order data
		
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		sc.nextLine();
		String orderStatus = sc.nextLine();
		Date moment = new Date();
		Order order = new Order(moment, OrderStatus.valueOf(orderStatus), client);
		
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		
		
		//data per order using for
		
		for(int i=0; i<N; i++) {
			System.out.println("Enter #"+(i+1)+" item data:");
			
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			OrderItem ordItem = new OrderItem(productPrice, productQuantity, product);
			order.addOrder(ordItem);
		}
		
		//ORDER SUMARY
		
		System.out.println("ORDER SUMARY: ");
		
		System.out.println(order);
	
		sc.close();
	}

}
