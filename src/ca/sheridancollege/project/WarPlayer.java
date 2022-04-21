/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author rober
 * A player of the game War
 */
public class WarPlayer extends Player{

    GroupOfCards hand = new GroupOfCards(0);
    GroupOfCards discard = new GroupOfCards(0);
    
    public WarPlayer(String name) {
        super(name);
    }
    
    @Override
    public PlayingCard play() {
        PlayingCard card = giveTopCard();
        System.out.println(getName() + " has played " + card.toString());
        return card;
    } 
    
    /*
    * Check if the player has cards in their hand
    *If there is none, check the discard pile
    */
    public boolean hasCards() {
        if (hand.isEmpty() && discard.isEmpty()){
            System.out.println(getName() + " has run out of cards");
            return false;
        } else if(hand.isEmpty() && !discard.isEmpty()){
            addDiscard();
            return true;
        } else return true;
        
    }
    
    /*
    *Check if the player has cards in their discard pile
    *If yes, shuffle theminto their hand and shuffle the cards
    */
    public void addDiscard() {
        while(!discard.isEmpty()){
            hand.addCard(discard.getTopCard());
            discard.removeCard(discard.getSize()-1);
        }
        hand.shuffle();
        System.out.println(getName() + " shuffled their discard pile into their hand");
    }
    
    /*
    *Give the top card of the player's hand
    */
    public PlayingCard giveTopCard(){
        PlayingCard top = hand.getTopCard();
        hand.removeCard(hand.getSize()-1);
        return top;
    }
}
