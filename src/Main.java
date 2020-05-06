import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        int gagne = 0; //variable de test pour couper les boucles si joueur gagne
        Pendu pendu = new Pendu();
        randomWord random = new randomWord();
        random.numberVoyelleConsonne();
        int essai = random.askRounds();

        String[] word = IntStream.range(0, random.getFinalWoldLengh()).mapToObj(i -> "_").toArray(String[]::new);
        String[] containNot = new String[random.getFinalWoldLengh()];

        /*
        Boucle globale pour le nombre d'essais
         */
        label:
        for (int j = 0; j <= essai; j++) {
            String str;
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(System.in));
            //on instancie numberTryPlayer à j
            pendu.setNumberTryPlayer(j);
            //System.out.println("Ne contient pas \n" +Arrays.toString(containNot));
            System.out.println("Essai " + pendu.getNumberTryPlayer(j) + "\nLettre ou mot ? : ");
            str = br.readLine();
            for (int i = 0; i < random.finalWoldLengh; i++) {

                //String.ValueOf (Retourne le String représentant la valeur du Char)
                random.charFinalWord = String.valueOf(random.finalWord.charAt(i));
                // Si la chaîne rentrée est supérieure à 1 caractère on teste l'églité des mots.
                if (str.length() >= 1) {
                    if (str.equals(random.finalWord.toUpperCase()) || str.equals(random.finalWord.toLowerCase())) {
                        System.out.println("Vous avez gagné");
                        gagne = 1;
                        break label;
                    }
                }

            /*
            si la lettre rentrée est égale à la lettre au char d'index i de charfinalWord on incrémente remplace "_" de word par ce caractère.
            On teste sur les majuscules ou minuscules peut importe si l'on rentre majuscules ou minuscules ou le format du dictionnaire.txt
             */
                if (str.equals(random.charFinalWord.toLowerCase()) || str.equals(random.charFinalWord.toUpperCase())) {
                    word[i] = random.charFinalWord;
                }

            }
            System.out.println("On continue ...");
            System.out.println(Arrays.toString(word));
            if (pendu.getNumberTryPlayer(j) == essai && gagne == 0) {
                System.out.println("Le mot à trouvé était: " + random.finalWord);
                pendu.playerIsDead();

            }
        }
    }
}

