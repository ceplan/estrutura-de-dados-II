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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.prova01;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Gabarito da Questão 10 da Prova 01
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class Prova01 {

    public static void main(String[] args) {
        try {
            // Leitura de arquivo texto
            FileReader arquivo = new FileReader("entrada.txt");
            BufferedReader entrada = new BufferedReader(arquivo);
            String linha = entrada.readLine();

            // Escrita de arquivo binário
            FileOutputStream saida = new FileOutputStream("saida.bin");

            for (int i = 0; i < linha.length(); i++) {
                saida.write(linha.charAt(i));
            }
            entrada.close();
            saida.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e);
        }
    }
}
