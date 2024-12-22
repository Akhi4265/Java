public class Kino {
    private boolean saal [][]; 
    private int reihen;
    private int plätzeProReihe;
    private int gebuchtPlätze;
    void saalAnlegen(int reihen, int plätzeProReihe){
        this.reihen = reihen;
        this.plätzeProReihe = plätzeProReihe;

        saal = new boolean [reihen][plätzeProReihe];
        for(int i = 0; i < reihen; i++){
            for(int j = 0; j < plätzeProReihe;j++){
                saal[i][j] = true;
            }
        }
        System.out.println("Saal mit "+ reihen+ " Reihen und "+ plätzeProReihe +" Plätze pro Reihe.");
    }

    public boolean sitzplatzBuchen(int reihe, int platz){
        if(saal[reihe][platz]){
            saal[reihe][platz] = false;
            gebuchtPlätze ++;
            System.out.println("platz wurde gebucht in Reihe - Platz " + reihe + " - " + platz);
            return true;
        }
        System.out.println("Platz ist schon bestzt Reihe - Platz: " + reihe + " - " + platz);
        return false;
    }
    public boolean sitzplatzStonieren(int reihe, int platz){
        if(!saal[reihe][platz]){
            saal[reihe][platz] = true;
            gebuchtPlätze --;
            System.out.println("Platz wurde Stoniert");
            return true;
        }
        return false;

    }
    public void freiePlätzeAnzeigen(){
        System.out.println();
        for(int i = 0; i < reihen; i++){
            System.out.print("Reihe: " + i +" [");
            for(int j = 0; j < plätzeProReihe;j++){
                if(saal[i][j]){
                    System.out.print(" "+ j+" ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
    public void einnahmenberechnen(double ticktPreis){
        double einnahmen = gebuchtPlätze * ticktPreis;
        System.out.println("Die einnahmen betragen: " + einnahmen);
    }


    public static void main(String[] args) {
        Kino saal = new Kino();
        saal.saalAnlegen(10, 30);
        saal.sitzplatzBuchen(0, 0);
        saal.sitzplatzStonieren(0, 0);
        saal.freiePlätzeAnzeigen();
        saal.einnahmenberechnen(12.50);
    }
}
