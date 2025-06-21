//Classe contador, utilizado para o EX - 2
public class Contador {
    public int contar(No valor){
        if(valor == null) return 0;
        return 1 + contar(valor.esquerda) + contar(valor.direita);
    }
}