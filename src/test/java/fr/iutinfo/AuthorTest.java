package fr.iutinfo;

import org.junit.Test;

public class AuthorTest extends AbstractTest {

	@Test
	public void postFormToAuthorMustRespond201() {
		post("/author", "firstname", "yann", "lastname", "secq").should().respond(201);
	}

	@Test
	public void getAuthor0MustReturnAlan() {
		get("/author/0").should().contain("alan");
	}
	
	@Test 
	public void getAuthorAfterInsertMustReturnGoodAuthor() {
		//Author yann = post("/author", new Author("yann", "secq")).get(Author.class)
		//get("/author/"+yann.getId()).should().contain("yann");
	}
}
