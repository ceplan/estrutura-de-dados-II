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
package br.udesc.ceplan.jacksonpradolima.exemplosaula.aula07;

import java.util.Map; // importando a interface Map
import java.util.HashMap; //classe para utilização da interface

/*
Mais detalhes:
- https://www.devmedia.com.br/utilizando-map-para-armazenar-arrays/22493
- https://www.devmedia.com.br/conhecendo-a-interface-map-do-java/37463
*/
public class Mapas {

    public static void main(String[] args) {
        /* Criação do Map, onde o mesmo irá utilizar como chave o nome da empresa para mapear as                                                         informações, que estarão em um Array de Object*/

        Map<String, Object[]> mapa = new HashMap<String, Object[]>();

        /* As informações são passadas através de Arrays de Strings, cada Array contém uma informação                                                    específica.*/
        String[] localizacao = {"endereco", "cnpj", "cidade", "estado"};
        String[] setores = {"vendas", "comercial", "suporte"};
        String[] funcionarios = {"Alberto", "Henrique", "Ana"};
        String[] projetos = {"projeto1", "projeto2", "projeto3"};

        //É criado uma variável para armazenar os objetos (cada array é um objeto)
        Object[] informacoes = {localizacao, setores, funcionarios, projetos};

        mapa.put("Empresa", informacoes); // é feito o mapeamento entre a empresa e seus dados

        // Os dados foram mapeados, vamos ver como recuperá-los.
        /* é criado um array de Object para recuperar os dados mapeados, observe que no método get de                                                 HashMap é passado o parâmetro "Empresa". Será retornado as informações que estão mapeadas com                                         a empresa passada como parâmetro. Se vc tivesse passado como parâmetro a empresa "IBM" e                                                     existisse um mapeamento para essa empresa, as informações sobre a IBM retornariam no Array                                                     recDados*/
        Object[] recDados = mapa.get("Empresa");

        for (int i = 0; i < recDados.length; i++) // array para iterar entre as informações
        {

            // switch utilizado para exibir a informação que está sendo impressa.
            switch (i) {
                case 0:
                    System.out.println("Localização: ");
                    break;
                case 1:
                    System.out.println("Setores: ");
                    break;
                case 2:
                    System.out.println("Funcionários: ");
                    break;
                case 3:
                    System.out.println("Projetos: ");
                    break;
            }
            /*Como o array recDados é do tipo Object e eu tenho a informação que ele armazena array                                                                de strings, eu devo fazer um Cast para String[]*/

            for (String s : (String[]) recDados[i]) {
                System.out.println(s); // imprime o item para cada array de strings
            }

            System.out.println(); // espaço após terminar a impressão da informação
        }

    }
}
