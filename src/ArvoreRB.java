import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArvoreRB {
    private NoRB raiz;

    public void inserir(int valor) {
        NoRB novo = new NoRB(valor);
        NoRB atual = raiz, pai = null;

        while (atual != null) {
            pai = atual;
            if (novo.valor < atual.valor)
                atual = atual.esquerda;
            else
                atual = atual.direita;
        }

        novo.pai = pai;
        if (pai == null) {
            raiz = novo;
        } else if (novo.valor < pai.valor) {
            pai.esquerda = novo;
        } else {
            pai.direita = novo;
        }

        novo.esquerda = null;
        novo.direita = null;
        novo.cor = Cores.VERMELHO;

        corrigirInsercao(novo);
    }

    private void corrigirInsercao(NoRB no) {
        while (no != raiz && no.pai.cor == Cores.VERMELHO) {
            if (no.pai == no.pai.pai.esquerda) {
                NoRB tio = no.pai.pai.direita;
                if (tio != null && tio.cor == Cores.VERMELHO) {
                    no.pai.cor = Cores.PRETO;
                    tio.cor = Cores.PRETO;
                    no.pai.pai.cor = Cores.VERMELHO;
                    no = no.pai.pai;
                } else {
                    if (no == no.pai.direita) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.cor = Cores.PRETO;
                    no.pai.pai.cor = Cores.VERMELHO;
                    rotacaoDireita(no.pai.pai);
                }
            } else {
                NoRB tio = no.pai.pai.esquerda;
                if (tio != null && tio.cor == Cores.VERMELHO) {
                    no.pai.cor = Cores.PRETO;
                    tio.cor = Cores.PRETO;
                    no.pai.pai.cor = Cores.VERMELHO;
                    no = no.pai.pai;
                } else {
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.cor = Cores.PRETO;
                    no.pai.pai.cor = Cores.VERMELHO;
                    rotacaoEsquerda(no.pai.pai);
                }
            }
        }
        raiz.cor = Cores.PRETO;
    }

    private void rotacaoEsquerda(NoRB x) {
        NoRB y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) y.esquerda.pai = x;

        y.pai = x.pai;
        if (x.pai == null) raiz = y;
        else if (x == x.pai.esquerda) x.pai.esquerda = y;
        else x.pai.direita = y;

        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRB y) {
        NoRB x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != null) x.direita.pai = y;

        x.pai = y.pai;
        if (y.pai == null) raiz = x;
        else if (y == y.pai.direita) y.pai.direita = x;
        else y.pai.esquerda = x;

        x.direita = y;
        y.pai = x;
    }

    public void emOrdemRB() {
        emOrdemRB(raiz);
        System.out.println();
    }

    private void emOrdemRB(NoRB no) {
        if (no != null) {
            emOrdemRB(no.esquerda);
            String cor = (no.cor == Cores.VERMELHO) ? "R" : "B";
            System.out.print(no.valor + cor + " ");
            emOrdemRB(no.direita);
        }
    }

    public void preOrdemRB() {
        preOrdemRB(raiz);
        System.out.println();
    }

    private void preOrdemRB(NoRB no) {
        if (no != null) {
            String cor = (no.cor == Cores.VERMELHO) ? "R" : "B";
            System.out.print(no.valor + cor + " ");
            preOrdemRB(no.esquerda);
            preOrdemRB(no.direita);
        }
    }

    public void posOrdemRB() {
        posOrdemRB(raiz);
        System.out.println();
    }

    private void posOrdemRB(NoRB no) {
        if (no != null) {
            posOrdemRB(no.esquerda);
            posOrdemRB(no.direita);
            String cor = (no.cor == Cores.VERMELHO) ? "R" : "B";
            System.out.print(no.valor + cor + " ");
        }
    }

    public int contarNos(NoRB no) {
        if (no == null) return 0;
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }

    public int contarNosFolha(NoRB no) {
        if (no == null) return 0;
        if (no.esquerda == null && no.direita == null) return 1;
        return contarNosFolha(no.esquerda) + contarNosFolha(no.direita);
    }

    public NoRB getRaiz() {
        return raiz;
    }
}
