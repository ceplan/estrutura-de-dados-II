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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.aula07;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class ExemploHashMap2 {

    public static void main(String args[]) {

        Map<String, String> example = new HashMap<>();

        /*
        * Vamos adicionar alguns valores a nossa lista
        * */
        example.put("K1", "V1");
        example.put("K2", "V2");
        example.put("K3", "V3");
        example.put("K4", "V4");
        example.put("K5", "V5");

        String keyToSearch = "K1";

        //containsKey – Procurar uma chave na HashMap
        if (example.containsKey(keyToSearch)) {
            System.out.println("Valor da Chave " + keyToSearch
                    + " = " + example.get(keyToSearch));
        } else {
            System.err.println("Chave não existe");
        }

        /*
        * O método "keySet()" retorna um Set com todas as chaves do
        * nosso HashMap, e tendo o Set com todas as Chaves, 
         * podemos facilmente pegar
        * os valores que desejamos
        * */
        for (String key : example.keySet()) {

            //Capturamos o valor a partir da chave
            String value = example.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
