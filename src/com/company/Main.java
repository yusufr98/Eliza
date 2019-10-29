package com.company;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static Random random  = new Random();
    public static void main(String[] args) {
	    Scanner k = new Scanner(System.in);
	    boolean repeat = true;
	    boolean change;
	    boolean pig = false;
	    String[] hedges = {"Please tell me more", "Many of my patients tell me the same thing", "It is getting late, maybe we'd better quit"};
	    String[] qualifiers = {"Why do you say that", "You seem to think that", "So you are concerned that"};
        System.out.println("Good Day. What is your problem? ");
        do {
            change = false;
            System.out.println("Enter a response or Q to quit: ");
            String r = k.nextLine();
            if(r.equalsIgnoreCase("q") || r.equalsIgnoreCase("I am feeling great")){
                repeat = false;
            }
            else if(r.equalsIgnoreCase("pig")){
                pig = true;
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
                    if(pig){
                        String[] temp = qualifiers[x].split(" ");
                        temp = pigLatin(temp);
                        array = pigLatin(array);
                        for(String s : temp) {
                            System.out.print(s + " ");
                        }
                        for(String s : array){
                            System.out.print(s + " ");
                        }
                    }
                    else {
                        System.out.print(qualifiers[x]);
                        for (String s : array) {
                            System.out.print(" " + s);
                        }
                    }
                }
                else{
                    int x = random.nextInt(hedges.length);
                    if(pig) {
                        String[] s = hedges[x].split(" ");
                        s = pigLatin(s);
                        for(String str : s){
                            System.out.print(str + " ");
                        }
                    }
                    else{
                        System.out.println(hedges[x]);
                    }
                }
            }
            System.out.println();
        } while(repeat);
    }
    public static String[] pigLatin(String[] s){
        String[] p = new String[s.length];
        for(int i = 0; i < s.length; i++){
            if(s[i].substring(0,1).equalsIgnoreCase("a")||s[i].substring(0,1).equalsIgnoreCase("e")||s[i].substring(0,1).equalsIgnoreCase("i")||s[i].substring(0,1).equalsIgnoreCase("o")||s[i].substring(0,1).equalsIgnoreCase("u")){
                boolean r = random.nextBoolean();
                if(r) {
                    p[i] = s[i].concat("way");
                }
                else{
                    p[i] = s[i].concat("tay");
                }
            }
            else{
                p[i] = (s[i].substring(1) + s[i].substring(0,1) + "ay");
            }
        }
        return p;
    }
}
