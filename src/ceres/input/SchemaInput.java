package ceres.input;

import java.io.File;

public class SchemaInput {

    public SchemaInput() {
    }


    /**
     * 
     * Método como objetivo de reduzir a entropia nas linhas de entrada de dados,
     * retornando linhas que possuam organização lógica.<br />
     * @version 1.0
     * <br />
     * @param String - frase
     * @param char - oldChar
     * @param char - newChar
     * @return String - Frase normalizada
     * <br /><br />
     * Exemplo:
     * <br />
     *      <ul>
     *      <li>Frase de entrada: "O@@Homem@tem@muitos@@@@carros@na@@@garagem"</li>
     *      <li>Caracter causador da desorganizador: "@"</li>
     *      <li>Caracter substituto escolhido: "#"</li>
     *      <li>Retorno usando a função replace: "O##Homem#tem#muitos####carros#na####garagem"</li>
     *      <li>Retorno da função <b><i>normalizar</i></b> : "#O#Homem#tem#muitos#carros#na#garagem#"</li>
     *      </ul>
     * 
     */
    public String normalizar(String frase, char oldChar, char newChar) {
        int firstIndex = 0;
        int lastIndex = 1;
        String contLastNewChar = "falso";
        String resultado = "" + newChar + "";
        String newfrase = frase.replace(oldChar, newChar);
        newfrase += newChar;
        for (int i = 0; i < newfrase.length(); i++) {
            char c = newfrase.charAt(i);
            if (c != newChar) {
                if (contLastNewChar.equals("verdadeiro")) {
                    contLastNewChar = "falso";
                    lastIndex = i + 2;
                    firstIndex = i;
                } else {
                    lastIndex += 1;
                }
            } else {
                if (!contLastNewChar.equals("verdadeiro")) {
                    try {
                        resultado += newfrase.substring(firstIndex, lastIndex);
                    } catch (Exception ex) {
                        System.out.println("[ERRO] Erro no processo de normalização: " + ex);
                    }
                    contLastNewChar = "verdadeiro";
                }
            }
        }
        return resultado;
    }
}