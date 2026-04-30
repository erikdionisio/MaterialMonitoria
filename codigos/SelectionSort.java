public class SelectionSort implements SortingStrategy {

    /**
    * Ordena um array de inteiros utilizando o selection sort.
    */
    public void sort(int[] v) {
       
        for (int i = 0; i < v.length; i++) {
		
		int i_menor = i;
		for (int j = i + 1; j < v.length -1; j++)
			if (v[j] < v[i_menor])
				i_menor = j;
		
		int aux = v[i];
		v[i] = v[i_menor];
		v[i_menor] = aux;
	
	}	
    
}

    /**
    * Ordena um array de inteiros utilizando o selection sort de maneira recursiva.
    * Pense que selection sort são várias execuções da atividade de procurar 
    * o menor e colocá-lo em seu lugar. Use essa estratégia chamando recursivamente. 
    * Você não pode mudar a assinatura desse método, mas pode/deve criar outros
    * métodos para te auxiliar na recursão.
    */
    public void sortRecursivo(int[] v) {
       if (v == null || v.length <= 1) {
            return;
        }
        // Inicia com i=0, j=1, e o índice do menor provisório como 0
        sortAuxiliar(v, 0, 1, 0);
    }

    /**
    * Método auxiliar único que controla toda a recursão.
    */
    private void sortAuxiliar(int[] v, int i, int j, int i_menor) {
        // Caso base principal: se o 'i' chegou no penúltimo elemento, está ordenado
        if (i >= v.length - 1) {
            return;
        }

        // Simula o laço INTERNO: continua buscando o menor valor até o fim do array
        if (j < v.length) {
            if (v[j] < v[i_menor]) {
                i_menor = j;
            }
            // Chamada recursiva avançando apenas o 'j'
            sortAuxiliar(v, i, j + 1, i_menor);
        } 
        // Simula o laço EXTERNO: quando o 'j' chega ao fim, faz a troca e avança o 'i'
        else {
            int aux = v[i];
            v[i] = v[i_menor];
            v[i_menor] = aux;
            
            // Chamada recursiva avançando o 'i', resetando o 'j' e o 'i_menor'
            sortAuxiliar(v, i + 1, i + 2, i + 1);
        }
    }
}
