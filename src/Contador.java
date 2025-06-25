//Classe contador, utilizado para o EX - 2
//Implementa teste na main
public class Contador {
    public int contar(No valor){
        if(valor == null) return 0;
        return 1 + contar(valor.esquerda) + contar(valor.direita);
    }

    //Contador em pré ordem, utilizado para o exercício 3
    public void contarPreOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + ", ");
            contarPreOrdem(no.esquerda);
            contarPreOrdem(no.direita);
        }
    }
    //contador "em ordem", utilizado para o exercicio 4
    public void contarEmOrdem(No no) {
        if (no != null) {
            contarEmOrdem(no.esquerda);
            System.out.print(no.valor + ", ");
            contarEmOrdem(no.direita);
        }
    }
}
