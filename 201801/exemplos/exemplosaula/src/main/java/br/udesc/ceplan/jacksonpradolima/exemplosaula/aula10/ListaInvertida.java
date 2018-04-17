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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.aula10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Exemplo de lista invertida
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class ListaInvertida {

    public static void main(String args[]) {
        HashMap<String, List<String>> indice;
        indice = new HashMap<>();

        File file = new File("src\\main\\resources\\listaInvertida");
        String[] listaArquivos = file.list();

        // Para cada arquivo no diretório
        for (String arquivo : listaArquivos) {
            // Arquivo atual
            File fileAux = new File(file.getAbsoluteFile() + "\\" + arquivo);

            // Mostra o arquivo atual
            System.out.println("Arquivo: " + fileAux.getAbsolutePath());

            // Verifica se é um arquivo ou um diretório
            if (fileAux.isFile()) {
                try {
                    // Lê o arquivo
                    try (BufferedReader bufferedReaderIn = new BufferedReader(new FileReader(fileAux))) {
                        // Lê linha por linha
                        String linha = bufferedReaderIn.readLine();

                        do {
                            System.out.println("Linha: " + linha);

                            // Separa todas as palavras contidas na linhas
                            String[] palavras = linha.split(" ");

                            // Analisa cada palavra
                            for (String palavraChave : palavras) {
                                // converte para minúsculo
                                palavraChave = palavraChave.toLowerCase();
                                System.out.println("Palavra: " + palavraChave);

                                // Busca a palavra no índice de arquivos
                                List<String> indiceArquivos = indice.get(palavraChave);
                                System.out.println("Palavra no indice: " + indiceArquivos);

                                // se não haver nada no índice, prepara para adicionar a nova palavra
                                if (indiceArquivos == null) {
                                    indiceArquivos = new ArrayList<>();
                                    indice.put(palavraChave, indiceArquivos);
                                }

                                // adicionar no índice de arquivos
                                indiceArquivos.add(arquivo);

                            }
                            linha = bufferedReaderIn.readLine();
                        } while (linha != null);
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Indices Criados: " + indice.toString());

        // Lista de itens a serem encontrados
        List<String> buscas = new ArrayList<>();
        buscas.add("santa");
        buscas.add("norte");
        buscas.add("de");
        buscas.add("disciplina");
        buscas.add("udesc");

        // Usando forma funcional ao invés de "for (String busca : buscas)"
        buscas.forEach((busca) -> {
            List<String> encontrados = indice.get(busca);

            System.out.println(encontrados == null
                    ? (busca + ": não encontrada")
                    : (busca + ": " + encontrados.toString()));

        });
    }
}
