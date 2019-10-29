package com.company;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner k = new Scanner(System.in);
	    Random random  = new Random();
	    boolean repeat = true;
	    boolean change;
	    String[] hedges = {"Please tell me more", "Many of my patients tell me the same thing", "It is getting late, maybe we'd better quit"};
	    String[] qualifiers = {"Why do you say that", "You seem to think that", "So, you are concerned that"};
        System.out.println("Good Day. What is your problem? ");
        do {
            change = false;
            System.out.println("Enter a response or Q to quit: ");
            String r = k.nextLine();
            if(r.equalsIgnoreCase("q") || r.equalsIgnoreCase("I am feeling great")){
                repeat = false;
            }
            else{
                String[] array = r.split(" ");
                for(int i = 0; i < array.length; i++){
                    if(array[i].equalsIgnoreCase("I") || array[i].equalsIgnoreCase("me")){
                        array[i] = "you";
                        change = true;
                    }
                    else if(array[i].equalsIgnoreCase("my")){
                        array[i] = "your";
                        change = true;
                    }
                    else if(array[i].equalsIgnoreCase("am")){
                        array[i] = "are";
                        change = true;
                    }
                }
                if(change){
                    int x = random.nextInt(qualifiers.length);
                    System.out.print(qualifiers[x]);
                    for(String s : array){
                        System.out.print(" "+ s);
                    }
                }
                else{
                    int x = random.nextInt(hedges.length);
                    System.out.println(hedges[x]);
                }
            }
            System.out.println();
        } while(repeat);
    }
}
