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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ManipulacaoArquivos da ManipulacaoArquivos
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class ManipulacaoArquivos {

    /**
     * Método de criação de diretório e subdiretório. Adicionalmente, realiza a
     * criação de um arquivo e mostra o caminho do diretório.
     *
     * @param dirRaiz Caminho do diretório raiz
     * @param subDir Nome do subdiretório
     * @throws IOException Lança uma exceção caso não consiga criar o arquivo
     * @throws Exception Lança uma exceção caso não consiga criar o diretório
     * raiz ou o subdiretório.
     */
    public void criaDiretorios(String dirRaiz, String subDir) throws IOException, Exception {
        File diretorioRaiz = new File(dirRaiz);

        // cria o diretório raiz. Se não conseguir retorna false
        if (!diretorioRaiz.mkdir()) {
            if (diretorioRaiz.exists()) {
                System.out.println("Diretório já criado. Ignorado criação...");
            } else {
                throw new Exception("Não foi possível criar o diretório raiz.");
            }
        }

        File subdir = new File(diretorioRaiz, subDir);

        // cria um subdiretório dentro do raiz caso ainda não foi criado
        if (!subdir.exists() && !subdir.mkdir()) {
            throw new Exception("Não foi possível criar um subdiretório dentro do diretório raiz.");
        }

        FileWriter f = new FileWriter(new File(diretorioRaiz, "arquivo.txt"));
        f.write("Hello World!");

        // Lista os arquivos de um diretório
        for (String arquivo : diretorioRaiz.list()) {
            File filho = new File(diretorioRaiz, arquivo);
            System.out.println("\nÉ um diretório? Resposta: " + filho.isDirectory());
            System.out.println(String.format("Caminho completo (absoluto): %s", filho.getAbsolutePath()));
            System.out.println(String.format("Caminho relativo: %s", filho));
        }

        f.close();
    }

    /**
     * Método para leitura de arquivo
     *
     * @param file Arquivo a ser lido (Nome + Path)
     */
    public void leArquivo(String file) {
        //String dir = "c:/udesc/arquivo.txt";

        System.out.println("Leitura 1: lendo os bytes");

        //Tipo 1
        try (Reader r = new FileReader(file)) {
            int c;
            // -1 representa fim do arquivo
            while ((c = r.read()) != -1) {
                System.out.println("Li o character: " + (char) c);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Arquivo não existe ou está inacessível.", ex);

        } catch (IOException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Erro de leitura", ex);
        }
    }

    /**
     * Método para leitura de arquivo usando BufferedReader
     *
     * @param file Arquivo a ser utilizado (Nome + Path)
     */
    public void leArquivoBuffer(String file) {
        try (BufferedReader buf = new BufferedReader(new FileReader(file))) {
            String linha;
            do {
                // Lê linha por linha
                linha = buf.readLine();
                System.out.println(linha == null ? "Fim da leitura do arquivo." : linha);
            } while (linha != null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Arquivo não existe ou está inacessível.", ex);

        } catch (IOException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Erro de leitura", ex);
        }
    }

    /**
     * Método para escrita utilizando informações do usuário
     *
     * @param file Arquivo a ser utilizado (Nome + Path)
     */
    public void escreveInfo(String file) {
        try (FileWriter out = new FileWriter(file)) {
            System.out.println("Digite um texto: \n");
            byte a;
            // Aguarda digitação do usuário
            while ((a = (byte) System.in.read()) != '\n') {
                out.write(a);
            }
        } catch (IOException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Erro de escrita", ex);
        }
    }

    /**
     * Método para escrita utilizando Buffer
     *
     * @param file Arquivo a ser utilizado (Nome + Path)
     */
    public void escreveInfoBuffer(String file) {
        // True realiza append.
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
            for (int i = 1; i <= 100; i++) {
                out.write(String.format("Esta é a linha %s do texto.\n", i));
            }
        } catch (IOException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Erro de escrita", ex);
        }
    }

    /**
     * Método de leitura de arquivo usando InputStream
     *
     * @param file Arquivo a ser utilizado (Nome + Path)
     */
    public void leInputStream(String file) {
        try (FileInputStream in = new FileInputStream(new File(file))) {
            System.out.println("Lendo o arquivo: " + file);
            int c;
            // -1 representa fim do arquivo
            while ((c = in.read()) != -1) {
                System.out.println("Li o character: " + (char) c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Arquivo não existe ou está inacessível.", ex);

        } catch (IOException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Erro de leitura", ex);
        }
    }

    /**
     * Método de escrita de arquivo usando OutputStream
     *
     * @param file Diretório onde o arquivo será salvo
     * @throws Exception
     */
    public void escreveOutputStream(String file) throws Exception {
        FileOutputStream out = null;

        try {
            File diretorioRaiz = new File(file);

            // cria o diretório raiz. Se não conseguir retorna false
            if (!diretorioRaiz.mkdir()) {
                if (diretorioRaiz.exists()) {
                    System.out.println("Diretório já criado. Ignorado criação...");
                } else {
                    System.out.println("Não foi possível criar o diretório raiz.");
                    return;
                }
            }

            File arquivo = new File(diretorioRaiz, "lixo.dat");
            out = new FileOutputStream(arquivo);
            out.write(new byte[]{'l', 'i', 'x', 'o'});
        } catch (IOException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Erro de escrita.", ex);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                Logger.getLogger(ManipulacaoArquivos.class
                        .getName()).log(Level.SEVERE, "Não foi possível fechar o arquivo.", e);
            }
        }
    }

    /**
     * Método de escrita de arquivo usando OutputStream (Segundo Exemplo)
     *
     * @param file Diretório onde o arquivo será salvo
     * @throws Exception
     */
    public void escreveOutputStreamB(String file) throws Exception {
        File diretorioRaiz = new File(file);

        // cria o diretório raiz. Se não conseguir retorna false
        if (!diretorioRaiz.mkdir()) {
            if (diretorioRaiz.exists()) {
                System.out.println("Diretório já criado. Ignorado criação...");
            } else {
                System.out.println("Não foi possível criar o diretório raiz.");
                return;
            }
        }

        try (FileOutputStream out = new FileOutputStream(new File(diretorioRaiz, "lixo.dat"))) {

            System.out.println("Digite um texto: \n");
            byte a;
            // Aguarda digitação do usuário
            while ((a = (byte) System.in.read()) != '\n') {
                out.write(a);
            }
        } catch (IOException ex) {
            Logger.getLogger(ManipulacaoArquivos.class
                    .getName()).log(Level.SEVERE, "Erro de escrita.", ex);
        }
    }

    /**
     * Método que contém maneiras mais simples de ler arquivos usando outras
     * formas.
     *
     * @param file Arquivo a ser utilizado (Nome + Path)
     */
    public void leArquivoEasyWays(String file) {
        try {
            // Carrega o caminho do arquivo em um objeto do tipo Path
            Path p = Paths.get(file);

            System.out.println("Leitura 1: convertendo as linhas do arquivo em lista");

            // Tipo 1
            List<String> linhasArquivo = Files.readAllLines(p);

            linhasArquivo.forEach((l) -> {
                System.out.println("Linha: " + l);
            });

            System.out.println("Leitura 2: convertendo as linhas do arquivo em Stream");

            // Tipo 2
            Files.lines(p).forEach(System.out::println);
        } catch (IOException ex) {
            Logger.getLogger(ManipulacaoArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
