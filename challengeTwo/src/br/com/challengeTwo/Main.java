package br.com.challengeTwo;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //recebe a string
        Scanner ler = new Scanner(System.in);
        String valor = "";
        Pattern pattern = Pattern.compile("[^a-z]");
        System.out.println("Entre com a String (a-z) : ");
        valor = ler.next();
        Matcher matcher = pattern.matcher(valor);

        if (valor.length() < 1 || valor.length() > 100000) {
            //verifica se a mesma é >= 1 <= 100 000
            System.out.println("Valor incorreto. Digite uma String com caracteres entre 1 e 100000");
        } else if (matcher.find()) {
            // verifica a expressão regular
            System.out.println("Valor incorreto. Digite apenas letras minusculas");
        } else {

            // separa em um array e alimenta um SET pra separar o total de caracteres diferentes
            char[] letras = valor.toCharArray();
            Set letrasDiferentes = new HashSet();

            for (int i = 0; i < letras.length; i++) {
                letrasDiferentes.add(letras[i]);
            }


            List<Integer> qtdDosConjuntosEncontrados = new ArrayList<>();


            List conjuntos = new ArrayList();

            String conjuntosConcatenados = "";

            for (int i = 0; i < letras.length; i++) {

                for (int j = i; j < letras.length; j++) {

                    conjuntosConcatenados = "";

                    for (int h = i; h <= j; h++) {

                        //separa os conjuntos
                        conjuntosConcatenados += letras[h];
                    }
                    //guarda is conjuntos
                    conjuntos.add(conjuntosConcatenados);
                    int cont = 0;
                    for (Object letra : letrasDiferentes) {
                        if (conjuntosConcatenados.contains(letra.toString())) {
                            cont++;
                        }
                        if (cont == letrasDiferentes.size()) {
                            //salva a qtd de cada conjunto que deu match.
                            qtdDosConjuntosEncontrados.add(conjuntosConcatenados.length());
                        }
                    }
                }
            }

            //apresenta o menor conjunto com os elementos da String.
            Collections.sort(qtdDosConjuntosEncontrados);
            System.out.println("O menor conjunto tem : " + qtdDosConjuntosEncontrados.get(0) + " posições");
        }
    }
}
