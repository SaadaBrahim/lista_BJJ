import java.util.Date;

public class Main {
    

    
    public static void main(String args[]){
        Lista lista = new Lista();
        Tecnica tecnica = new Tecnica(1,"fondamentali" , tecnica2);
        Tecnica tecnica2 = new Tecnica(2,"Posizioni", tecnica3);
        Tecnica tecnica3 = new Tecnica(3, "Ribaltamenti", tecnica4);
        Tecnica tecnica4 = new Tecnica(4, "Sottomissioni", tecnica5);
        Tecnica tecnica5 = new Tecnica(5, "DADY", null);


        
        // inserimento in coda
        lista.inserimentoInCoda("A", pc1 );
        lista.inserimentoInCoda("B", pc2);
        lista.inserimentoInCoda("C", pc3);

        System.out.print("inserimento in coda: ");
        Lista.stampaLista(lista);
        
        // inserimento in testa
        lista.inserimentoInTesta("Z", pc4);
        System.out.print("inserimento in testa: ");
        Lista.stampaLista(lista);
        
        // inserimento in mezzo
        lista.inserimentoInMezzo(2, "X", pc5);
        System.out.print("inserimento in mezzo: ");
        Lista.stampaLista(lista);

                lista.aggiungiInOrdineAlfabetico("M",pc6);
        System.out.print("aggiunta in ordine alfabetico M: ");
        Lista.stampaLista(lista);
        
        lista.aggiungiInOrdineAlfabetico("D", pc7);
        System.out.print("aggiunta in ordine alfabetico D: ");
        Lista.stampaLista(lista);
        
        lista.aggiungiInOrdineAlfabetico("Y", pc8);
        System.out.print("aggiunta in ordine alfabetico Y: ");
        Lista.stampaLista(lista);
        
    }
}