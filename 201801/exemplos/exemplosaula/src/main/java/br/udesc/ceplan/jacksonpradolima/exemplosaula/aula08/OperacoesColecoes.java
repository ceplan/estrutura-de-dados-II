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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.aula08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Operações com Coleções, neste exemplo usamos ArrayList
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class OperacoesColecoes {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }

        // Inserir valores repetidos
        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }

        Set<String> unique = new HashSet<>();

        unique.addAll(lista.stream()
                .map(m -> m.toString()) // Converto cada elemento da lista em string
                .collect(Collectors.toList()));

        System.out.println("Lista: " + Arrays.toString(lista.toArray()));

        // busca binária
        System.out.println(
                String.format("[Busca binária] Posição do valor %s no array: %s",
                        8,
                        Collections.binarySearch(lista, 8)
                )
        );

        System.out.println("Unique: " + Arrays.toString(unique.toArray()));
        System.out.println("Maior valor: " + Collections.max(lista));
        System.out.println("Menor valor: " + Collections.min(lista));

        //List<Integer> filtro = lista.stream().filter(p -> p > 5).collect(Collectors.toList());
        //Seleciona os valores maiores do que 5
        ArrayList<Integer> filtroArray = new ArrayList<>(
                lista.stream()
                        .filter(p -> p > 5)
                        .collect(Collectors.toList())
        );

        System.out.println("Lista filtrada: " + Arrays.toString(filtroArray.toArray()));

        // busca binária
        System.out.println(
                String.format("[Busca binária] Posição do valor %s no array: %s",
                        8,
                        Collections.binarySearch(filtroArray, 8)
                )
        );

        // Remove itens repetidos
        filtroArray = new ArrayList<>(
                filtroArray.stream()
                        .distinct()
                        .collect(Collectors.toList())
        );

        System.out.println("Lista sem valores repetidos: " + Arrays.toString(filtroArray.toArray()));

        System.out.println("Total de itens na lista: " + filtroArray.size());

        // Inverte a lista
        Collections.reverse(filtroArray);

        String p = "[";
        boolean first = true;
        //outra forma de laço
        for (Integer bb : filtroArray) {
            p = first ? p + bb : p + ", " + bb;
            first = false;
        }
        p += "]";

        System.out.println("Lista invertida: " + p);

        // busca binária
        System.out.println(
                String.format("[Busca binária] Posição do valor %s no array: %s",
                        8,
                        Collections.binarySearch(filtroArray, 8)
                )
        );
    }
}
