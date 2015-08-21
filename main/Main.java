package main;

public class Main {

    public static void main(String[] args) {
        String letter = "o";
        String s = "hello"; // These two String objects
        String t = "hell" + letter; // contain exactly the same text.
        if (s.equals(t)) {
            System.out.println("equal");
        }
        
       
    }
}
