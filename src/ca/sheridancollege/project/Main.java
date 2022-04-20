/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author rober
 */
public class Main {
    
    public static void main(String[] args){
        String name1;
        String name2;
        
        Scanner read = new Scanner(System.in);
        System.out.print("Please enter name\nPlayer 1: ");
        name1 = read.next();
        System.out.print("Player 2: ");
        name2 = read.next();
       
        WarGame game = new WarGame("War",name1, name2);
        
        game.deal();
        game.play();      
    }
}
