package com.toni.peeper.pattern.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class Carataker {

	private List<ArticleMemento> estados = new ArrayList<ArticleMemento>();
	
	public void addMemento(ArticleMemento memento) {
		estados.add(memento);
	}
	
	public ArticleMemento getmemento(int index) {
		return estados.get(index);
	}
}
