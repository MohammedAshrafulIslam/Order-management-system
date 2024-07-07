package ordermanagementsystem;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

/**
 * The {@code Container} class is a generic container that can hold objects. It
 * provides methods for adding and removing objects, as well as querying the
 * size of the container.
 */
public class Container {
	
	
	
	public void add(Object object) {
		this.add(object);
	}
	
	
	public Object remove() {
		return this.remove();
	}
	
	public int getSize() {
		return this.getSize();
	}
	
}

/**
 * The {@code Queue} class simulates a queue data structure, inserting and
 * removing data by the FIFO (first-in, first-out) rule. It stores orders with a
 * total amount above or equal to 1500 in the queue.
 *
 */
class Queue extends Container {

	
	private ArrayList<Order> queue;
	
	
	public Queue(String fileName) throws FileNotFoundException {
		 this.queue =  new ArrayList<>();
     	 List<String> datas= IOHandler.readFile(fileName);
		 
	
     	 
     	 for(String s: datas ) {
			 
     		 String[] details = s.split(",");
     		 
     		 
     		 int orderId = Integer.parseInt(details[0].trim());
     		 String customerName = details[1].trim();
     		 String productName = details[2].trim();
     		 int quantity = Integer.parseInt(details[3].trim());
     		 double unitPrice = Double.parseDouble(details[4].trim());
     		 
     		 Order order =  new Order(orderId, customerName, productName, quantity, unitPrice);
     		 
     		 if(order.getTotalAmount() >= 1500) {
     			 queue.add(order);
     		 }
     		 
     		 
     		 
	 }
		 
		 
	}


	@Override
	public void add(Object object) {
		
		Order order = (Order) object;
		
		if(order.getTotalAmount() >= 1500) {
			queue.add(order);
		}
	}


	@Override
	public Object remove() {
		
		if(queue.isEmpty()) {
			return null;
		}
		
		return queue.remove(0);
	}
	
	public Object top() {
		if(queue.isEmpty()) {
			return null;
		}
		
		return queue.get(0);
	}


	@Override
	public int getSize() {
		return queue.size();
	}
	
	
	

	

	
}

/**
 * The {@code Stack} class simulates a stack data structure, inserting and
 * removing data by the FILO (first-in, last-out) rule. It stores orders with a
 * total amount below 1500 in the stack.
 *
 */
class Stack extends Container {
	
	
	
	private ArrayList<Order> stack;
	
	public Stack(String fileName) throws FileNotFoundException {
		this.stack = new ArrayList<>();
		List<String> datas= IOHandler.readFile(fileName);
		
		
		 
    	 for(String s: datas ) {
			 
    		 String[] details = s.split(",");
    		 
    		 
    		 int orderId = Integer.parseInt(details[0].trim());
    		 String customerName = details[1].trim();
    		 String productName = details[2].trim();
    		 int quantity = Integer.parseInt(details[3].trim());
    		 double unitPrice = Double.parseDouble(details[4].trim());
    		 
    		 Order order =  new Order(orderId, customerName, productName, quantity, unitPrice);
    		 
    		 if(order.getTotalAmount() < 1500) {
    			 stack.add(order);
    		 }
    		 
    		 
    		 
	 }
		 
		
	}

	@Override
	public void add(Object object) {
		
		Order order = (Order) object;
		if(order.getTotalAmount() < 1500) {
			stack.add(order);
		}
		
		
		
	}

	@Override
	public Object remove() {
		if(stack.isEmpty()) {
			return null;
		}
		
		return stack.remove(stack.size()-1);
	}
	
	
	public Object top() {
		return stack.get(stack.size()-1);
	}
	

	@Override
	public int getSize() {
		
		return stack.size();
	}
	
	
	
	
	
	
}

/**
 * The {@code IOHandler} class provides static methods for handling input and
 * output operations with files. It allows reading content from a file and
 * writing content to a file.
 *
 */
class IOHandler {
	
	
	
	
	public static List<String> readFile(String fileName) throws FileNotFoundException {
		Scanner scannerObj;
		try {
			scannerObj = new Scanner(new File(fileName));
			List<String> datas = new ArrayList<>();
		
			while (scannerObj.hasNextLine()) {
				String data = scannerObj.nextLine();
				datas.add(data);
				
			}
			scannerObj.close();
			return datas;
	
		}
		
		
		
		catch(Exception e) {
//			System.out.println("File not found");
//			return null;
			
			throw new FileNotFoundException("sFile not found");
		}
		
			
		
		
	}
	
	public static void writeFile(String fileName, List<String> content)  {
		try {
			FileWriter writer = new FileWriter(new File(fileName));
			
			for(String s: content) {
				writer.write(s + "\n");
			}
			
			writer.close();
			
		}
		
		catch(IOException e) {
			System.out.println("File not found");
		}
		
	}
	
	
	
	
}

/**
 * The {@code Order} class represents an order in the order processing system.
 * It encapsulates information about the order such as order ID, customer name,
 * product name, quantity, and unit price.
 *
 */
class Order {
	
	
	private String customerName;
	private int orderId;
	private String productName;
	private int quantity;
	private double unitPrice;
	
	public Order(int orderId, String customerName, String productName, int quantity, double unitPrice) {
		super();
		this.customerName = customerName;
		this.orderId = orderId;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public double getTotalAmount() {
		
		
		return Math.round(quantity* unitPrice *100.0)/100.0;
		
	}
    
	@Override
	public String toString() {
		return "["+ orderId + customerName + productName + quantity + ((unitPrice *100.0)/100.0) + "]"; 
	}
	
		
	
	
	
	
	
}