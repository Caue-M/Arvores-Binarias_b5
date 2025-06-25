public class Arvore {
    No raiz;
    int altura(No no){
        if (no == null)
            return 0;
        return no.altura;
    }

    //Exerciico 11, Inseeção dos balanceamentos
    int fatorBalanceamento(No no) {
        if (no == null)
            return 0;
        return altura(no.esquerda) - altura(no.direita);
    }
    No rotacaoDireita(No y){
        No x = y.esquerda;
        No temp = x.direita;

        //realizar rotacao
        x.direita = y;
        y.esquerda = temp;

        // att das alturas
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }
    No rotacaoEsquerda(No x){
        No y = x.esquerda;
        No temp = y.direita;

        //realizar rotacao
        y.esquerda = x;
        x.direita = temp;


        // att das alturas
        x.altura = Math.max(altura(x.esquerda), altura(y.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(x.direita)) + 1;

        return x;
    }
    No inserir(No no, int chave) {
        if (no == null)
            return new No(chave);

        if (chave < no.chave)
            no.esquerda = inserir(no.esquerda, chave);
        else if (chave > no.chave)
            no.direita = inserir(no.direita, chave);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = fatorBalanceamento(no);

        // Caso Esquerda-Esquerda
        if (balanceamento > 1 && chave < no.esquerda.chave)
            return rotacaoDireita(no);

        // Caso Direita-Direita
        if (balanceamento < -1 && chave > no.direita.chave)
            return rotacaoEsquerda(no);

        // Caso Esquerda-Direita
        if (balanceamento > 1 && chave > no.esquerda.chave) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        // Caso Direita-Esquerda
        if (balanceamento < -1 && chave < no.direita.chave) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

}