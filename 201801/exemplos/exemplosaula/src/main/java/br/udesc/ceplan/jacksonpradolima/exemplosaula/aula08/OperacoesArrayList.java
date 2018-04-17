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
import java.util.List;
import java.util.stream.Collectors;

/**
 * Operações com Lista, neste exemplo usamos ArrayList
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class OperacoesArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }

        // Inserir valores repetidos
        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }

        System.out.println("Lista: " + Arrays.toString(lista.toArray()));

        //List<Integer> filtro = lista.stream().filter(p -> p > 5).collect(Collectors.toList());
        //Seleciona os valores maiores do que 5
        ArrayList<Integer> filtroArray = new ArrayList<>(
                lista.stream()
                        .filter(p -> p > 5)
                        .collect(Collectors.toList())
        );

        System.out.println("Lista filtrada: " + Arrays.toString(filtroArray.toArray()));

        filtroArray = new ArrayList<>(filtroArray.stream().distinct().collect(Collectors.toList()));

        System.out.println("Lista sem valores repetidos: " + Arrays.toString(filtroArray.toArray()));

        Collections.reverse(filtroArray);

        System.out.println("Lista invertida: " + Arrays.toString(filtroArray.toArray()));

        System.out.println("Total de itens na lista: " + filtroArray.size());
    }
}
