import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }

    public String pigLatin(String input) {
        if (!checkForVowels(input)) {
            input += "ay";
        } else if (checkForFirstVowel(input)) {
            input += "way";
        } else if (checkForQU(input)) {
            input = appendQU(input);
        } else if (checkForVowels(input) && !checkForFirstVowel(input)) {
            input = appendConsonantsAy(input);
        }

        return input;
    }

    public static boolean checkForVowels(String input) {
        String vowels = "aeiou";

        for (int i = 0; i < input.length(); i++) {
            if (vowels.indexOf(input.substring(i, i + 1)) != -1) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkForFirstVowel(String input) {
        String vowels = "aeiou";

        if (vowels.indexOf(input.substring(0, 1)) != -1) {
            return true;
        }

        return false;
    }

    public static boolean checkForQU(String input) {
        return input.substring(0, 2).equals("qu")
            || input.substring(0, 2).equals("Qu")
            || input.substring(0, 2).equals("qU")
            || input.substring(0, 2).equals("QU");
    }

    public static String appendQU(String input) {
        return input.substring(2, input.length()) + input.substring(0, 2) + "ay";
    }

    public static String appendConsonantsAy(String input) {
        String consonants = "";

        for (int i = 0; i < input.length(); i++) {
            if (!checkForVowels(input.substring(i, i + 1))) {
                consonants += input.substring(i, i + 1);
            } else {
                break;
            }
        }

        return input.substring(consonants.length()) + consonants + "ay";
    }


}//end PigLatin class
