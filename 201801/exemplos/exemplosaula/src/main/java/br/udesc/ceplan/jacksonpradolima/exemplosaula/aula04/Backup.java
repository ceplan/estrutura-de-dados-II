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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.aula04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Exemplos de backup
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class Backup {

    /**
     * Forma complexa de backup
     * @param filename Arquivo qual será realizado backup
     * @param data Dados que serão armazenados no arquivo antigo
     * @throws IOException
     */
    public static void saveWithBackup(String filename, String... data) throws IOException {
        Path file = Paths.get(filename).toRealPath();
        File backFile = new File(filename + ".backup");
        if (!backFile.exists()) {
            // garante que teremos um arquivo de backup, então podemos manipular o arquivo original
            backFile.createNewFile();
        }
        Path back = Paths.get(filename + ".backup").toRealPath();
        
        // Move as informações de um arquivo para outro
        Files.move(file, back, StandardCopyOption.REPLACE_EXISTING);
        
        // Salva novas informações no arquivo original
        try (PrintWriter out = new PrintWriter(file.toFile())) {
            for (int i = 0; i < data.length; i++) {
                out.print(data[i]);
                if (i < data.length - 1) {
                    out.println();
                }
            }
        }
    }

    /**
     * Forma básica de backup
     * @param filename Arquivo que será realizado backup
     * @throws IOException
     */
    public static void easyBackup(String filename) throws IOException {
        Path file = Paths.get(filename).toRealPath();
        File backFile = new File(filename + ".backup");
        
        // Faz uma cópia do arquivo
        Files.copy(file, backFile.toPath());
    }
}
