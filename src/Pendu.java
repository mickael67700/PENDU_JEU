/*
Jeu du pendu basé sur les règles suivantes : https://fr.wikipedia.org/wiki/Le_Pendu_(jeu)
C'est la règle la plus jouée. Dans ce programme, le nombre d'essai correspond aux nombres de traits
plus ou moins nécessaires pour dessiner le gibet.
 */
public class Pendu {
    int numberTryPlayer=0; // compteur du nombres d'essais du joueur

    public Pendu() {
    }

    public int getNumberTryPlayer(int j) {
        return numberTryPlayer;
    }

    public void setNumberTryPlayer(int numberTryPlayer) {
        this.numberTryPlayer = numberTryPlayer;
    }

    public void playerIsDead(){
        System.out.println("--------------\n" +
                "    |        |\n" +
                "    |        |\n" +
                "    |       / \\\n" +
                "    |       \\_/\n" +
                "    |      __|__\n" +
                "    |        |\n" +
                "    |        |\n" +
                "    |       / \\\n" +
                "   /|\\     /   \\\n" +
                "  / | \\\n" +
                " /  |  \\\n" +
                "~~~~~~~~~~~~~~~~~~~~~\n" +
                "~~~~~~~~~~~~~~~~~~~~~\n" +
                "~~~~~~~~~~~~~~~~~~~~~");
    }

}
