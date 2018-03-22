/*
 * Copyright 2018 Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.udesc.ceplan.jacksonpradolima.exemplosaula.projeto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Classe contendo implementações para gerar diferentes tipos de vetores
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class GeraVetor {

    /**
     * Construtor
     */
    public GeraVetor() {
    }

    /**
     * Cria uma vetor aleatório
     *
     * @param n Tamanho do vetor
     * @return Vetor aleatório
     */
    public int[] random(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        // Para manter o aleatório "controlado", defino um seed ao instanciá-lo
        Random gerador = new Random(n * 10);
        for (int i = 0; i < n; i++) {
            list.add(gerador.nextInt(n * 10));
        }

        // Converte ArrayList de Integer para um vetor de inteiros
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Cria uma lista de inteiros ordenados
     *
     * @param n Tamanho do vetor
     * @return
     */
    private List<Integer> getSortList(int n) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.stream(sort(n))
                .boxed()
                .collect(Collectors.toList()));
        return list;
    }

    /**
     * Cria um vetor quase ordenado de números inteiros
     *
     * @param n Tamanho do vetor
     * @return Vetor quase ordenado
     */
    public int[] nearSort(int n) {
        List<Integer> list = getSortList(n);

        // Número de trocas
        int swaps = (int) (Math.ceil(Math.pow((Math.log(n)), 2.0)));

        // Os dois números para serem trocados a cada vez
        int a, b;

        // Executa um número de trocas iguais a swaps [log (N) ^ 2] arredondado, com números trocados não mais que ln (N)
        for (int i = 0; i < swaps; i++) {
            a = (int) Math.floor(Math.random() * n);
            b = (int) (a + Math.random() * 2 * Math.log(n) - Math.log(n));

            //Contas para casos em que b é maior ou menor que os limites do vetor
            if (b < 0) {
                b = -b;
            } else if (b >= n) {
                b = -1 * (n - b);
            }

            // Realiza a troca
            Collections.swap(list, a, b);
        }

        // Converte ArrayList de Integer para um vetor de inteiros
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Cria um vetor aleatório com muitos valores únicos (repetidos)
     *
     * @param n Tamanho do vetor
     * @return Vetor aleatório com valores repetidos
     */
    public int[] fewUnique(int n) {
        List<Integer> list = Arrays.stream(random(n)).boxed().collect(Collectors.toList());

        // Altera a lista com valores únicos
        for (int i = 0; i < list.size(); i++) {
            list.set(i, (1 + i / (n / 4)) * (n / 4));
        }

        // Embaralha a lista toda
        Collections.shuffle(list);

        // Converte ArrayList de Integer para um vetor de inteiros
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Cria um vetor de números aleatórios com ordenação invertida
     *
     * @param n Tamanho do vetor
     * @return
     */
    public int[] reversed(int n) {
        // Cria uma lista de inteiros ordenados
        List<Integer> list = getSortList(n);

        // Inverte a lista ordenada
        Collections.reverse(list);

        // Converte ArrayList de Integer para um vetor de inteiros
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Cria um vetor ordenado de números aleatórios usando merge sort
     *
     * @param n Tamanho do vetor
     * @return
     */
    public int[] sort(int n) {
        int[] vetor = random(n);
        Arrays.sort(vetor);

        return vetor;
    }
}
