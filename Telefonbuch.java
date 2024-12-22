import java.util.ArrayList;

public class Telefonbuch {

    private ArrayList<Kontakt> buch;

    public Telefonbuch(){
        this.buch = new ArrayList<>();
    }


    public class Kontakt{
        private String name;
        private int nummer;

        public Kontakt(String name, int nummer){
            this.name = name;
            this.nummer = nummer;
        }

        public String getName(){
            return name;
        }
        public int getNummer(){
            return nummer;
        }

        public void setNummer(int nummer){
            this.nummer = nummer;
        }
    }

    public void addKontakt(String name, int nummer){

        for(Kontakt k: buch){
            if(k.getName().equals(name)){
                System.out.println("Kontakt bereits vorhanden");
                return;
            }
        }
        buch.add(new Kontakt(name, nummer));
        System.out.println("Kontakt hinzugefügt");
    }

    public void entferneKontakt(String name){
        for(Kontakt k: buch){
            if(k.getName().equals(name)){
                buch.remove(k);
                System.out.println("Kontak entfernt");
                return;
            }
        }
        System.out.println("Fehler: Kontakt nicht gefunden.");
    }


    public void sucheKontakt(String name){
        for(Kontakt k: buch){
            if(k.getName().equals(name)){
                System.out.println("Name: "+k.getName() + " Nummer: " + k.getNummer());
                return;
            }
        }
        System.out.println("Kontakt nicht gefunden");
    }

    public void printBuch(){
        if(buch.isEmpty()){
            System.out.println("Keine Kontakte");
            return;
        }
        for(Kontakt k: buch){
            System.out.println(k.getName()+": "+k.getNummer());
        }
    }




    public static void main(String[] args) {
        Telefonbuch buch = new Telefonbuch();

        buch.addKontakt("Erik", 123456789);
        buch.printBuch();
        buch.entferneKontakt("Erik");
        buch.printBuch();
    }
}