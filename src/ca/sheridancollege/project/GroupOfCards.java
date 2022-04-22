/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @mod Robert Mah
 * @mod Robin Bedminister
 * @mod Mel Emery
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    /**
    * Shuffle the group of cards in random order
    */ 
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Add card to group
     * @param newCard
     */
    public void addCard(PlayingCard newCard){
        setSize(getSize()+1);
        cards.add(newCard);
    }
    

    /**
     * Return the top card from group
     */
    public PlayingCard getTopCard(){
        PlayingCard top = cards.get(cards.size()-1);
        return top;
    }
    
    /**
    * Check if the group of cards is empty
    */ 
    public boolean isEmpty(){
        if (cards.isEmpty())
            return true;
        else return false;
    }
    
    /**
    * Remove card from group
    */ 
    public void removeCard(int i){
        cards.remove(i);
        setSize(getSize()-1);
    }

}//end class
