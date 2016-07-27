package tiegoandrade.github.jogoforca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tiegoandrade.github.jogoforca.utils.MathUtils;

/**
 * Classe que permite ler as palavras disponíveis para o jogo e sortear uma
 * dessas palavras. Esta classe implementa o design pattern singleton.
 */
public class Dicionario {

	/** Constante do local do arquivo contendo as palavras */
	private static final String ARQUIVO_DICIONARIO = "dicionario.txt";

	/** Instância de Dicionario */
	private static Dicionario instance;

	/** Lista das palavras disponíveis para o sorteio */
	private List<String> palavras = new ArrayList<String>();

	/**
	 * Construtor que só poderá ser chamado por essa classe.
	 */
	private Dicionario() {

		// Carrega as palavras disponíveis na lista de palavras
		carregarPalavras();
	}

	/**
	 * Obtém a instância da classe
	 * 
	 * @return Retorna sempre a mesma instância da classe
	 */
	public static Dicionario getInstance() {
		if (instance == null) {
			instance = new Dicionario();
		}
		return instance;
	}

	/**
	 * Lê as palavras do arquivo e as coloca na lista de palavras
	 */
	private void carregarPalavras() {

		// Utiliza um scanner para ler as linhas do arquivo
		try (Scanner scanner = new Scanner(new File(ARQUIVO_DICIONARIO))) {

			/*
			 * Para cada linha do arquivo, adiciona a linha na lista de
			 * palavras.Este código considera que existe uma palavra por linha
			 */
			while (scanner.hasNextLine()) {
				palavras.add(scanner.nextLine().trim());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sorteia uma palavra para ser utilizada no jogo.
	 * 
	 * @return A palavra sorteada
	 * @throws JogoDaForcaException
	 *             Lança uma exceção caso nenhuma palavra tenha sido cadastrada
	 */
	public Palavra proximaPalavra() throws JogoDaForcaException {

		// Lança uma exceção se a lista de palavras estiver vazia.
		if (palavras.size() == 0) {
			throw new JogoDaForcaException("Nenhuma palavra foi encontrada");
		}

		// Gera um número randômico entre 0 e o tamanho da lista de palavras
		int pos = MathUtils.gerarNumeroRandomico(0, palavras.size());

		// Cria um objeto palavra utilizando a palavra sorteada
		Palavra palavra = new Palavra(palavras.get(pos));

		return palavra;
	}
}
