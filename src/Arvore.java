public class Arvore {
    No raiz;


    //Classe usada para os exercicios a partir do ex11
    int altura(No no) {
        if (no == null)
            return 0;
        return no.altura;
    }

    int fatorBalanceamento(No no) {
        if (no == null)
            return 0;
        return altura(no.esquerda) - altura(no.direita);
    }

    No rotacaoDireita(No y) {
        No x = y.esquerda;
        No temp = x.direita;

        x.direita = y;
        y.esquerda = temp;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    No rotacaoEsquerda(No x) {
        No y = x.direita;
        No temp = y.esquerda;

        y.esquerda = x;
        x.direita = temp;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.chave + " ");
            emOrdem(no.direita);
        }
    }

    No inserir(No no, int chave) {
        if (no == null) {
            return new No(chave);
        }

        if (chave < no.chave) {
            no.esquerda = inserir(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = inserir(no.direita, chave);
        } else {
            return no; // valores duplicados não são permitidos
        }

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
