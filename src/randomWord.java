
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
La classe randomWord génère le mot aléatoire choisi dans le dictionnaire pour le jeu.
 */
public class randomWord {
    //1918 est la longueur du dictionnaire à changer suivant le dictionnaire ou faire un i/o pour compter le nombre de lignes
    int nbLigne = (int) (Math.random() * 1918);//génere correctement le nombre aléatoire de la ligne à choisir dans dictionnaire.txt
    File file = new File("dictionnaire.txt"); //défini le dictionnaire utilisé
    String line = new String();
    String[] tableau = new String[nbLigne]; // Tableau ou sont enregistré les mots du dictionnaire de 1 à 1 nombre aléatoire
    int choix = (int) (Math.random() * tableau.length); // nombre aléatoire pour choisir dans le tableau.
    String finalWord;
    int finalWoldLengh; // Longueur du mot à trouver
    int roundsMax; // Nombre max d'essai que le joueur à pour trouver le mot
    String wordDisplay; //Variable pour afficher lettre ou _ en comparaison avec finalWorld
    String charFinalWord = new String();

    /*
    Ghetters
     */
    public String getFinalWord() {
        return finalWord;
    }

    public String[] getTableau() {
        return tableau;
    }

    public String getLine() {
        return line;
    }

    public int getRoundsMax() {
        return roundsMax;
    }

    public int getFinalWoldLengh() {
        return finalWoldLengh;
    }

    public String getWordDisplay() {

        return wordDisplay;
    }

    public randomWord() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne = null;
            int i;
            for (i = 0; i < nbLigne; i++) {
                line = br.readLine();
                //System.out.println(line);
                tableau[i] = line;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finalWord = tableau[choix];
        finalWoldLengh = finalWord.length();
    }


    /*
   Méthode pour demander au jouer le nombre d'essais maximum pour la partie.
    */
    public int askRounds(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre d'essai maximum : ");
        int roundsMax = sc.nextInt();
        return roundsMax;
    }
    /*
    Méthode pour afficher la longueur du mot ainsi que le nombre de voyelles et consonnes.
     */
    public void numberVoyelleConsonne() {

        int nbrvoyel = 0, nbrconsonne = 0;
        char ch;
        for (int i = 0; i < finalWoldLengh; i++) {
            ch = finalWord.charAt(i);
            if (ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {
                nbrvoyel++;
            } else
                nbrconsonne++;
        }
        // Décommenter la ligne suivante pour afficher le mot à trouver pour phase de dévelloppement
        // System.out.println("La chaîne testée est: " + finalWord);
        System.out.println("Le mot à trouver contient "+finalWoldLengh+ " lettres dont :");
        System.out.println(nbrvoyel + " Voyelles");
        System.out.println(nbrconsonne + " Consonnes");
    }
}
