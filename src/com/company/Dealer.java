package com.company;

/**
 * Created by falyanguzov on 14.11.2016.
 */
public class Dealer extends Computer {
    Deck deck = new Deck();

    public Dealer() {
        super(new DealerIntellect());
    }

    public void deal(Player player) {
        Card current = deck.pop();
        player.take(current);
    }
}
