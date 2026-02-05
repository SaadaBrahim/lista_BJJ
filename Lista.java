public class Lista{
int size;
Nodo cursore;
Nodo primoRiferimento;

//Getter&Setter
public int getSize() {
    return size;
}

public void setSize(int size) {
    this.size = size;
}

public Nodo getCursore() {
    return cursore;
}

public void setCursore(Nodo cursore) {
    this.cursore = cursore;
}

public Nodo getPrimoRiferimento() {
    return primoRiferimento;
}

public void setPrimoRiferimento(Nodo primoRiferimento) {
    this.primoRiferimento = primoRiferimento;
}

    public void accoda(String valore, Computer pc){
        Nodo cursor = raggiungiIndice(size-1);
        aggiungiNodo(valore, cursor, pc);
    }

private void aggiungiNodo(String valore, Nodo posizione, Computer pc){
    Nodo nuovoNodo = new Nodo();
    nuovoNodo.setValore(valore);
    nuovoNodo.setComputer(pc);
    if (primoRiferimento == null) {
        primoRiferimento = nuovoNodo;
    } else if (posizione != null) {
        nuovoNodo.setNext(posizione.getNext());
        posizione.setNext(nuovoNodo);
    }
    size++;
}

public void elimina(Nodo nodo){
    if (primoRiferimento == null || nodo == null) {
        return;
    }
    
    if (primoRiferimento == nodo) {
        primoRiferimento = nodo.getNext();
        size--;
        return;
    }
    
    Nodo corrente = primoRiferimento;
    while (corrente != null && corrente.getNext() != nodo) {
        corrente = corrente.getNext();
    }
    
    if (corrente != null && corrente.getNext() == nodo) {
        corrente.setNext(nodo.getNext());
        size--;
    }
    
    if (cursore == nodo) {
        cursore = nodo.getNext();
    }
}

public Nodo visita() {
    if (cursore == null) {
        return null;
    }

    Nodo nodoCorrente = cursore;
    cursore = cursore.getNext();
    return nodoCorrente;
}

public Nodo raggiungiIndice(int indice) {
    if (indice < 0 || indice >= size) {
        return null;
    }
    
    Nodo corrente = primoRiferimento;
    for (int i = 0; i < indice; i++) {
        if (corrente == null) {
            return null;
        }
        corrente = corrente.getNext();
    }
    return corrente;
}

public int trovaIndice(Nodo nodo) {
    if (nodo == null) {
        return -1;
    }
    
    Nodo corrente = primoRiferimento;
    for (int i = 0; i < size; i++) {
        if (corrente == nodo) {
            return i;
        }
        corrente = corrente.getNext();
    }
    return -1;
}

public void inserimento(int indice, String valore){
    if (indice < 0 || indice > size) {
        System.out.println("indice non valido");
        return;
    }
    
    Nodo nuovoNodo = new Nodo();
    nuovoNodo.setValore(valore);
    
    if (indice == 0) {
        nuovoNodo.setNext(primoRiferimento);
        primoRiferimento = nuovoNodo;
    } else {
        Nodo precedente = raggiungiIndice(indice - 1);
        if (precedente != null) {
            nuovoNodo.setNext(precedente.getNext());
            precedente.setNext(nuovoNodo);
        }
    }
    size++;
}

public void inserimentoInTesta(String valore, Computer pc){
    Nodo nuovoNodo = new Nodo();
    nuovoNodo.setValore(valore);
        nuovoNodo.setComputer(pc);

    nuovoNodo.setNext(primoRiferimento);
    primoRiferimento = nuovoNodo;
    size++;
}

public void inserimentoInCoda(String valore, Computer pc){
    Nodo nuovoNodo = new Nodo();
    nuovoNodo.setValore(valore);
    nuovoNodo.setComputer(pc);
    
    if (primoRiferimento == null) {
        primoRiferimento = nuovoNodo;
    } else {
        Nodo ultimo = raggiungiIndice(size - 1);
        if (ultimo != null) {
            ultimo.setNext(nuovoNodo);
        }
    }
    size++;

}

public void inserimentoInMezzo(int indice, String valore, Computer pc){
    if (indice <= 0 || indice >= size) {
        System.out.println("indice non valido");
        return;
    }
    
    Nodo nuovoNodo = new Nodo();
    nuovoNodo.setValore(valore);
        nuovoNodo.setComputer(pc);

    
    Nodo precedente = raggiungiIndice(indice - 1);
    if (precedente != null) {
        nuovoNodo.setNext(precedente.getNext());
        precedente.setNext(nuovoNodo);
        size++;
    }

}
    public static void stampaLista(Lista lista) {
        Nodo temp = lista.getPrimoRiferimento();
        while (temp != null) {
            System.out.print(temp.toString() + " ");
            System.out.print("");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void aggiungiInOrdineAlfabetico(String valore, Computer pc) {
        if (primoRiferimento == null) {
            inserimentoInTesta(valore, pc);
            return;
        }
        
        Nodo corrente = primoRiferimento;
        int indice = 0;
        
            while (corrente != null &&
                valore.compareTo(corrente.getValore()) > 0) {
                corrente = corrente.getNext();
                indice++;
        }


        
        if (indice == 0) {
            inserimentoInTesta(valore, pc);
        } else if (indice >= size) {
            inserimentoInCoda(valore, pc);
        } else {
            inserimentoInMezzo(indice, valore, pc);
        }
    }

}