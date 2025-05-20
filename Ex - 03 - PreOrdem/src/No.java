public class No {
    String valor;
    No esquerda;
    No direita;

    public No(String valor){
        this.valor = valor;
        esquerda = null;
        direita = null;
    }

    public void contarPreOrdem(No no) {
        if (no != null) {
            System.out.println(no.valor + ", ");
            contarPreOrdem(no.esquerda);
            contarPreOrdem(no.direita);
        }
    }
}
