package com.spring.usecase;

import org.springframework.stereotype.Component;

@Component
public class IdHandler {
	private int count;	
	
	public int nextId() {
		return ++count;
	}
}
