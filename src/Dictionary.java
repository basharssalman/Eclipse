import java.io.*;
import java.util.*;
import javax.swing.*;

public class Dictionary {
    public static void main(String args []){
        try {
            Scanner filein = new Scanner(new File("d:/words.txt"));
            HashSet<String> hash = new HashSet();
            while (filein.hasNext()){
                String tk = filein.next();
                hash.add(tk.toLowerCase());
            }
        Scanner userFile = new Scanner(getInputFileNameFromUser());
            userFile.useDelimiter("[^a-zA-Z]+");

         while (userFile.hasNext()){
             String String1 = userFile.next();
                String String2 = String1.toLowerCase();
                if(!hash.contains(String2)){
         System.out.println(String2 + ":" + corrections(String2, hash));
                }
         }
        }
        catch(IOException e){
            System.out.println("Words.txt not found.");
        }
    }
    static TreeSet corrections(String badWord, HashSet dictionary){
        TreeSet<String> tree = new TreeSet<String>();
        for (int i=0; i<badWord.length(); i++){
            String s = badWord.substring(0,i) + badWord.substring(i+1);
            if(dictionary.contains(s)){
                tree.add(s);
            }
        }
    for (int i=0; i<badWord.length(); i++){
        for (char ch = 'a'; ch <= 'z'; ch++) {
            String s = badWord.substring(0,i) + ch + badWord.substring(i+1);
            if(dictionary.contains(s)){
                tree.add(s);
            }
    }

    }
        for (int i=0; i<=badWord.length(); i++){
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String s = badWord.substring(0,i) + ch + badWord.substring(i);
                if(dictionary.contains(s)){
                   tree.add(s);
                }
            }
        }
        for(int i=0; i< badWord.length()-1; i++){
            String s = badWord.substring(0,i)+ badWord.substring(i+1, i+2) + badWord.substring(i,i+1)
                    + badWord.substring(i+2);
            if(dictionary.contains(s)){
                tree.add(s);
            }
        }
        for (int i=1; i<badWord.length(); i++){
            String stringInput = badWord.substring(0,i) + " " + badWord.substring(i);
            String tempString = "";
                StringTokenizer tempWords = new StringTokenizer(stringInput);

            while(tempWords.hasMoreTokens()){
                String stringWord1 = tempWords.nextToken();
                String stringWord2 = tempWords.nextToken();
                if(dictionary.contains(stringWord1) && dictionary.contains(stringWord2)){
                    tempString = stringWord1 + " " + stringWord2;
                }
                else
                break;
                tree.add(tempString);
            }
        }
        if(tree.isEmpty()){
            tree.add("no Suggestions");
        }
        return tree;
        }

        static File getInputFileNameFromUser(){
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select File For Input");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
            return null;
        else
            return fileDialog.getSelectedFile();

    }
}