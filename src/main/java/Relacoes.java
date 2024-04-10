public class Relacoes {
    public static int[][] calcularParesSoR(int[][] conjuntoA, int[][] conjuntoB, int[][] conjuntoC, int escolhaR, int escolhaS) {
        int maxPares = conjuntoA.length * conjuntoB.length * conjuntoC.length;
        int[][] paresSoR = new int[maxPares][2];
        int count = 0;

        for (int[] a : conjuntoA) {
            for (int[] b : conjuntoB) {
                for (int[] c : conjuntoC) {
                    if (verificarRelacaoComposta(a, b, c, escolhaR, escolhaS)) {
                        paresSoR[count][0] = a[0];
                        paresSoR[count][1] = c[0];
                        count++;
                    }
                }
            }
        }

        // Remover espaços não utilizados na matriz
        int[][] resultado = new int[count][2];
        System.arraycopy(paresSoR, 0, resultado, 0, count);
        return resultado;
    }

    public static boolean verificarRelacaoComposta (int[] a, int[] b, int[] c, int escolhaR, int escolhaS) {
        for (int i : a) {
            for (int j : b) {
                for (int k : c) {
                    if (verificarRelacao(i, j, escolhaR) && verificarRelacao(j, k, escolhaS)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean verificarRelacao(int a, int b, int escolha) {
        switch (escolha) {
            case 1:
                return a > b;
            case 2:
                return a < b;
            case 3:
                return a == b;
            case 4:
                return a == (b * b);
            case 5:
                return a == Math.sqrt(b);
            default:
                return false;
        }
    }

    public static boolean isFuncional(int[][] pares) {
        for (int i = 0; i < pares.length; i++) {
            for (int j = i + 1; j < pares.length; j++) {
                if (pares[i][0] == pares[j][0]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isInjetora(int[][] pares) {
        for (int i = 0; i < pares.length; i++) {
            for (int j = i + 1; j < pares.length; j++) {
                if (pares[i][1] == pares[j][1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isTotal(int[][] pares, int[][] conjuntoA) {
        for (int[] a : conjuntoA) {
            boolean encontrado = false;
            for (int[] par : pares) {
                if (par[0] == a[0]) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSobrejetora(int[][] pares, int[][] conjuntoC) {
        for (int[] c : conjuntoC) {
            boolean encontrado = false;
            for (int[] par : pares) {
                if (par[1] == c[0]) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMonomorfismo(int[][] pares, int[][] conjuntoA, int[][] conjuntoC) {
        return isFuncional(pares) && isInjetora(pares);
    }

    public static boolean isEpimorfismo(int[][] pares, int[][] conjuntoA, int[][] conjuntoC) {
        return isTotal(pares, conjuntoA) && isSobrejetora(pares, conjuntoC);
    }

    public static boolean isIsomorfismo(int[][] pares, int[][] conjuntoA, int[][] conjuntoC) {
        return isFuncional(pares) && isTotal(pares, conjuntoA);
    }
}
