/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * 
 * @author rober
 * A bicycle deck of cards
 */
public class PlayingCard extends Card {
    
    int value;
    String suit;
    
    @Override
    public String toString(){
        String cardValue = value + " of " + suit;
        return cardValue;
    }
    
    public void setValue(int num){
        value = num;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setSuit(String suitIn){
        suit = suitIn;
    }
    
    public String getSuit(){
        return suit;
    }
}
