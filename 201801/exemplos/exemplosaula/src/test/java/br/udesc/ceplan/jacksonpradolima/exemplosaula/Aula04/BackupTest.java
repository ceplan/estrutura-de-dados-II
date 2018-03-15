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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.Aula04;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class BackupTest {

    @Test
    @Ignore
    public void test1() {
        try {
            Backup.saveWithBackup("C:\\Users\\Prado Lima\\Documents\\github\\estrutura-de-dados-II\\201801\\README.md", "test", "aa");
            assertTrue(true);
        } catch (IOException ex) {
            Logger.getLogger(BackupTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }

    @Test
    @Ignore
    public void test2() {
        try {
            Backup.saveWithBackup("C:\\Users\\Prado Lima\\Documents\\github\\estrutura-de-dados-II\\201801\\README.md");
            assertTrue(true);
        } catch (IOException ex) {
            Logger.getLogger(BackupTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }

    @Test
    public void test3() {
        try {
            Backup.easyBackup("C:\\Users\\Prado Lima\\Documents\\github\\estrutura-de-dados-II\\201801\\README.md");
            assertTrue(true);
        } catch (IOException ex) {
            Logger.getLogger(BackupTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }

}
