package com.toni.peeper.pattern.behavioral.memento;

public class Article {

	private String autor;
	private String text;
	
	public Article(String autor, String text) {
		this.autor= autor;
		this.text=text;
	}	
	
	public ArticleMemento createMemento() {
		ArticleMemento memento = new ArticleMemento(autor, text);
		return memento;
	}
	
	public void restoreMemento(ArticleMemento memento) {
		this.autor = memento.getAutor();
		this.text = memento.getText();
	}

	public String getAutor() {
		return autor;
	}

	public String getText() {
		return text;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
