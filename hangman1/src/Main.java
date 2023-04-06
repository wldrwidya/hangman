import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("|----------");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");

	  System.out.println("Welcome To Hangman Game");
        File dictionary = new File("C:\\Users\\Widya HW\\OneDrive - Universitas Tarumanagara\\Desktop\\hangman\\hangman1\\src\\english3.txt");

        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        while(textScanner.hasNextLine()) {
            words.add(textScanner.nextLine());
        }

        String hidden_text = words.get((int)(Math.random()*words.size()));
        char[] textArray = hidden_text.toCharArray();

        char[] myAnswer = new char[textArray.length];
        for(int i = 0; i < textArray.length; i++) {
            myAnswer[i] = '?';
        }

        boolean finished = false;
        int lives = 6;

        while(finished == false) {
            System.out.println("**");

            String letter = input.next();
            while(letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error Input - Try Again");
                letter = input.next();
            }

            boolean found = false;
            for(int i = 0; i < textArray.length; i++) {
                if(letter.charAt(0) == textArray[i]) {
                    myAnswer[i] = textArray[i];
                    found = true;
                }
            }

            if(!found) {
                lives--;

                System.out.println("Wrong Letter");
            }

            boolean done = true;
            for(int i = 0; i < myAnswer.length; i++) {
                if(myAnswer[i] == '?') {
                    System.out.println(" ");
                    done = false;
                }
                else {
                    System.out.println(" " + myAnswer[i]);
                }
            }

            System.out.println("\n" + "Lives Left: " + lives);
		drawHangman(lives);
		
		if(done) {
		    System.out.println("Congrats You Found the Word");
		    finished = true;
        }
		if(lives <=0) {
		    System.out.println("You Are Dead!");
		    finished = true;
    }
}

}
public static void drawHangman(int l) {
  if(l == 6) {
   System.out.println("|----------");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(l == 5) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(l == 4) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|    |");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(l == 3) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|   -|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(l == 2) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|   -|-");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else if(l == 1) {
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|   -|-");
   System.out.println("|   /");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
  else{
   System.out.println("|----------");
   System.out.println("|    O");
   System.out.println("|   -|-");
   System.out.println("|   /|\\");
   System.out.println("|");
   System.out.println("|");
   System.out.println("|");
  }
 }
}