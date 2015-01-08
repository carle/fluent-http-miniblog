package fr.iutinfo;

import java.util.*;

import fr.iutinfo.ressources.Adder;
import fr.iutinfo.ressources.Article;
import fr.iutinfo.ressources.Author;
import net.codestory.http.WebServer;
import net.codestory.http.filters.Filter;
import net.codestory.http.filters.basic.BasicAuthFilter;

public class BlogServer extends WebServer {
	Map<String, String> users = new HashMap<>();

	public BlogServer() {
		users.put("yann", "secq");
		Filter auth = new BasicAuthFilter("/private", "ap", users);

		configure(routes -> routes
				.filter((uri, context, next) -> {
					System.out.println(uri);
					return next.get();
				})
				.filter(auth)
				// get("/", "Hello World")
				.get("/Test", "Test")
				.get("/OtherTest", "Other Test")
				.get("/hello/:who", (context, name) -> "Hello " + name)
				.get("/add/:first/to/:second",
						(context, first, second) -> Integer.parseInt(first)
								+ Integer.parseInt(second))
				.get("/private/hello",
						context -> "Hello " + context.currentUser().login()
								+ " !")
				.add(Adder.class)
				.add(Author.class)
				.add(Article.class));
	}

	public static void main(String[] args) {
		new BlogServer().start();
	}
}
