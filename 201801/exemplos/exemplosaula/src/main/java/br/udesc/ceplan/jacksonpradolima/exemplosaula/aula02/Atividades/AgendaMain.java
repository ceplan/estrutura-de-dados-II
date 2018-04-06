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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.aula02.atividades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Classe principal para manipulação da agenda
 *
 * @author Jackson Antonio do Prado Lima <jacksonpradolima at gmail.com>
 */
public class AgendaMain {

    public static void main(String[] args) {
        // Local onde vou salvar a agenda
        String filename = System.getProperty("user.dir") + "\\agenda.dat";

        // Variável que irá conter as informações de vários registros da agenda
        ArrayList<Agenda> agenda = new ArrayList<>();

        // Carrega os dados para manipulação
        try {
            agenda = read(filename);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Erro na leitura do arquivo.");
        }

        System.out.println("Bem vindo à sua agenda pessoal!");

        // Variável para ler as entradas do usuário
        Scanner scanner = new Scanner(System.in);

        int option = 0;

        // Menu para o usuário escolher o que desejar fazer
        do {
            System.out.println("\n\nO que deseja realizar? (Digite um número)\n\n1-Consultar\n2-Inserir\n3-Deletar\n4-Alterar\n5-Sair\n\nOpção: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                // Limpa o console pra próxima entrada
                scanner.nextLine();
                switch (option) {
                    case 1:
                        find(agenda, scanner);
                        break;
                    case 2:
                        insert(agenda, scanner);
                        break;
                    case 3:
                        delete(agenda, scanner);
                        break;
                    case 4:
                        edit(agenda, scanner);
                        break;
                    case 5:
                        // Antes de sair, salva o "estado" da agenda
                        try {
                            save(filename, agenda);
                        } catch (IOException ex) {
                            System.err.println("Erro ao salvar arquivo.");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } else {
                System.out.println("Por favor, informe um dígito.");
                scanner.next();
            }
        } while (option != 5);
    }

    /**
     * Consulta a agenda
     *
     * @param agenda Agenda
     * @param scanner Scanner
     */
    public static void find(ArrayList<Agenda> agenda, Scanner scanner) {
        System.out.println("Digite o nome que deseja consultar:");
        String nome = scanner.nextLine();

        // Filtro a lista e transformo o resultado em um List
        List<Agenda> filtro = agenda.stream()
                .filter(f -> f.getNome().contains(nome))
                .collect(Collectors.toList());

        System.out.println(String.format("A busca retornou %s registro(s). \nResultado da busca:\n", filtro.size()));

        // Mostro os registros que encontrei 
        filtro.forEach((registro) -> {
            System.out.println(registro.toString());
        });

        System.out.println("\n\nPressione uma tecla pra continuar.");
        try {
            // Espero que o usuário pressione alguma tecla
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(AgendaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Insere um registro na agenda
     *
     * @param agenda Agenda
     * @param scanner Scanner
     */
    public static void insert(ArrayList<Agenda> agenda, Scanner scanner) {
        // Crio uma nova variável (registro) da agenda a ser salva na Lista da Agenda
        Agenda registro = new Agenda();

        // Leio o nome
        System.out.println("Digite um nome:");
        String nome = scanner.nextLine();
        registro.setNome(nome);

        // Leio o telefone
        System.out.println("Digite um telefone:");
        int telefone = scanner.nextInt();
        registro.setTelefone(telefone);

        // Limpo o console por causa do "int"
        scanner.nextLine();

        // Leio o e-mail
        System.out.println("Digite um e-mail:");
        String email = scanner.nextLine();
        registro.setEmail(email);

        // Salvo o novo registro na agenda
        agenda.add(registro);
    }

    /**
     * Deleta um registro da agenda
     *
     * @param agenda Agenda
     * @param scanner Scanner
     */
    public static void delete(ArrayList<Agenda> agenda, Scanner scanner) {
        System.out.println("Digite o nome que deseja deletar:");
        String nome = scanner.nextLine();

        // Filtro a lista e transformo o resultado em um List
        List<Agenda> filtro = agenda.stream()
                .filter(f -> f.getNome().contains(nome))
                .collect(Collectors.toList());

        System.out.println(String.format("A busca retornou %s registro(s).", filtro.size()));
        System.out.println("\n\nRemovendo apenas o primeiro...");

        agenda.remove(filtro.stream().findFirst().get());

        System.out.println("\nRemovido!");
    }

    /**
     * Edita um registro da agenda
     *
     * @param agenda Agenda
     * @param scanner Scanner
     */
    public static void edit(ArrayList<Agenda> agenda, Scanner scanner) {
        System.out.println("Digite o nome que deseja editar:");
        String filter = scanner.nextLine();

        // Filtro a lista e transformo o resultado em um ArrayList
        ArrayList<Agenda> filtro = agenda.stream()
                .filter(f -> f.getNome().contains(filter))
                .collect(Collectors.toCollection(ArrayList::new));

        // Pego o primeiro registro da lista
        Agenda registro = filtro.stream().findFirst().get();
        agenda.remove(registro);

        System.out.println(String.format("A busca retornou %s registro(s). Vamos editar apenas o primeiro registro: %s",
                filtro.size(),
                registro.toString()));

        int option = 0;

        do {
            System.out.println("O que deseja editar? (Digite um número)\n\n1-Nome\n2-Telefone\n3-E-mail\n4-Sair\n\nOpção: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Digite um nome:");
                        String nome = scanner.nextLine();
                        registro.setNome(nome);
                        break;
                    case 2:
                        System.out.println("Digite um telefone:");
                        int telefone = scanner.nextInt();
                        registro.setTelefone(telefone);
                        break;
                    case 3:
                        System.out.println("Digite um e-mail:");
                        String email = scanner.nextLine();
                        registro.setNome(email);
                        break;
                    case 4:
                        agenda.add(registro);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } else {
                System.out.println("Por favor, informe um dígito.");
                scanner.next();
            }
        } while (option != 4);
    }

    /**
     * Lê a agenda salva em disco
     *
     * @param filename Nome do arquivo
     * @return Agenda
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Agenda> read(String filename) throws IOException, ClassNotFoundException {
        ArrayList<Agenda> agenda = new ArrayList<>();

        File arquivo = new File(filename);

        // Se o arquivo já existe, ou seja, já salvei antes, então eu leio
        if (arquivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
                agenda.addAll((List<Agenda>) ois.readObject());
            }
        } else {
            // Senão crio um novo arquivo onde vou salvar depois
            arquivo.createNewFile();
        }

        return agenda;
    }

    /**
     * Salva a agenda em disco
     *
     * @param agenda Agenda
     * @param filename Nome do arquivo
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void save(String filename, ArrayList<Agenda> agenda) throws FileNotFoundException, IOException {
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filename))) {
            objOut.writeObject(agenda);
        }
    }
}
