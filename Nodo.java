public class Nodo{
  private Tecnica tecnica;
  private String valore;
  private Nodo next;

//Getter&Setter
  public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public Tecnica getTecnica() {
        return tecnica;
    }
    public void setTecnica(Tecnica tecnica) {
        this.tecnica = tecnica;
    }

    public String toString(){
        return tecnica.toString() + "nome " + valore;
    }

    public String getNome() {
        return valore;
    }

    public int getCategoria() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoria'");
    }

}