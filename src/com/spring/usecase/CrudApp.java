package com.spring.usecase;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.sound.midi.Soundbank;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CrudApp {

	public static void main(String[] args) {
		HashMap<Integer, Item> items = new HashMap<>();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		int i=0;
		do {

			System.out.println("-----------------Options--------------");
			System.out.println("New    : 1 ");
			System.out.println("Update : 2");
			System.out.println("Show   : 3");
			System.out.println("Delete : 4");
			System.out.println("Exit   : 5");

			System.out.print("\nEnter Your Choice : ");
			i = scanner.nextInt();

			switch (i) {
			case 1:
				Item item = context.getBean("item", Item.class);
				System.out.print("\nName : ");
				item.setName(scanner.next());
				System.out.print("\nPrice : ");
				item.setPrice(scanner.nextInt());
				System.out.print("\nQuantity : ");
				item.setQuantity(scanner.nextInt());

				items.put(item.getId(), item);
				System.out.println("Added Successfully");
				break;

			case 2:
				System.out.println("Do you know the Item id want to update?(Y/N) :");
				if (scanner.next().equalsIgnoreCase("y")) {
					System.out.println("Enter the Item id:");
					Item item1 = items.get(scanner.nextInt());
					if (item1 != null) {
						System.out.println(item1);
						System.out.println("Choose a Field want to update");
						System.out.println("1 for Name");
						System.out.println("2 for Price");
						System.out.println("3 for Quantity");
						int field = scanner.nextInt();

						if (field == 1) {
							System.out.print("\nNew Name : ");
							item1.setName(scanner.next());
							System.out.println("Update Successfully");
						} else if (field == 2) {
							System.out.print("\nNew Price : ");
							item1.setPrice(scanner.nextInt());
							System.out.println("Update Successfully");
						} else if (field == 3) {
							System.out.print("\nNew Quantity : ");
							item1.setQuantity(scanner.nextInt());
							System.out.println("Update Successfully");
						}

					}
				}
				break;

			case 3:
				Set<Integer> keySet = items.keySet();
				for (Integer key : keySet) {
					System.out.println(items.get(key));
				}
				break;
				
			case 4:
				System.out.println("Do you know the Item id want to update?(Y/N) :");
				if (scanner.next().equalsIgnoreCase("y")) {
					System.out.println("Enter the Item id:");
					items.remove(scanner.nextInt());
					System.out.println("Deleted Successfully");
				}
				break;
			default:
				break;
			}

		} while (i != 5);

		
	}
}
