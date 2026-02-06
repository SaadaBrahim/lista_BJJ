

public class Main {
    

    
    public static void main(String args[]){
        Lista lista = new Lista();
        Tecnica tecnica5 = new Tecnica(5, "DADY", null, null);
        Tecnica tecnica4 = new Tecnica(4, "Sottomissioni", tecnica5, "Sottomissioni");
        Tecnica tecnica3 = new Tecnica(3, "Ribaltamenti", tecnica4, "Ribaltamenti");
        Tecnica tecnica2 = new Tecnica(2, "Posizioni", tecnica3, "Posizioni");
        Tecnica tecnica = new Tecnica(1, "fondamentali", tecnica2, "Fondamentali");

        Nodo nodo1 = new Nodo();
        nodo1.setTecnica(tecnica);
        nodo1.setValore("Fondamentali");

        Nodo nodo2 = new Nodo();
        nodo2.setTecnica(tecnica2);
        nodo2.setValore("Posizioni");

        Nodo nodo3 = new Nodo();
        nodo3.setTecnica(tecnica3);
        nodo3.setValore("Ribaltamenti");

        Nodo nodo4 = new Nodo();
        nodo4.setTecnica(tecnica4);
        nodo4.setValore("Sottomissioni");  

        Nodo nodo5 = new Nodo();
        nodo5.setTecnica(tecnica5);
        nodo5.setValore("DADY");

        System.out.println("Lista iniziale vuota:");
            lista.stampaLista();
        System.out.println("Inserimento in testa:");
            lista.inserimentoInTesta(nodo1);
            lista.stampaLista();
        System.out.println("Inserimento in coda:");
            lista.inserimentoInCoda(nodo5);
            lista.stampaLista();
        System.out.println("Inserimento in mezzo (indice 1):");
            lista.inserimentoInMezzo(1, nodo2);
            lista.stampaLista();

    }
}