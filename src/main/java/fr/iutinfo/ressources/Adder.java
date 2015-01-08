package fr.iutinfo.ressources;

import net.codestory.http.annotations.Get;

public class Adder {

	@Get("/adder/:first/to/:second")
	public int add(int first, int second) {
		return first + second;
	}
	
}
