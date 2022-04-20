/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author rober
 * The Game of War
 */
public class WarGame extends Game{

 /**
 * Add Players to the game and build the deck
 */
    WarPlayer player1 = new WarPlayer("player1");
    WarPlayer player2 = new WarPlayer("player1");
    GroupOfCards deck = buildDeck();
    
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
        while(!checkWinner()){
            PlayingCard card1 = player1.play();
            PlayingCard card2 = player2.play();
            if(card1.getValue()>card2.getValue()){
                System.out.println(player1.getName() + " has won the hand!");
                player1.hand.addCard(card1);
                player1.hand.addCard(card2);
            }else if(card1.getValue()<card2.getValue()){
                System.out.println(player2.getName() + " has won the hand!");
                player1.hand.addCard(card2);
                player2.hand.addCard(card1);
            }else if(card1.getValue()==card2.getValue()) war();
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
        GroupOfCards warPile = new GroupOfCards(6);
        PlayingCard p1Card = new PlayingCard();
        PlayingCard p2Card = new PlayingCard();
        for(int c=0;c<3;c++){
            warPile.addCard(player1.play());
            if(checkWinner()) {break;}
        }
        p1Card = warPile.getTopCard();
            
        for(int c=0;c<3;c++){
            warPile.addCard(player2.play());
            if(checkWinner()) {break;}
        }
        p2Card = warPile.getTopCard();
    
    /**
    * Check who won the war and reward the player with cards or start another war
    */     
        if(p1Card.value>p2Card.value){
            System.out.println(player1.getName() + " has won the war!");
            player1.hand.addCard(p1Card);
            player1.hand.addCard(p2Card);
            while(!warPile.isEmpty())
                player1.hand.addCard(warPile.getTopCard());
        }
        else if(p1Card.value<p2Card.value){
            System.out.println(player1.getName() + " has won the war!");
            player1.hand.addCard(p1Card);
            player1.hand.addCard(p2Card);
            while(!warPile.isEmpty())
                player2.hand.addCard(warPile.getTopCard());
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
            player2.hand.addCard(deck.getTopCard());
        }
    }
    
    /**
     * Create deck of cards for War
     */
    public GroupOfCards buildDeck(){
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        GroupOfCards newDeck = new GroupOfCards(52);
        
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
    
    /**
     * Check if there is a winner
     */
    public boolean checkWinner(){
        if(player1.hand.isEmpty()||player2.hand.isEmpty()){
            declareWinner();
            return true;
        }
        else return false;
    }
    
}
