

public class Lista {
    private int size;
    private Nodo head;
    private Nodo tail;
    private Nodo cursore;
    
    public Lista() {
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.cursore = null;
    }
    
    public int getSize() {
        return size;
    }
    
    public Nodo getHead() {
        return head;
    }
    
    public Nodo getTail() {
        return tail;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void inserimentoInTesta(Nodo tc) {
        if (tc == null) return;
        
        tc.setNext(head);
        head = tc;
        
        if (tail == null) {
            tail = tc;
        }
        size++;
        resetCursore();
    }
    
    public void inserimentoInCoda(Nodo tc) {
        if (tc == null) return;
        
        tc.setNext(null);
        
        if (tail == null) {
            head = tail = tc;
        } else {
            tail.setNext(tc);
            tail = tc;
        }
        size++;
        resetCursore();
    }
    
    public void inserimento(int indice, Nodo tc) {
        if (tc == null) return;
        
        if (indice < 0 || indice > size) {
            System.out.println("Indice non valido");
            return;
        }
        
        if (indice == 0) {
            inserimentoInTesta(tc);
            return;
        }
        
        if (indice == size) {
            inserimentoInCoda(tc);
            return;
        }
        
        Nodo precedente = raggiungiNodo(indice - 1);
        if (precedente != null) {
            tc.setNext(precedente.getNext());
            precedente.setNext(tc);
            size++;
            resetCursore();
        }
    }
    
    private Nodo raggiungiNodo(int indice) {
        if (indice < 0 || indice >= size) return null;
        
        Nodo corrente = head;
        for (int i = 0; i < indice; i++) {
            corrente = corrente.getNext();
        }
        return corrente;
    }
    
    public void elimina(Nodo nodo) {
        if (head == null || nodo == null) return;
        
        if (head == nodo) {
            head = head.getNext();
            size--;
            
            if (head == null) {
                tail = null;
            }
            
            if (cursore == nodo) {
                cursore = head;
            }
            return;
        }
        
        Nodo precedente = head;
        while (precedente.getNext() != null && precedente.getNext() != nodo) {
            precedente = precedente.getNext();
        }
        
        if (precedente.getNext() == nodo) {
            precedente.setNext(nodo.getNext());
            
            if (nodo == tail) {
                tail = precedente;
            }
            
            size--;
            if (cursore == nodo) {
                cursore = nodo.getNext();
            }
        }
    }
    
    public void eliminaPerIndice(int indice) {
        if (indice < 0 || indice >= size) {
            System.out.println("Indice non valido");
            return;
        }
        
        Nodo daEliminare = raggiungiNodo(indice);
        if (daEliminare != null) {
            elimina(daEliminare);
        }
    }
    
    public void resetCursore() {
        cursore = head;
    }
    
    public Nodo visita() {
        if (cursore == null) {
            return null;
        }
         Nodo corrente = cursore;
        cursore = cursore.getNext();
        return corrente;
    }
    
    public void aggiungiInOrdineAlfabetico(Nodo tc) {
        if (tc == null) return;
        
        if (head == null || tc.getNome().compareToIgnoreCase(head.getNome()) <= 0) {
            inserimentoInTesta(tc);
            return;
        }
        
        Nodo corrente = head;
        
        while (corrente.getNext() != null && 
               tc.getNome().compareToIgnoreCase(corrente.getNext().getNome()) > 0) {
            corrente = corrente.getNext();
        }
        
        tc.setNext(corrente.getNext());
        corrente.setNext(tc);
        
        if (corrente == tail) {
            tail = tc;
        }
        
        size++;
        resetCursore();
    }
    
    public void stampaLista() {
        if (head == null) {
            System.out.println("Lista vuota");
            return;
        }
        
        Nodo corrente = head;
        while (corrente != null) {
            System.out.print(corrente.getNome() + " ");
            corrente = corrente.getNext();
        }
        System.out.println();
    }
    
    public void stampaListaCompleta() {
        Nodo corrente = head;
        int contatore = 0;
        
        while (corrente != null) {
            System.out.println(contatore + ". " + corrente.getNome() + " - " + 
                             corrente.getTecnica().getCategoria() + " (diff: " + corrente.getTecnica().getDifficolta() + ")");
            corrente = corrente.getNext();
            contatore++;
        }
        
        if (contatore == 0) {
            System.out.println("Lista vuota");
        }
    }
    
    
    
    public int trovaIndice(Nodo nodo) {
        if (nodo == null) return -1;
        
        Nodo corrente = head;
        int indice = 0;
        
        while (corrente != null) {
            if (corrente == nodo) return indice;
            corrente = corrente.getNext();
            indice++;
        }
        
        return -1;
    }
    
    public Nodo getCursore() {
        return cursore;
    }
    
    public void inserimentoInMezzo(int indice, Nodo tc) {
        inserimento(indice, tc);
    }
}