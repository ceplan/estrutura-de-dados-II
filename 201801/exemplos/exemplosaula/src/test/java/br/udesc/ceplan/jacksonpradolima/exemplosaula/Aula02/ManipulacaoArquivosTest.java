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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.Aula02;

import br.udesc.ceplan.jacksonpradolima.exemplosaula.aula02.ManipulacaoArquivos;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * Casos de teste para testar os exemplos de manipulação de arquivos
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class ManipulacaoArquivosTest {

    @Test
    @Ignore
    public void criaDiretoriosTest() {
        try {
            ManipulacaoArquivos fle = new ManipulacaoArquivos();

            fle.criaDiretorios("c:/udesc", "subDir");

            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void leArquivoTest() {
        try {
            ManipulacaoArquivos fle = new ManipulacaoArquivos();

            fle.leArquivo("c:/udesc/arquivo.txt");

            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void leArquivoBufferTest() {
        try {
            ManipulacaoArquivos fle = new ManipulacaoArquivos();

            fle.leArquivoBuffer("c:/udesc/arquivo.txt");

            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void escreveInfoBufferTest() {
        try {
            ManipulacaoArquivos fle = new ManipulacaoArquivos();

            fle.escreveInfoBuffer("c:/udesc/arquivoInfoBuff.txt");

            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void leInputStreamTest() {
        try {
            ManipulacaoArquivos fle = new ManipulacaoArquivos();
            
            System.out.println("=================================");
            fle.leInputStream("c:/udesc/arquivoInfo.txt");
            
            System.out.println("\n\n\n=================================");
            fle.leInputStream("c:/udesc/arquivoInfoBuff.txt");
            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
            e.printStackTrace();
        }
    }

    @Test
    @Ignore
    public void escreveOutputStreamTest() {
        try {
            ManipulacaoArquivos fle = new ManipulacaoArquivos();

            fle.escreveOutputStream("c:/udesc/arquivoOut");

            assertTrue(true);
        } catch (Exception e) {
            assertTrue(false);
            e.printStackTrace();
        }
    }
}
