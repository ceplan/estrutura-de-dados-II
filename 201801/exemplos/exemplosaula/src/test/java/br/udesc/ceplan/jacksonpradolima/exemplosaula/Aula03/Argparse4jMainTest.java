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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.Aula03;

import br.udesc.ceplan.jacksonpradolima.exemplosaula.aula03.Argparse4jMain;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class Argparse4jMainTest {

    @Test
    @Ignore
    public void testHelp() {
        try {
            Argparse4jMain.main(new String[]{"-h"});
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @Ignore
    public void testFile() {

        try {
            String filename = System.getProperty("user.dir") + "\\agenda.dat";
            Argparse4jMain.main(new String[]{"teste.h", filename});
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @Ignore
    public void testAll() {

        try {
            String filename = System.getProperty("user.dir") + "/agenda.dat";
            Argparse4jMain.main(new String[]{"-s", "S", "teste.h", filename});
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
