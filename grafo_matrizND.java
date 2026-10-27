public class grafo_matrizND {
    private
        int n; // quantidade de vértices
        int m; // quantidade de arestas
        int adj[][]; //matriz de adjacência
    public
        grafo_matrizND(int n){
            this.n = n;
            this.m = 0;
            int adjac[][] = new int[n][];
            for(int i = 0; i < n; i++)
                adjac[i]= new int[n];
            adj = adjac;
            for(int i = 0; i< n; i++) {
                for(int j = 0; j< n; j++) {
                    adj[i][j]=0;
                }
            }
        }

        void insereA(int v, int w){
            if(adj[v][w] == 0 ){
                adj[v][w] = 1;
                adj[w][v] = 1;
                m++; // atualiza qtd arestas
            }
        }

        void removeA(int v, int w){
            if(adj[v][w] == 1 ){
                adj[v][w] = 0;
                adj[w][v] = 0;
                m--; // atualiza qtd arestas
            }
        }

        void show(){
            System.out.println("n: " + n);
            System.out.println("m: " + m);
            for( int i=0; i < n; i++){
                System.out.print("\n");
                for( int w=0; w < n; w++)
                    if(adj[i][w] == 1)
                        System.out.print("Adj[" + i + "," + w + "]= 1" + " ");
                    else System.out.print("Adj[" + i + "," + w + "]= 0" + " ");
            }
            System.out.println("\nfim da impressao do grafo.");
        }

        int degree(int v){
            int grau = 0;
            for (int i = 0; i < n; i++){
                if (adj[v][i] == 1) {
                    grau += 1;
                }
            }
            return grau;
        }

        /* 11) Remove o vértice v do grafo */
        void removeVertice(int v){
            int novoN = n - 1;
            int novoAdj[][] = new int[novoN][novoN];
            int novoM = 0;
            int li = 0;
            for (int i = 0; i < n; i++){
                if (i == v) continue;

                
                int lj = 0;
                
                for (int j = 0; j < n; j++){
                    if (j == v) continue;
                
                    novoAdj[li][lj] = adj[i][j];
                
                    if (li != lj && novoAdj[li][lj] == 1) novoM++;
                
                
                    lj++;
                }
                li++;
            }
            n = novoN;
            adj = novoAdj;
            m = novoM / 2; // cada aresta é contada duas vezes na matriz simétrica
        }

        /* 12) Verifica se o grafo não dir é completo*/
        boolean ehCompleto(){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (i != j && adj[i][j] != 1) return false;
                }
            }
            return true;
        }

        /* 14) Retorna complementar */
        int[][] complemento(){
            int[][] comp = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (i == j) comp[i][j] = 0;
                    else comp[i][j] = (adj[i][j] == 1) ? 0 : 1;
                }
            }
            return comp;
        }

        //DFS
        private boolean[] dfsPilha(int nInicial){
            boolean[] marcado = new boolean[n];
            int[] pilha = new int[n * n + 1]; // capacidade segura, igual à outra tarefa
            int topo = -1;

            pilha[++topo] = nInicial; // empilha nó inicial

            while (topo != -1){ // enquanto a pilha não estiver vazia
                int node = pilha[topo--]; // desempilha

                if (!marcado[node]){ // se ainda não foi visitado
                    marcado[node] = true; // marca

                    for (int adjacente = n - 1; adjacente >= 0; adjacente--){
                        if (adj[node][adjacente] == 1 && !marcado[adjacente]){
                            pilha[++topo] = adjacente; // empilha adjacente não marcado
                        }
                    }
                }
            }
            return marcado;
        }

        // 15) Categoria de conexidade
        int conexidade(){
            if (n == 0) return 0;
            boolean[] visitado = dfsPilha(0);
            int qtdVisitados = 0;
            for (int i = 0; i < n; i++)
                if (visitado[i]) qtdVisitados++;

            return (qtdVisitados == n) ? 0 : 1; // 0-conexo, 1-desconexo
        }

        public int[][] getAdj() {
            return adj;
        }

        public int getM() {
            return m;
        }

        public int getN() {
            return n;
        }
}
