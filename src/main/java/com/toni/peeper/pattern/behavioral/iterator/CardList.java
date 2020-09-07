package com.toni.peeper.pattern.behavioral.iterator;

public class CardList implements List{

	private Card[] cards;
	
	public CardList(Card[] cards) {
		this.cards = cards;
	}
	
	public Iterator iterator() {
		return new CardIterator(cards);
	}
	
}
