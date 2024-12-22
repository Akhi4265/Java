import java.util.Scanner;

public class TikTakTo {
    String [][] liste = new String [3][3];
    String [][] zahlenAnzeige = new String [3][3];
    // Inizieliesieren
    public void initTikTakTo(){
        int feld= 0;
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                liste[i][j] = "-";
                zahlenAnzeige[i][j] = String.valueOf(feld);
                feld++;
            }
        }
    }

    // print Feld
    public void printTikTakTo(String listenArt[][]){
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                System.out.print(listenArt[i][j] + " ");
            }
            System.out.println();
        }
    }
    // Insert mit Wahrheitswert
    public boolean insertMove(String player,int feld){
        if(feld<0 || feld>8){
            System.out.println("Ungültige Eingabe");
            return false;
        }
        int i = feld / 3;
        int j = feld % 3;
        if (!liste[i][j].equals("-")) {
            System.out.println("Das Feld ist bereits belegt! Wähle eine andere Zahl");
            return false;
        }
        liste[i][j] = player;
        zahlenAnzeige[i][j] = player;
        return true;
    }

    public int gameOver(String currPlayer,int feld){
        
        int i = feld / 3;
        int j = feld % 3;
        // 0 => unentschieden
        // 1 => currPlayer gewonnen
        // 2 => spiel geht weiter
        // Horizontal
        if (liste[i][0].equals(currPlayer) &&
            liste[i][1].equals(currPlayer) &&
            liste[i][2].equals(currPlayer)) {
            return 1;
            }
        // vertikal
        if (liste[0][j].equals(currPlayer) &&
            liste[1][j].equals(currPlayer) &&
            liste[2][j].equals(currPlayer)) {
            return 1;
        }
        //diagonal links oben nach rechts unten
        if (liste[0][0].equals(currPlayer)&&
            liste[1][1].equals(currPlayer)&&
            liste[2][2].equals(currPlayer)) {
            return 1;
        }
        //diagonal rechts oben nach links unten
        if(liste[0][2].equals(currPlayer)&&
            liste[1][1].equals(currPlayer)&&
            liste[2][0].equals(currPlayer)) {
            return 1;
        }

        for(i = 0; i < 3; i++){
            for(j = 0; j < 3; j++){
                if(liste[i][j].equals("-")){
                    return 2; // geht weiter
                }
            }
        }

        return 0; // Unenschieden 

    }


    public static void main(String[] args) {
        TikTakTo spiel = new TikTakTo();
        spiel.initTikTakTo();

        String player1 = "X";
        String player2 = "O";

        Scanner scanner = new Scanner(System.in);
        int status = 2;

        String currPlayer = player2;
        spiel.printTikTakTo(spiel.zahlenAnzeige);
        while (status == 2) {

            if (currPlayer.equals(player2)) {
                currPlayer = player1;
            } else{
                currPlayer = player2;
            }
            boolean falseMove = true;
            while (falseMove) {
                int feld = scanner.nextInt();
                if(spiel.insertMove(currPlayer, feld)){
                    spiel.printTikTakTo(spiel.liste);
                    falseMove = false;
                    status = spiel.gameOver(currPlayer,feld);
                }

                
            }
        }
        scanner.close();
        if (status == 1) {
            System.out.println("Spieler: " +  currPlayer + " hat Gewonnen");
        }else{
            System.out.println("Unentschieden");
        }

    }
}
