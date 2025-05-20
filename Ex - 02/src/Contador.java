public class Contador {
    public int contar(No valor){
        if(valor == null) return 0;
        return 1 + contar(valor.esquerda) + contar(valor.direita);
    }
}
