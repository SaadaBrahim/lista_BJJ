public class Lista {
    private int size;
    private Tecnica head;   
    private Tecnica tail;  
    private Tecnica cursore;

    public Lista() {
        this.size = 0;
        this.head = null;
        this.tail = null;
        this.cursore = null;
    }

    public int getSize() {
        return size;
    }

    public Tecnica getHead() {
        return head;
    }

    public Tecnica getTail() {
        return tail;
    }

    public Tecnica getCursore() {
        return cursore;
    }

    public void resetCursore() {
        cursore = head;
    }


    public void inserimentoInTesta(Tecnica tc) {
        if (tc == null) return;
        tc.setNext(head);
        head = tc;
        if (tail == null) { 
            tail = head;
        }
        size++;
    }


    public void inserimentoInCoda(Tecnica tc) {
        if (tc == null) return;
        tc.setNext(null);
        if (tail == null) { // lista vuota
            head = tail = tc;
        } else {
            tail.setNext(tc);
            tail = tc;
        }
        size++;
    }

    // Inserimento generico per indice (0..size)
    public void inserimento(int indice, Tecnica tc) {
        if (tc == null) return;
        if (indice < 0 || indice > size) {
            System.out.println("indice non valido");
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
        Tecnica precedente = raggiungiIndice(indice - 1);
        if (precedente != null) {
            tc.setNext(precedente.getNext());
            precedente.setNext(tc);
            size++;
        }
    }

    public Tecnica raggiungiIndice(int indice) {
        if (indice < 0 || indice >= size) return null;
        Tecnica corrente = head;
        for (int i = 0; i < indice; i++) {
            if (corrente == null) return null;
            corrente = corrente.getNext();
        }
        return corrente;
    }

    public int trovaIndice(Tecnica nodo) {
        if (nodo == null) return -1;
        Tecnica corrente = head;
        int idx = 0;
        while (corrente != null) {
            if (corrente == nodo) return idx;
            corrente = corrente.getNext();
            idx++;
        }
        return -1;
    }

    public void elimina(Tecnica nodo) {
        if (head == null || nodo == null) return;

        if (head == nodo) {
            head = head.getNext();
            size--;
            if (head == null) { 
                tail = null;
            }
            if (cursore == nodo) cursore = head;
            return;
        }

        Tecnica precedente = head;
        while (precedente.getNext() != null && precedente.getNext() != nodo) {
            precedente = precedente.getNext();
        }

        if (precedente.getNext() == nodo) {
            precedente.setNext(nodo.getNext());
            if (nodo == tail) { 
                tail = precedente;
            }
            size--;
            if (cursore == nodo) cursore = nodo.getNext();
        }
    }


    public Tecnica visita() {
        if (cursore == null) return null;
        Tecnica corrente = cursore;
        cursore = cursore.getNext();
        return corrente;
    }


    public static void stampaLista(Lista lista) {
        Tecnica temp = lista.getHead();
        while (temp != null) {
            System.out.print(temp.toString() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }


    public void aggiungiInOrdineAlfabetico(Tecnica tc) {
        if (tc == null) return;

        if (head == null) {
            inserimentoInTesta(tc);
            return;
        }

        Tecnica corrente = head;
        int indice = 0;
        while (corrente != null && tc.getNome().compareToIgnoreCase(corrente.getNome()) > 0) {
            corrente = corrente.getNext();
            indice++;
        }

        if (indice == 0) {
            inserimentoInTesta(tc);
        } else if (indice >= size) {
            inserimentoInCoda(tc);
        } else {
            inserimento(indice, tc);
        }
    }


    public void inserimentoInMezzo(int indice, Tecnica tc) {
        inserimento(indice, tc);
    }
}