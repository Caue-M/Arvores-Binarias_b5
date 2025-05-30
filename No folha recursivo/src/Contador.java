public class Contador {
    public int contarNosFolha(No no){
        if (no == null)return 0;
        if (no.esq == null && no.dir == null) return 1;
        return contarNosFolha(no.esq) + contarNosFolha(no.dir);
    }
}
