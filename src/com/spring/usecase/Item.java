package com.spring.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Item {
	private int id;
	private String name;
	private int price;
	private int quantity;
	
	private IdHandler handler;
	
	@Autowired
	public Item(IdHandler handler) {
		this.handler = handler;
		id = handler.nextId();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return id+" : "+name+" : Rs. "+price+" : "+quantity;
	}

}
