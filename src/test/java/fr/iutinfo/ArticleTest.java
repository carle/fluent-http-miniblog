package fr.iutinfo;

import net.codestory.http.constants.HttpStatus;

import org.junit.Test;

public class ArticleTest extends AbstractTest {
	
	@Test
	public void post_form() {
		// On crée d'abord quelques utilisateurs
		post("/create/author", "firstname", "yann", "lastname", "secq").should().respond(201);
		get("/author/0").should().contain("alan");
		get("/author/1").should().contain("yann");
		
		// on ajoute un article avec un auteur inexistant
		post("/create/article", "authorid", "3", "content", "Hello World !")
			.should().respond(HttpStatus.BAD_REQUEST);
		// finalement, on ajoute un article valide
		post("/create/article", "authorid", "1", "content", "Hello World !")
			.should().respond(201);
		get("/article/2").should().contain("Hello");
	}
}
