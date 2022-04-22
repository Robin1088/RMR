/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * 
 * @author Robert Mah
 * @mod Robin Bedminister
 * @mod Mel Emery
 * A bicycle deck of cards
 */
public class PlayingCard extends Card {
    
    int value;
    String suit;
    
    /**
    * Print the suit and value of the card
    */ 
    @Override
    public String toString(){
        String cardValue = new String();
        switch (value) {
            case 1:  cardValue = "Ace" + " of " + suit;
                     break;
            case 11: cardValue = "Jack" + " of " + suit;
                     break;
            case 12: cardValue = "Queen" + " of " + suit;
                     break;
            case 13: cardValue = "King" + " of " + suit;
                     break;
            default: cardValue = value + " of " + suit;
        }
        return cardValue;
    }
    
    /**
    * Set the value of the card
    */ 
    public void setValue(int num){
        value = num;
    }
    
    /**
    * Return the value of the card
    */ 
    public int getValue(){
        return value;
    }
    
    /**
    * Set the suit of the card
    */ 
    public void setSuit(String suitIn){
        suit = suitIn;
    }
    
    /**
    * Return the suit of the card
    */ 
    public String getSuit(){
        return suit;
    }
}
