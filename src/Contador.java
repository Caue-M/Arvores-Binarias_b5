import java.util.LinkedList;
import java.util.Queue;

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
    //Contador pos ordem, exercicio 5
    public void contarPosOrdem(No no) {
        if (no != null) {
            contarPosOrdem(no.esquerda);
            contarPosOrdem(no.direita);
            System.out.print(no.valor + ", ");
        }
    }
    public void busca(No raiz){
        if (raiz == null) return;
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while(!fila.isEmpty()){
            No atual = fila.poll();
            System.out.print((atual.valor + ", "));
            if(atual.esquerda != null){
                fila.add(atual.esquerda);
            }
            if (atual.direita != null){
                fila.add(atual.direita);
            }
        }
    }
}
