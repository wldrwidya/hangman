import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File dictionary = new File("/Users/Widya HW/OneDrive - Universitas Tarumanagara/Documents");

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
            System.out.println("**********");

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
                    System.out.println(" _");
                    done = false;
                }
                else {
                    System.out.println(" " + myAnswer[i]);
                }
            }

            System.out.println("\n" + "Lives Left: " + lives);
        }
    }
}
