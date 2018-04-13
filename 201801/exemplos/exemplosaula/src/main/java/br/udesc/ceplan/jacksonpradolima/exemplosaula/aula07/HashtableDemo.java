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

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

/**
 * 1. How to put an object into Hashtable?
2. How to retrieve an object from Hashtable in Java?
3. How to reuse Hashtable by using clear()?
4. How to check if Hashtable contains a particular value?
5. How to check if Hashtable contains a particular key?
6. How to traverse Hashtable in Java?
7. How to check if Hashtable is empty in Java?
8. How to Copy content of Hashtable into HashMap?
9. How to find the size of Hashtable in Java?
10. How to get all values form hashtable in Java?
11. How to get all keys from hashtable in Java?
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class HashtableDemo {

    public static void main(String args[]) {

        // Creating Hashtable for example
        Hashtable companies = new Hashtable();

        // Java Hashtable example to put object into Hashtable
        // put(key, value) is used to insert object into map
        companies.put("Google", "United States");
        companies.put("Nokia", "Finland");
        companies.put("Sony", "Japan");

        // Java Hashtable example to get Object from Hashtable
        // get(key) method is used to retrieve Objects from Hashtable
        companies.get("Google");

        // Hashtable containsKey Example
        // Use containsKey(Object) method to check if an Object exits as key in
        // hashtable
        System.out.println("Does hashtable contains Google as key: "
                + companies.containsKey("Google"));

        // Hashtable containsValue Example
        // just like containsKey(), containsValue returns true if hashtable
        // contains specified object as value
        System.out.println("Does hashtable contains Japan as value: "
                + companies.containsValue("Japan"));

        // Hashtable enumeration Example
        // hashtabl.elements() return enumeration of all hashtable values
        Enumeration enumeration = companies.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println("hashtable values: " + enumeration.nextElement());
        }

        // How to check if Hashtable is empty in Java
        // use isEmpty method of hashtable to check emptiness of hashtable in
        // Java
        System.out.println("Is companies hashtable empty: "
                + companies.isEmpty());

        // How to find size of Hashtable in Java
        // use hashtable.size() method to find size of hashtable in Java
        System.out.println("Size of hashtable in Java: " + companies.size());

        // How to get all values form hashtable in Java
        // you can use keySet() method to get a Set of all the keys of hashtable
        // in Java
        Set hashtableKeys = companies.keySet();

        // you can also get enumeration of all keys by using method keys()
        Enumeration hashtableKeysEnum = companies.keys();

        // How to get all keys from hashtable in Java
        // There are two ways to get all values from hash table first by using
        // Enumeration and second getting values ad Collection
        Enumeration hashtableValuesEnum = companies.elements();

        Collection hashtableValues = companies.values();

        // Hashtable clear example
        // by using clear() we can reuse an existing hashtable, it clears all
        // mappings.
        companies.clear();
    }
}
