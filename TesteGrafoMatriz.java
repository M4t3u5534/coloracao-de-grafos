/* 
Alunos:
Mateus Ribeiro Cerqueira - 10443901
Pedro Henrique Carvalho Pereira - 10418861

Compilação e Execução
javac *.java
java TesteGrafoMatriz
*/
public class TesteGrafoMatriz {
	public static void main(String args[]) {

		// g1: Grafo da Atividade Solicitada Anteriormente
		// vértices 1 a 5 da figura viram 0 a 4 (vértice - 1)
		TGrafo g1 = new TGrafo(5);
		g1.insereAN(0, 1); // 1-2
		g1.insereAN(1, 2); // 2-3
		g1.insereAN(1, 3); // 2-4
		g1.insereAN(2, 3); // 3-4
		g1.insereAN(0, 4); // 1-5
		g1.insereAN(3, 4); // 4-5

		// mostra o grafo e a coloração
		System.out.println("\n\n------- g1 ----------");
		g1.show();
		g1.coloracao();


		// g2: Grafo do Problema dos Exames - Material da Aula
		// vértices A=0, B=1, C=2, D=3, E=4, F=5, G=6, H=7, I=8
		TGrafo g2 = new TGrafo(9);
		g2.insereAN(0, 5); // A-F
		g2.insereAN(0, 6); // A-G
		g2.insereAN(0, 8); // A-I
		g2.insereAN(1, 2); // B-C
		g2.insereAN(1, 7); // B-H
		g2.insereAN(2, 4); // C-E
		g2.insereAN(2, 7); // C-H
		g2.insereAN(3, 4); // D-E
		g2.insereAN(3, 5); // D-F
		g2.insereAN(3, 7); // D-H
		g2.insereAN(4, 6); // E-G
		g2.insereAN(5, 6); // F-G
		g2.insereAN(5, 8); // F-I
		g2.insereAN(6, 7); // G-H
		g2.insereAN(6, 8); // G-I

		// mostra o grafo e a coloração
		System.out.println("---- g2 --------");
		g2.show();
		g2.coloracao();

	}
}