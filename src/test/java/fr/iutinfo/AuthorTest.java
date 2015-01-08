package fr.iutinfo;

import org.junit.Test;

public class AuthorTest extends AbstractTest {

	@Test
	public void post_form() {
		/*configure(routes -> routes.post("/create/author", context -> new Payload(
				"text/plain", context.get("first") + " " + context.get("last"),
				201)));*/

		post("/create/author", "firstname", "yann", "lastname", "secq").should().respond(201);
		get("/author/0").should().contain("alan");
		get("/author/1").should().contain("yann");
	}
}
