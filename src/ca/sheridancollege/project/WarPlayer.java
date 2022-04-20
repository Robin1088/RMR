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

    GroupOfCards hand = new GroupOfCards(52);
    
    public WarPlayer(String name) {
        super(name);
    }
    
    @Override
    public PlayingCard play() {
        PlayingCard card = hand.getTopCard();
        System.out.println(this.getName() + " has played " + card.toString());
        return card;
    }
}
