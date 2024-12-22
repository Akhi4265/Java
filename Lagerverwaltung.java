package lager;

import java.util.ArrayList;

public class Lagerverwaltung {
    private ArrayList<Artikel> lager;

    public Lagerverwaltung(){
        this.lager = new ArrayList<>();
    }

    public void artikelHinzufügen(String name, int menge, Double preis){
        for(Artikel artikel: lager){
            if(artikel.getName().equals(name)){
                artikel.setMenge(artikel.getMenge()+ menge);
                artikel.setPreis(preis);
                System.out.println("Artikel aktualisiert: " + artikel.toString());
                return;
            }
        }
        Artikel artikel = new Artikel(name, menge, preis);
        lager.add(artikel);
        System.out.println("Artikel hinzugefügt: " + artikel.toString());
    }
    public void artikelEntfernen(String name){
        for(Artikel artikel: lager){
            if(artikel.getName().equals(name)){
                lager.remove(artikel);
                System.out.println("Artikel: " + name + " wurde Entfernt");
                return;
            }
        }
        System.out.println("Artikel: "+name+" exestiert nicht");

    }

    public void bestandAnzeigen(){
        if(lager.isEmpty()){
            System.out.println("Lager ist leer");
        } else {
            System.out.println("Lagerbestand:");
            for(Artikel artikel: lager){
                System.out.println(artikel);
            }
        }

    }

    public void artikelSearch(String name){
        for(Artikel artikel: lager){
            if(artikel.getName().equals(name)){
                System.out.println(artikel.toString());
                return;
            }
        }
        System.out.println("Artikel: " + name + " wurde nicht gefunden.");
    }

    public void gesamtWertBrechnen(){
        double gesamtWert = 0.0;
        for(Artikel artikel: lager){
           gesamtWert += artikel.getMenge() * artikel.getPreis();
        }
        System.out.printf("Gesamtwert des Lagers: %.2f Euro%n", gesamtWert);
    }



    public static void main(String[] args) {
        Lagerverwaltung lagerverwaltung = new Lagerverwaltung();

        // Artikel hinzufügen
        lagerverwaltung.artikelHinzufügen("Apfel", 50, 0.5);
        lagerverwaltung.artikelHinzufügen("Apfel", 1000, 30.9);

        lagerverwaltung.bestandAnzeigen();
        //lagerverwaltung.artikelEntfernen("Apfel");
        //lagerverwaltung.bestandAnzeigen();

        lagerverwaltung.gesamtWertBrechnen();
    }
}
