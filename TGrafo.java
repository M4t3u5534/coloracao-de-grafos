/* Classe TGrafo: grafo por matriz de adjacencia com insercao, remocao, exibicao e coloracao sequencial */

import java.util.ArrayList;

// definição de uma estrutura Matriz de Adjacência para armazenar um grafo
public class TGrafo {
	// Atributos Privados
	private int n; // quantidade de vértices
	private int m; // quantidade de arestas
	private int adj[][]; // matriz de adjacência

	// Métodos Públicos
	public TGrafo(int n) { // construtor
		this.n = n;
		// no início não há arestas
		this.m = 0;
		// alocação da matriz do TGrafo
		this.adj = new int[n][n];

		// inicia a matriz com zeros
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				this.adj[i][j] = 0;
	}

	// insere uma aresta no grafo tal que v é adjacente a w
	public void insereA(int v, int w) {
		// testa se não temos a aresta
		if (adj[v][w] == 0) {
			adj[v][w] = 1;
			m++; // atualiza qtd arestas
		}
	}

	// insere uma aresta nos dois sentidos (grafo não direcionado)
	public void insereAN(int v, int w) {
		insereA(v, w);
		insereA(w, v);
	}

	// remove uma aresta v->w do grafo
	public void removeA(int v, int w) {
		// testa se temos a aresta
		if (adj[v][w] == 1) {
			adj[v][w] = 0;
			m--; // atualiza qtd arestas
		}
	}

	// apresenta o grafo: número de vértices, arestas e a matriz de adjacência
	public void show() {
		System.out.println("n: " + n);
		System.out.println("m: " + m);
		for (int i = 0; i < n; i++) {
			System.out.print("\n");
			for (int w = 0; w < n; w++)
				if (adj[i][w] == 1)
					System.out.print("Adj[" + i + "," + w + "]= 1" + " ");
				else
					System.out.print("Adj[" + i + "," + w + "]= 0" + " ");
		}
		System.out.println("\n\nfim da impressao do grafo.");
	}

	// coloração sequencial: cada linha do retorno é uma classe de cor com seus vértices
	public int[][] coloracaoSeq(int adj[][]) {
		ArrayList<ArrayList<Integer>> cores = new ArrayList<ArrayList<Integer>>();
		for (int j = 0; j < adj.length; j++) {
			cores.add(new ArrayList<Integer>());
		}
		int i = 0;
		for (int[] v : adj) {
			for (ArrayList<Integer> k : cores) {
				int vizinho = i;
				for (int n : k) {
					if (v[n] == 1) {
						vizinho = -1;
						break;
					}
				}
				if (vizinho != -1) {
					k.add(vizinho);
					break;
				}
			}
			i++;
		}

		// conta as classes usadas (não vazias)
		int usadas = 0;
		for (ArrayList<Integer> k : cores)
			if (!k.isEmpty())
				usadas++;



		// converte para int[][] e ignora classes vazias
		int[][] resultado = new int[usadas][];
		int c = 0;

		for (ArrayList<Integer> k : cores) {

			if (!k.isEmpty()) {
				resultado[c] = new int[k.size()];

				for (int j = 0; j < k.size(); j++)
					resultado[c][j] = k.get(j);
				c++;
			}
		}
		return resultado;
	}

	// executa a coloração sequencial e imprime as classes de cor
	public void coloracao() {
		int[][] cores = coloracaoSeq(adj);
		
        System.out.println("Cores: " + cores.length);
		
        for (int k = 0; k < cores.length; k++) {
			System.out.print("Cor " + (k + 1) + ": ");
		
        	for (int v : cores[k])
				System.out.print(v + " ");
		
        	System.out.println();
		}
	}
}