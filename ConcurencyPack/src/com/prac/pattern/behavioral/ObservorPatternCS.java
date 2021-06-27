package com.prac.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObservorPatternCS {
	
	public static void main(String[] args) {
    	OrderSubject OrderSubject = new OrderSubject("101");
    	PriceObserver price = new PriceObserver();
    	OrderSubject.attach(price);
    	
    	QuantityObserver quant = new QuantityObserver();
    	OrderSubject.attach(quant);
    	
    	OrderSubject.addItem(50);
    	OrderSubject.addItem(179);
    	
    	System.out.println(OrderSubject);
    }

}

//Abstract observer
interface OrderSubjectObserver {

  void updated(OrderSubject OrderSubject);
}

//Concrete observer
class PriceObserver implements OrderSubjectObserver{

	@Override
	public void updated(OrderSubject OrderSubject) {
		System.out.println("PriceObserver.updated");
		double cost = OrderSubject.getItemCost();
		
		if(cost >= 500) {
			OrderSubject.setDiscount(50);
		} else if(cost >= 200) {
			OrderSubject.setDiscount(10);
		}
	}

	
}

class QuantityObserver implements OrderSubjectObserver {

    @Override
    public void updated(OrderSubject OrderSubject) {
    	System.out.println("QuantityObserver.updated");
        int count = OrderSubject.getCount();
        if(count <= 5) {
            OrderSubject.setShippingCost(10);
        } else {
            OrderSubject.setShippingCost(10 + (count - 5) * 1.5);
        }
    }
}


//A concrete subject 
class OrderSubject {

    private String id;

    private double shippingCost;
    //cost of items
    private double itemCost;

    private double discount;
    //no of items
    private int count;

    private List<OrderSubjectObserver> observers = new ArrayList<>();
    
    public OrderSubject(String id) {
        this.id = id;
    }
    
    public void attach(OrderSubjectObserver observer) {
    	observers.add(observer);
    }

    public void detach(OrderSubjectObserver observer) {
    	observers.remove(observer);
    }
    
    public double getTotal() {
        return itemCost - discount + shippingCost;
    }

    public void addItem(double price) {
        itemCost += price;
        count ++;
        observers.stream().forEach(o-> o.updated(this));
    }

    public int getCount() {
        return count;
    }

    public void setShippingCost(double cost) {
        this.shippingCost = cost;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getItemCost() {
        return itemCost;
    }

    @Override
    public String toString() {

        return "OrderSubject#"+id+"\nItem cost:"+itemCost+"\nNo. of items:"+count
                +"\nShipping cost:"+shippingCost+"\nDiscount:"+discount
                +"\nTotal:"+getTotal();
    }
}
