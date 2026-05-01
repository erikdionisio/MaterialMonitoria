public class InsertionSort implements SortingStrategy {

    /**
    * O array  está ordenado exceto pelo último elemento. Esse método
    * deve colocar o último elemento em sua posição.
    * Importante: seu algoritmo deve ser O(n).
    */


    /**
     * Este método assume que do índice 0 até o penúltimo o array está perfeito. Apenas o último elemento é o "intruso".
     * O passo a passo:
     *
     *   Guarda o intruso: Você salva o valor do último elemento em uma variável (ex: ultimo = 12).
    
        Compara da direita para a esquerda: Você olha para o vizinho da esquerda (j = v.length - 2).

        Desloca os maiores: Enquanto o vizinho da esquerda for maior que o seu ultimo, 
        você copia esse vizinho uma posição para a direita. Isso cria um "espaço vazio" que vai se movendo para a esquerda.

        Encaixa: Quando você achar alguém menor ou chegar no início do array, você coloca o ultimo ali.
     * 
     */
    public void insereUltimoOrdenado(int[] v) {
        if (v == null || v.length <= 1) return;
        
        int ultimo = v[v.length - 1];
        int j = v.length - 2;
        
        // Empurra os elementos maiores que 'ultimo' para a direita
        while (j >= 0 && v[j] > ultimo) {
            v[j + 1] = v[j];
            j--;
        }
        
        // Insere o último elemento no "buraco" deixado
        v[j + 1] = ultimo;
    }


    /**
    * O array  está ordenado exceto pelo primeiro elemento. Esse método
    * deve colocar o primeiro elemento em sua posição. Ao final da execução,
    * v deve estar ordenado.
    * Importante: seu algoritmo deve ser O(n);
    */

    /**
     * Aqui é o contrário: do segundo elemento até o fim está tudo certo. O primeiro elemento é que precisa
     *  "descer" para a posição correta.

    O passo a passo:

    Guarda o intruso: Salva o valor da primeira posição (primeiro = v[0]).

    Compara da esquerda para a direita: Você começa a olhar a partir do segundo elemento (j = 1).

    Puxa os menores: Enquanto o elemento da direita for menor que o seu primeiro,
     você traz esse elemento para a esquerda. O "buraco" vai andando para a direita.

    Encaixa: Quando achar alguém maior ou o fim do array, coloca o primeiro lá.
     * 
     */
    public void inserePrimeiroOrdenado(int[] v) {
        if (v == null || v.length <= 1) return;
        
        int primeiro = v[0];
        int j = 1;
        
        // Puxa os elementos menores que 'primeiro' para a esquerda
        while (j < v.length && v[j] < primeiro) {
            v[j - 1] = v[j];
            j++;
        }
        
        // Insere o primeiro elemento no espaço correto
        v[j - 1] = primeiro;
    }

    /**
    * Ordena um array de inteiros utilizando o insertion sort.
    */
    public void sort(int[] v) {
        if (v == null || v.length <= 1) return;
        
        for (int i = 1; i < v.length; i++) {
            int chave = v[i];
            int j = i - 1;
            
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = chave;
        }
    }

    /**
    * Ordena um array de inteiros utilizando o insertion sort de maneira recursiva.
    * Pense que insertion sort são várias execuções da inserção ordenada e use
    * essa estratégia chamando recursivamente. 
    * Você não pode mudar a assinatura desse método, mas pode/deve criar outros
    * métodos para te auxiliar na recursão.
    */
    public void sortRecursivo(int[] v) {
        if (v == null || v.length <= 1) return;
        ordenar(v, v.length);
    }

    /**
     * Método auxiliar que controla o progresso da ordenação (substitui o 'for').
     * @param v O array a ser ordenado.
     * @param n O tamanho da parte do array sendo considerada.
     */
    private void ordenar(int[] v, int n) {
        // Caso base: se o tamanho for 1, já está ordenado
        if (n <= 1) return;

        // Ordena os primeiros n-1 elementos primeiro
        ordenar(v, n - 1);

        // Insere o último elemento (v[n-1]) na sua posição correta na parte já ordenada
        int chave = v[n - 1];
        inserir(v, n - 2, chave);
    }

    /**
     * Método auxiliar que realiza a inserção ordenada (substitui o 'while').
     * @param v O array.
     * @param j O índice do elemento sendo comparado com a chave.
     * @param chave O valor que buscamos posicionar.
     */
    private void inserir(int[] v, int j, int chave) {
        // Caso base da inserção: chegamos ao início ou encontramos um elemento menor/igual
        if (j < 0 || v[j] <= chave) {
            v[j + 1] = chave;
            return;
        }

        // Move o elemento para a direita (abre espaço)
        v[j + 1] = v[j];

        // Chamada recursiva para continuar verificando os elementos anteriores
        inserir(v, j - 1, chave);
    }  
}