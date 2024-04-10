import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantidade de elementos do conjunto A:");
        int linhasA = scanner.nextInt();
        int[][] conjuntoA = new int[linhasA][1];
        System.out.println("Informe os elementos do conjunto A:");
        for (int i = 0; i < linhasA; i++) {
            conjuntoA[i][0] = scanner.nextInt();
        }

        System.out.println("Quantidade de elementos do conjunto B:");
        int linhasB = scanner.nextInt();
        int[][] conjuntoB = new int[linhasB][1];
        System.out.println("Informe os elementos do conjunto B: ");
        for (int i = 0; i < linhasB; i++) {
            conjuntoB[i][0] = scanner.nextInt();
        }

        System.out.println("Quantidade de linhas do conjunto C:");
        int linhasC = scanner.nextInt();
        int[][] conjuntoC = new int[linhasC][1];
        System.out.println("Informe os elementos do conjunto C:");
        for (int i = 0; i < linhasC; i++) {
            conjuntoC[i][0] = scanner.nextInt();
        }

        System.out.println("Escolha a relação R:");
        int escolhaR = escolherRelacao(scanner);

        System.out.println("Escolha a relação S:");
        int escolhaS = escolherRelacao(scanner);

        int[][] paresSoR = Relacoes.calcularParesSoR(conjuntoA, conjuntoB, conjuntoC, escolhaR, escolhaS);

        System.out.println("Pares que atendem à relação composta S ◦ R:");
        for (int[] par : paresSoR) {
            System.out.println("<" + par[0] + ", " + par[1] + ">");
        }

        System.out.println("Classificação da relação composta:");
        if (Relacoes.isFuncional(paresSoR)) {
            System.out.println("Funcional.");
        }
        if (Relacoes.isInjetora(paresSoR)) {
            System.out.println("Injetora.");
        }
        if (Relacoes.isTotal(paresSoR, conjuntoA)) {
            System.out.println("Total.");
        }
        if (Relacoes.isSobrejetora(paresSoR, conjuntoC)) {
            System.out.println("Sobrejetora.");
        }
        if (Relacoes.isMonomorfismo(paresSoR, conjuntoA, conjuntoC)) {
            System.out.println("Monomorfismo.");
        }
        if (Relacoes.isEpimorfismo(paresSoR, conjuntoA, conjuntoC)) {
            System.out.println("Epimorfismo.");
        }
        if (Relacoes.isIsomorfismo(paresSoR, conjuntoA, conjuntoC)) {
            System.out.println("Isomorfismo.");
        }
    }

    public static int escolherRelacao(Scanner scanner) {
        System.out.println("1. Maior que");
        System.out.println("2. Menor que");
        System.out.println("3. Igual a");
        System.out.println("4. Ser o quadrado de");
        System.out.println("5. Ser a raiz quadrada de");
        return scanner.nextInt();
    }
}
