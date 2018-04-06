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

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

/**
 * Exemplo de parser dos parâmetros usando Argparse4jMain. Para verificar o teste
 * veja o arquivo Argparse4jMainTest.
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class Argparse4jMain {

    public static void main(String[] args) {
        ArgumentParser parser = ArgumentParsers.newFor("Argparse4jMain").build()
                .defaultHelp(true)
                .description("Exemplo do professor para fazer um parser dos parâmetros.");
        parser.addArgument("-s", "--save")
                .choices("S", "N").setDefault("S")
                .help("Salvar o arquivo em CSV?");
        parser.addArgument("file").nargs("*")
                .help("Arquivo para ler"); //Aceita mais que um arquivo
        Namespace ns = null;
        try {
            ns = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }
        System.out.println("Você forneceu as seguintes informações: ");
        System.out.println("Salvar? Resposta: " + ns.getString("save"));
        System.out.println("Arquivo(s)");

        for (String name : ns.<String>getList("file")) {
            System.out.println(name);
        }
    }
}
