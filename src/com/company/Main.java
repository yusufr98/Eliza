package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner k = new Scanner(System.in);
	    boolean repeat = true;
        System.out.println("Good Day. What is your problem? ");
        do {
            System.out.println("Enter a response or Q to quit: ");
            String r = k.nextLine();
            if(r.equalsIgnoreCase("q") || r.equalsIgnoreCase("I am feeling great")){
                repeat = false;
            }
            else{
                String[] array = r.split(" ");
                for(int i = 0; i < array.length; i++){
                    if(array[i].equalsIgnoreCase("I") || array[i].equalsIgnoreCase("me")){
                        array[i] = "You";
                    }
                    else if(array[i].equalsIgnoreCase("my")){
                        array[i] = "Your";
                    }
                    else if(array[i].equalsIgnoreCase("am")){
                        array[i] = "are";
                    }
                }
                for(String s : array){
                    System.out.print(s + " ");
                }
            }
        } while(repeat);
    }
}
