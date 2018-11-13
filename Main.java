import jdk.swing.interop.SwingInterOpUtils;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //take in string to be encrypted
        Scanner input1 = new Scanner(System.in);
        System.out.println("What is the text to be encrypted? ");
        String stringToEncrypt = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("What is the shift value? ");
        int shiftValue = input2.nextInt();

        Scanner input3 = new Scanner(System.in);
        System.out.println("What is the code group size? ");
        int codeGroupSize = input3.nextInt();

        encryptString(stringToEncrypt, shiftValue, codeGroupSize);
    }

    public static String normalizeText(String text){
        //remove all spaces from the text
        String normalizedText;
        normalizedText = text.replaceAll("[^A-Za-z]","").toUpperCase();
        //return the result
        System.out.println("normalizedText = " + normalizedText);
        return normalizedText;
    }

    public static String obify(String normalizedText){
        //this will take in the normalized text and insert a capital O and capital B in front of every vowel including y
        //and return the obified text
        String obifiedText = "";

        for (int i = 0; i < normalizedText.length(); i++) {
            String c = normalizedText.substring(i,i+1);
                if ((c.equals("A")||c.equals("E")||c.equals("I")||c.equals("O")||c.equals("U")||c.equals("Y"))){
                    obifiedText = obifiedText + "OB" + c;
                } else {
                    obifiedText = obifiedText + c;
                }
        }
        System.out.println("obifiedText = " + obifiedText);
        return obifiedText;
    }

    public static String ceaserify(String stringToEncrypt, int shiftValue){
        //shiftAlphabet returns a string of the entire alphabet shifted to the value, ex: 2 = "CDEFGHIJKLMNOPQRSTUVWXYZAB"
        String shiftedAlphabet = shiftAlphabet(shiftValue);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ceaserifiedText = "";

        for (int i = 0; i < stringToEncrypt.length(); i++) {
            String c = stringToEncrypt.substring(i,i+1);
            ceaserifiedText = ceaserifiedText + shiftedAlphabet.substring(alphabet.indexOf(c), (alphabet.indexOf(c) + 1));
        }
        System.out.println("ceaserifiedText = " + ceaserifiedText);
        return ceaserifiedText;
    }

    //call the shiftAlphabet method inside the ceaserify method
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String groupify(String stringToGroup, int lettersPerGroup){

        //get length of string to break into groups
        int len = stringToGroup.length();
        System.out.println("len = " + len);

        //get number of groups of text
        int numOfGroups = (int) Math.ceil((double)len/lettersPerGroup);

        int xPadding;

        if ((len % lettersPerGroup) == 0) {
            xPadding = 0;

        } else {
            xPadding = lettersPerGroup - (len % lettersPerGroup);
        }

        if(len % numOfGroups > 0) {
            numOfGroups += 1;
        }

        int spaces = numOfGroups -1;

        int lengthWithSpaces = len + spaces;

        //int lengthWithPadding = len + xPadding;

        //int finalLengthSpacesAndPadding = lengthWithPadding + spaces;

        //int index = lengthWithPadding / numOfGroups;

        String groupifiedText = stringToGroup;

        //FOR LOOP TO ADD IN x'S TO STRING FIRST
        for (int i = 1; i <= xPadding; i++) {
            groupifiedText = groupifiedText + "x";
        }

        for (int i = 0; i <= lengthWithSpaces; i++) {

            int x = i;

            if (i < lettersPerGroup) {
                System.out.println(i);
                continue;

            } else if (i == lettersPerGroup) {
                groupifiedText = groupifiedText.substring(0, lettersPerGroup) + " " + groupifiedText.substring(lettersPerGroup);
                System.out.println(i + groupifiedText);

            } else {
                String y;
                y = groupifiedText.substring(lettersPerGroup + x);
                groupifiedText = groupifiedText.substring(0, lettersPerGroup + x) + " " + y;
                i += lettersPerGroup;
                System.out.println(i + groupifiedText);
            }

        }
        System.out.println("groupifiedText = " + groupifiedText);
        return groupifiedText;
    }

    public static String encryptString(String stringToEncrypt, int shiftValue, int codeGroupSize){
        String finalEncyptedString;
        String normalizedText = normalizeText(stringToEncrypt);
        String obifiedText = obify(normalizedText);
        String ceaserifiedText = ceaserify(obifiedText, shiftValue);
        finalEncyptedString = groupify(ceaserifiedText, codeGroupSize);

        //take trailing whitespace off of string
        finalEncyptedString = finalEncyptedString.trim();

        System.out.println("finalEncryptedString = " + finalEncyptedString);
        return finalEncyptedString;
    }
}
