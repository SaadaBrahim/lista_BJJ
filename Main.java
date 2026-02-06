

public class Main {
    

    
    public static void main(String args[]){
        Lista lista = new Lista();
        Tecnica tecnica5 = new Tecnica(5, "DADY", null, null);
        Tecnica tecnica4 = new Tecnica(4, "Sottomissioni", tecnica5, "Sottomissioni");
        Tecnica tecnica3 = new Tecnica(3, "Ribaltamenti", tecnica4, "Ribaltamenti");
        Tecnica tecnica2 = new Tecnica(2, "Posizioni", tecnica3, "Posizioni");
        Tecnica tecnica = new Tecnica(1, "fondamentali", tecnica2, "Fondamentali");

    }
}