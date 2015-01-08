package fr.iutinfo.ressources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Post;
import net.codestory.http.payload.Payload;

public class Article {
	
	protected static Map<Integer,Article> articles = new HashMap<>();
	
	protected Author       author;
	protected String       content;
	protected long         timestamp;
	protected final  int   id;
	protected static int   cpt = 0;
	protected List<String> tags;
	
	public Article(Author author, String content) {
		System.err.println("Trying to create article - cpt = "+cpt);
		this.author    = author;
		this.content   = content;
		this.timestamp = System.currentTimeMillis();
		this.id        = ++cpt;
	}
	
	public static Map<Integer,Article> getArticles() {
		return articles;
	}
	
	public boolean addTag(String tag) {
		if (!tags.contains(tag)) {
			tags.add(tag);
			return true;
		}
		return false;
	}
	
	public boolean removeTag(String tag) {
		if (tags.contains(tag)) {
			tags.remove(tag);
			return true;
		}
		return false;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public String getContent() {
		return content;
	}
	
	public long getTimeStamp() {
		return timestamp;
	}
	
	public String toString() {
		return content+" by "+(author);
	}
	
	@Get("/article/:id")
	public Payload getArticle(int id) {
		System.out.print("Searching article with id "+id+" ...");
		if (!articles.containsKey(id)) {
			System.out.print("not found !");
			return new Payload(404);
		}
		return new Payload(articles.get(id));
	}
	
	@Post("/create/article")
	public Payload createArticle(String params) {
		String authorid = params.substring(params.indexOf('=')+1, params.indexOf('&'));
		Author author = Author.getAuthors().get(new Integer(authorid));
		if (author == null) {
			return Payload.badRequest();
		}
		String content  = params.substring(params.lastIndexOf('=')+1, params.length());
		Article article = new Article(author, content);
		System.out.println("Creating new article ("+article.id+") with "+author+" and content "+content);	
		articles.put(article.id, article);
		return Payload.created();
	}
	
}
