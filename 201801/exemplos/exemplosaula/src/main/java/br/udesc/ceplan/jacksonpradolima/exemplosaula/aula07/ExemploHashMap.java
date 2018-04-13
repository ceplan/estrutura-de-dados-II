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
public class ExemploHashMap {

    public static void main(String args[]) {

        /*
     * Criamos nosso HashMap que irá armazenar um par chave-valor, 
     * sendo que tanto a chave como o valor deverá sempre ser do tipo 
     * "String". Pois especificamos isso no Generics
     * através do <String,String>
     *
     * Atenção: Lembre-se que o tamanho inicial do HashMap é 
     * 16 e o load factor é 0.75,
     * então quando nossa lista alcançar o tamanho 12, 
     * automaticamente ela dobrará para 32.
     * Vamos ver isso acontecer.
     * */
        Map<String, String> example = new HashMap<>();

        /*
      * Vamos adicionar alguns valores a nossa lista
      * */
        example.put("K1", "V1");
        example.put("K2", new String("V2"));
        example.put("K3", new String("V3"));
        example.put("K4", new String("V4"));
        example.put("K5", new String("V5"));
        example.put("K6", new String("V6"));
        example.put("K7", new String("V7"));
        example.put("K8", new String("V8"));
        example.put("K9", new String("V9"));
        example.put("K10", new String("V10"));
        example.put("K11", new String("V11"));
        example.put("K12", new String("V12"));

        /*
     * LIMITE DE INSERÇÃO.
     * Aqui é o limite de acord0 com o load factor, ou seja, 
     * quando o elemento 13 for inserido ocorrerá um Rehash na nossa lista.
     * */
        example.put("K13", new String("V13"));

        System.out.println("Rehash ocorrendo agora! Nosso HashMap terá tamanho igual a 32 a partir daqui");

        example.put("K14", new String("V14"));
        example.put("K15", new String("V15"));
        example.put("K16", new String("V16"));
    }
}
