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

/**
 * Classe para testar os exemplos de manipulação de arquivos que utiliza
 * informações de entrada vindas do usuário
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class ManipulacaoArquivosMain {

    public static void main(String[] args) {
        System.out.println("Escrita 1:");
        try {
            ManipulacaoArquivos fle = new ManipulacaoArquivos();

            fle.escreveInfo("c:/udesc/arquivoInfo.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\nEscrita 2:");
        try {
            new ManipulacaoArquivos().escreveOutputStreamB("c:/udesc/ujfcbvjgutjfchjgkutyfhgc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
