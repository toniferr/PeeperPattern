package com.toni.peeper.pattern.behavioral.iterator;

public class CardIterator implements Iterator {

	private Card[] cards;
	private int position;
	
	public CardIterator(Card[] cards) {
		this.cards = cards;
		position = 0;
	}
	
	public boolean hasNext() {
		if (position >= cards.length) {
			return false;
		} 
		return true;
	}

	public Object next() {
		return cards[position++];
	}

	public Object currentItem() {
		return cards[position];
	}

}
