package System;

import models.Tabuleiro;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private char jogadorAtual;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        jogadorAtual = 'X'; // Começa com o jogador X
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        while (!tabuleiro.jogoTerminou() && !tabuleiro.jogoEmpatado()) {
            tabuleiro.exibirTabuleiro();
            
            try {
            	System.out.println("Jogador " + jogadorAtual + ", digite a linha que deseja jogar (0-2):");
                linha = scanner.nextInt();
                System.out.println("Jogador " + jogadorAtual + ", digite a linha que deseja jogar (0-2):");
                coluna = scanner.nextInt();

                if (tabuleiro.jogadaValida(linha, coluna)) {
                    tabuleiro.fazerJogada(linha, coluna, jogadorAtual);
                    if (tabuleiro.jogoTerminou()) {
                        tabuleiro.exibirTabuleiro();
                        System.out.println("Jogador " + jogadorAtual + " venceu!");
                        break;
                    }
                    trocarJogador();
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro ao processar sua jogada. Certifique-se de inserir números inteiros.");
                scanner.nextLine();
            }
        }

        if (tabuleiro.jogoEmpatado()) {
            tabuleiro.exibirTabuleiro();
            System.out.println("Jogo empatado!");
        }

        scanner.close();
    }

    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.jogar();
    }
}