package fr.iutinfo.ressources;

import java.util.HashMap;
import java.util.Map;

import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Post;
import net.codestory.http.payload.Payload;

public class Author {
	private static int cpt = 0;
	protected static Map<Integer, Author> authors = new HashMap<>();
	
	static {
		authors.put(0, new Author("alan", "turing"));
	}
	
	protected String firstname;
	protected String lastname;

    public Author() {
    	// Pour instanciation automatique par le framework pour créer
    	// automatiquement des ressources de type Author
    }
	
    // Pour créer manuellement un auteur, cf. bloc static ci-dessus
    public Author(String firstname, String lastname) {
    	this.firstname = firstname; 
    	this.lastname = lastname;
	}
    
    public static Map<Integer, Author> getAuthors() {
    	return authors;
    }
    
    public String getFirstname() {
    	return firstname;
    }
    public void setFirstname(String firstname) {
    	this.firstname = firstname;
    }
    public String getLastname() {
    	return firstname;
    }
    public void setLastname(String lastname) {
    	this.lastname = lastname;
    }
    
    @Get("/author?id=:id") // pour gérer les get générer par un formulaire ...
	@Get("/author/:id")
	public String getAuthor(int id) {
		System.out.println("Searching author with id "+id+" within "+authors);
		if (authors.containsKey(id)) {
			return authors.get(id).toString();
		}
		return "Unknown author with id = "+id;
	}

	// Création d'un nouvelle ressource de type Author automatiquement par 
	// utilisation automatique des setXXX d'Author
	@Post("/create/author")
	public Payload create(Author author) {
		System.out.println("Creating new author => "+author);		
		authors.put(++cpt, author);
		return Payload.created();
	}
	
	// Création manuelle d'une nouvelle ressource du type Author
	// TODO: on doit pouvoir accéder au contexte plus facilement que via 
	// la chaîne 'params' ...
	//@Post("/create/author")
	//public Payload createAuthor(String params) {
	    //String firstname = params.substring(params.indexOf('=')+1, params.indexOf('&'));
		//String lastname  = params.substring(params.lastIndexOf('=')+1, params.length());
		//Author author = new Author(firstname, lastname);
		//System.out.println("Creating new author => "+author);		
		//authors.put(++cpt, author);
		//return Payload.created();
	//}
	
	public String toString() {
		return firstname+ ". "+lastname;
	}
	
}
