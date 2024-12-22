package lager;

public class Artikel {
    private String name;
    private int menge;
    private Double preis;

    public Artikel(String name, int menge, Double preis){
        setName(name);
        setMenge(menge);
        setPreis(preis);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Menge: " + menge + " Preis: " + preis + " Euro";
    }
    
    // setter & getter

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name darf nicht leer sein");
        }
    }
    
    public int getMenge(){
        return menge;
    }
    
    public void setMenge(int menge){
        if(menge >= 0){
            this.menge = menge;
        } else {
            throw new IllegalArgumentException("Menge muss Positiv sein");
        }
    }

    public Double getPreis(){
        return preis;
    }

    public void setPreis(Double preis){
        if(preis >= 0.0){
            this.preis = preis;
        } else {
            throw new IllegalArgumentException("Preis muss positiv sein!");
        }
    }
    
    
    public static void main(String[] args) {
       
            Artikel artikel1 = new Artikel("Fisch", 100, 5.70);
            Artikel artikel2 = new Artikel("Käse", 0, 5.0);
            
            System.out.println(artikel1);
            System.out.println(artikel2);
        
    }
}
