package com.project2;

public class Trainer {
	public void trainer(Animal animal) {
		if(animal instanceof Dog) {
			Dog d = (Dog) animal;
			d.bark();
		}else if(animal instanceof Cat) {
			Cat c = (Cat) animal;
			c.bark();
		}
	}
	
	public static void main(String[] args) {
		Trainer t = new Trainer();
		Animal a = new Dog();
		t.trainer(a);
		Animal b = new Cat();
		t.trainer(b);
	}
}
