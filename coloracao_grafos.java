public class coloracao_grafos {
    private int[][] cores = new int[4];

    public int[][] coloracaoSeq(int adj[][]){
        for (int[] k : cores) {
            k = new ArrayList<int>();
        }
        for (int[] v : adj) {
            for (int[] k : cores) {
                int vizinho = -1;
                for (int n : k) {
                    vizinho = n;
                    if (v[n] == 1) {
                        vizinho = -1;
                        break;
                    }
                }
                if (vizinho != -1) {
                    k.add(vizinho);
                }
            }
        }
        return cores;
    }
}