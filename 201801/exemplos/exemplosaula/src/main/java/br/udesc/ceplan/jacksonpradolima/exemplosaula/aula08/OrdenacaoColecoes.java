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

/**
 * Ordenações em coleções com um ArrayList
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class OrdenacaoColecoes {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(3);
        lista.add(1);

        System.out.println("Lista sem ordenação: " + Arrays.toString(lista.toArray()));

        Collections.sort(lista);

        System.out.println("Lista ordenada: " + Arrays.toString(lista.toArray()));

        Collections.sort(lista, Collections.reverseOrder());

        System.out.println("Lista ordenada descendentemente: " + Arrays.toString(lista.toArray()));
    }
}
