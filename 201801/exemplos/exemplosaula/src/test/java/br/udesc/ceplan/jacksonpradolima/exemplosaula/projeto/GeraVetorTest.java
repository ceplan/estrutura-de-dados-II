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

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class GeraVetorTest {

    @Test
    public void testRandom() {
        System.out.println("Testando: random");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.random(10)));
        assertArrayEquals(g.random(10), g.random(10));
    }

    @Test
    public void testNearSort() {
        System.out.println("Testando: nearSort");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.nearSort(10)));
        assertTrue(true);
    }

    @Test
    public void testFewUnique() {
        System.out.println("Testando: fewUnique");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.fewUnique(10)));
        assertTrue(true);
    }

    @Test
    public void testReversed() {
        System.out.println("Testando: reversed");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.reversed(10)));
        assertArrayEquals(g.reversed(10), g.reversed(10));
    }

    @Test
    public void testSort() {
        System.out.println("Testando: sort");
        GeraVetor g = new GeraVetor();
        System.out.println(Arrays.toString(g.sort(10)));
        assertArrayEquals(g.sort(10), g.sort(10));
    }
}
