import java.util.NoSuchElementException;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	public Pilha<E> subPilha(int numItens) {

		int total = 0;
		Celula<E> aux = topo;
		while (aux != fundo) {
			total++;
			aux = aux.getProximo();
		}

		if (total < numItens) {
			throw new IllegalArgumentException(
				"A pilha não contém " + numItens + " elementos. Total atual: " + total);
		}


		Pilha<E> temp = new Pilha<>();
		Celula<E> atual = topo;
		for (int i = 0; i < numItens; i++) {
			temp.empilhar(atual.getItem());
			atual = atual.getProximo();
		}

		Pilha<E> resultado = new Pilha<>();
		while (!temp.vazia()) {
			resultado.empilhar(temp.desempilhar());
		}

		return resultado;
	}
}