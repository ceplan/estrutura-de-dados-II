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

import java.util.ArrayList;
import java.util.Arrays;

public class HashFunction2 {

    String[] theArray;
    int arraySize;
    int itemsInArray = 0;

    public static void main(String[] args) {

        HashFunction2 theFunc = new HashFunction2(31);

        String[] elementsToAdd2 = {"100", "510", "170", "214", "268", "398",
            "235", "802", "900", "723", "699", "1", "16", "999", "890",
            "725", "998", "978", "988", "990", "989", "984", "320", "321",
            "400", "415", "450", "50", "660", "624"};

        // Demonstrate how data normally follows patterns and how
        // a non-prime sized array can cause havoc
        String[] elementsToAdd3 = {"30", "60", "90", "120", "150", "180",
            "210", "240", "270", "300", "330", "360", "390", "420", "450",
            "480", "510", "540", "570", "600", "989", "984", "320", "321",
            "400", "415", "450", "50", "660", "624"};

        theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);

        // theFunc.modThirty();
        theFunc.increaseArraySize(60);

        theFunc.displayTheStack();

        theFunc.fillArrayWithNeg1();

        theFunc.doubleHashFunc(elementsToAdd2, theFunc.theArray);

        theFunc.displayTheStack();

        theFunc.findKeyDblHashed("990");

    }

    // Outputs the matches that would put an item in
    // index 0 if arraySize was 31
    public void modThirty() {

        for (int i = 1; i < 999; i++) {

            if (i % 30 == 0) {

                System.out.println(i);

            }

        }

    }

    public boolean isPrime(int number) {

        // Eliminate the need to check versus even numbers
        if (number % 2 == 0) {
            return false;
        }

        // Check against all odd numbers
        for (int i = 3; i * i <= number; i += 2) {

            if (number % i == 0) {
                return false;
            }

        }

        // If we make it here we know it is odd
        return true;

    }

    // Receives a number and returns the next prime
    // number that follows
    public int getNextPrime(int minNumberToCheck) {

        for (int i = minNumberToCheck; true; i++) {

            if (isPrime(i)) {
                return i;
            }

        }

    }

    // Increase array size to a prime number
    public void increaseArraySize(int minArraySize) {

        // Get a prime number bigger than the array
        // requested
        int newArraySize = getNextPrime(minArraySize);

        // Move the array into a bigger array with the
        // larger prime size
        moveOldArray(newArraySize);

    }

    public void moveOldArray(int newArraySize) {

        // Create an array that has all of the values of
        // theArray, but no empty spaces
        String[] cleanArray = removeEmptySpacesInArray(theArray);

        // Increase the size for theArray
        theArray = new String[newArraySize];

        arraySize = newArraySize;

        // Fill theArray with -1 in every space
        fillArrayWithNeg1();

        // Send the values previously in theArray into
        // the new larger array
        hashFunction2(cleanArray, theArray);

    }

    // Will remove all empty spaces in an array
    public String[] removeEmptySpacesInArray(String[] arrayToClean) {

        ArrayList<String> stringList = new ArrayList<String>();

        // Cycle through the array and if a space doesn't
        // contain -1, or isn't empty add it to the ArrayList
        for (String theString : arrayToClean) {
            if (!theString.equals("-1") && !theString.equals("")) {
                stringList.add(theString);
            }
        }

        return stringList.toArray(new String[stringList.size()]);

    }

    public void doubleHashFunc(String[] stringsForArray, String[] theArray) {

        for (int n = 0; n < stringsForArray.length; n++) {

            // Store value in array index
            String newElementVal = stringsForArray[n];

            // Create an index to store the value in by taking
            // the modulus
            int arrayIndex = Integer.parseInt(newElementVal) % arraySize;

            // Get the distance to skip down in the array
            // after a collision occurs. We are doing this
            // rather than just going to the next index to
            // avoid creating clusters
            int stepDistance = 7 - (Integer.parseInt(newElementVal) % 7);

            System.out.println("step distance: " + stepDistance);

            /*
			 * System.out.println("Modulus Index= " + arrayIndex + " for value "
			 * + newElementVal);
             */
            // Cycle through the array until we find an empty space
            while (theArray[arrayIndex] != "-1") {

                arrayIndex += stepDistance;

                // System.out.println("Collision Try " + arrayIndex +
                // " Instead");
                // If we get to the end of the array go back to index 0
                arrayIndex %= arraySize;

            }

            theArray[arrayIndex] = newElementVal;

        }

    }

    // Returns the value stored in the Double Hashed Hash Table
    public String findKeyDblHashed(String key) {

        // Find the keys original hash key
        int arrayIndexHash = Integer.parseInt(key) % arraySize;

        // Find the keys original step distance
        int stepDistance = 5 - (Integer.parseInt(key) % 5);

        while (theArray[arrayIndexHash] != "-1") {

            if (theArray[arrayIndexHash] == key) {

                // Found the key so return it
                System.out.println(key + " was found in index "
                        + arrayIndexHash);

                return theArray[arrayIndexHash];

            }

            // Look in the next index
            arrayIndexHash += stepDistance;

            // If we get to the end of the array go back to index 0
            arrayIndexHash %= arraySize;

        }

        // Couldn't locate the key
        return null;

    }

    public void hashFunction2(String[] stringsForArray, String[] theArray) {

        for (int n = 0; n < stringsForArray.length; n++) {

            String newElementVal = stringsForArray[n];

            // Create an index to store the value in by taking
            // the modulus
            int arrayIndex = Integer.parseInt(newElementVal) % arraySize;

            /*
			 * 
			 * System.out.println("Modulus Index= " + arrayIndex + " for value "
			 * + newElementVal);
             */
            // Cycle through the array until we find an empty space
            while (theArray[arrayIndex] != "-1") {

                ++arrayIndex;

                // System.out.println("Collision Try " + arrayIndex +
                // " Instead");
                // If we get to the end of the array go back to index 0
                arrayIndex %= arraySize;

            }

            theArray[arrayIndex] = newElementVal;

        }

    }

    // Returns the value stored in the Hash Table
    public String findKey(String key) {

        // Find the keys original hash key
        int arrayIndexHash = Integer.parseInt(key) % arraySize;

        while (theArray[arrayIndexHash] != "-1") {

            if (theArray[arrayIndexHash] == key) {

                // Found the key so return it
                System.out.println(key + " was found in index "
                        + arrayIndexHash);

                return theArray[arrayIndexHash];

            }

            // Look in the next index
            ++arrayIndexHash;

            // If we get to the end of the array go back to index 0
            arrayIndexHash %= arraySize;

        }

        // Couldn't locate the key
        return null;

    }

    HashFunction2(int size) {

        arraySize = size;

        theArray = new String[size];

        // Fill Array with -1 for each empty space
        fillArrayWithNeg1();

    }

    public void fillArrayWithNeg1() {

        Arrays.fill(theArray, "-1");

    }

    public void displayTheStack() {

        int increment = 0;

        int numberOfRows = (arraySize / 10) + 1;

        for (int m = 0; m < numberOfRows; m++) {

            increment += 10;

            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                System.out.format("| %3s " + " ", n);

            }

            System.out.println("|");

            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                if (n >= arraySize) {
                    System.out.print("|      ");
                } else if (theArray[n].equals("-1")) {
                    System.out.print("|      ");
                } else {
                    System.out
                            .print(String.format("| %3s " + " ", theArray[n]));
                }

            }

            System.out.println("|");

            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }

            System.out.println();

        }

    }

}
