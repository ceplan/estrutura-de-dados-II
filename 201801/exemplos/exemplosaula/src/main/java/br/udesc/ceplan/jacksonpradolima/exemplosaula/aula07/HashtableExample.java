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

import java.util.Hashtable;
import java.util.Enumeration;

public class HashtableExample {

    public static void main(String[] args) {

        Enumeration names;
        String key;

        // Creating a Hashtable
        Hashtable<String, String> hashtable
                = new Hashtable<String, String>();

        // Adding Key and Value pairs to Hashtable
        hashtable.put("Key1", "Chaitanya");
        hashtable.put("Key2", "Ajeet");
        hashtable.put("Key3", "Peter");
        hashtable.put("Key4", "Ricky");
        hashtable.put("Key5", "Mona");

        names = hashtable.keys();
        while (names.hasMoreElements()) {
            key = (String) names.nextElement();
            System.out.println("Key: " + key + " & Value: "
                    + hashtable.get(key));
        }
    }
}
