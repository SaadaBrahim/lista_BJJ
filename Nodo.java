public class Nodo{
  private Computer computer;
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

    public void setComputer(Computer pc){
        this.computer = pc;
    }

    public Computer getComputer(){
        return computer;
    }

    public String toString(){
        return computer.toString() + "nome " + valore;
    }

}