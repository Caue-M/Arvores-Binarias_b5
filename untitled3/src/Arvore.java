public class Arvore {
    No raiz;
    int altura(No no){
        if (no == null)
            return 0;
        return no.altura;
    }
    int fatorBalanceamento(No no) {
        if (no == null)
            return 0;
        return altura(no.esquerdo) - altura(no.direito);
    }
    No rotacaoDireita(No y){
        No x = y.esquerdo;
        No temp = x.direito;

        //realizar rotacao
        x.direito = y;
        y.esquerdo = temp;

        // att das alturas
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    }
    No rotacaoEsquerda(No x){
        No y = x.direito;
        No temp = y.esquerdo;

        //realizar rotacao
        y.esquerdo = x;
        x.direito = temp;


        // att das alturas
        x.altura = Math.max(altura(x.esquerdo), altura(y.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(x.direito)) + 1;

        return y;
    }
    public void emOrdem(No no){
        if (no != null){
            emOrdem(no.esquerdo);
            System.out.println(no.chave + " ");
            emOrdem(no.direito);
        }
    }
    No inserir(No no, int chave){
        if (no == null) {
            return new No(chave);
        }
        if (chave < no.chave) {
            no.esquerdo = inserir(no.esquerdo, chave);
        }
        else if (chave > no.chave) {
            no.direito = inserir(no.direito, chave);
        }
        else {
            return no;
        }
            no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

        int balanceamento = fatorBalanceamento(no);
        //verificar casos de desbalanceamento
        if (balanceamento > 1 && chave > no.esquerdo.chave)
            return rotacaoDireita(no);
        if (balanceamento < -1 && chave > no.direito.chave) {
            return rotacaoEsquerda(no);
        }
        if (balanceamento > 1 && chave > no.esquerdo.chave) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && chave > no.direito.chave) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }
        return no;
    }
}