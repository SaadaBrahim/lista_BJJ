public class Tecnica extends Bjj{
    private int grado;
    private String categoria;
    private Tecnica successiva;
    private Tecnica next;

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {       
        this.grado = grado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Tecnica getSuccessiva() {
        return successiva;
    }

    public void setSuccessiva(Tecnica successiva) {
        this.successiva = successiva;
    }

    public Tecnica(){}
    public Tecnica(int grado, String categoria, Tecnica successiva, String nome){
        this.grado = grado;
        this.categoria = categoria;
        this.successiva = successiva;
        super(nome);
    }

    public void setNext(Tecnica next) {
    this.next = next;
    }

    public Tecnica getNext() {
        return next;
    }


}