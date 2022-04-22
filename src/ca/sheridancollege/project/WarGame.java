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
 * The Game of War
 */
public class WarGame extends Game{

 /**
 * Add Players to the game and build the deck
 */
    WarPlayer player1 = new WarPlayer("player1");
    WarPlayer player2 = new WarPlayer("player1");
    GroupOfCards deck = buildDeck();
    GroupOfCards warPile = new GroupOfCards(0);
    
    /**
     * 
     * @param name name of the game
     * @param playerName1 player 1's name
     * @param playerName2 player 2's name
    */
    public WarGame(String name,String playerName1,String playerName2) {
        super(name);
        player1.setName(playerName1);
        player2.setName(playerName2);
    }
    
    
    /**
     * Player 1 & 2 play their cards and compare for winner
     */
    @Override
    public void play() {
        while(player1.hasCards()&&player2.hasCards()){
            testCards(player1.play(),player2.play());
        }
        declareWinner();
    }
    
    /**
    * Compare the cards and declare the winner of the hand
    */ 
    public void testCards(PlayingCard p1card,PlayingCard p2card){
        if(p1card.getValue()>p2card.getValue()){
                System.out.println(player1.getName() + " has won the hand!");
                player1.discard.addCard(p1card);
                player1.discard.addCard(p2card);
            }else if(p1card.getValue()<p2card.getValue()){
                System.out.println(player2.getName() + " has won the hand!");
                player1.discard.addCard(p2card);
                player2.discard.addCard(p1card);
            }else if(p1card.getValue()==p2card.getValue()){
                warPile.addCard(p2card);
                warPile.addCard(p1card);
                war();
            }
    }
    
    /**
     * Player 1 & 2 tied during play and declare war, comparing for winner of warPile
     * Also checks for winner
     */
    public void war(){
        System.out.println("WAR!!!");
    /**
    * Deal out the cards for the war
    */   
        PlayingCard p1Card = new PlayingCard();
        PlayingCard p2Card = new PlayingCard();
        for(int c=0;c<3;c++){
            if(player1.hasCards()) 
            warPile.addCard(player1.play());
            else declareWinner();
        }
        p1Card = warPile.getTopCard();
            
        for(int c=0;c<3;c++){
            if(player2.hasCards()) 
            warPile.addCard(player2.play());
            else declareWinner();
        }
        p2Card = warPile.getTopCard();
        
    /**
    * Check who won the war and reward the player with cards or start another war
    */   
        if(p1Card.value>p2Card.value){
            System.out.println(player1.getName() + " has won the war!");
            while(!warPile.isEmpty()){
                player1.discard.addCard(warPile.getTopCard());
                warPile.removeCard(warPile.getSize()-1);
            }
        }
        else if(p1Card.value<p2Card.value){
            System.out.println(player1.getName() + " has won the war!");
            while(!warPile.isEmpty()){
                player2.discard.addCard(warPile.getTopCard());
                warPile.removeCard(warPile.getSize()-1);
            }
        }
        else if(p1Card.value==p2Card.value)
            war();
     
    }
    
    /**
     * Declare who won the game
     */
    @Override
    public void declareWinner() {
        if(player1.hand.isEmpty())
            System.out.println(player2.getName() + " has won the game!");
        else if(player2.hand.isEmpty())
            System.out.println(player1.getName() + " has won the game!");
    }
    
    /**
     * Shuffle the deck and deal hands to both players
     */
    public void deal(){
        deck.shuffle();
        while(!deck.isEmpty()){
            player1.hand.addCard(deck.getTopCard());
            deck.removeCard(deck.getSize()-1);
            player2.hand.addCard(deck.getTopCard());
            deck.removeCard(deck.getSize()-1);
        }
    }
    
    /**
     * Create deck of cards for War
     */
    public GroupOfCards buildDeck(){
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        GroupOfCards newDeck = new GroupOfCards(0);
        
        for (String suit:suits) 
            for (int i=1;i<14;i++) 
            {
            PlayingCard newCard = new PlayingCard();
                newCard.setSuit(suit);
                newCard.setValue(i);
                newDeck.addCard(newCard);
            }
        return newDeck;
    }
    
    
}
