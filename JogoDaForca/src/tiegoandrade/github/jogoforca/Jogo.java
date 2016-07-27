package tiegoandrade.github.jogoforca;

import java.util.HashSet;
import java.util.Set;
import tiegoandrade.github.jogoforca.utils.ConsoleUtils;

/**
 * Implementa a l�gica de funcionamento do jogo
 */
public class Jogo {

	/**
	 * Constante que representa o n�mero m�ximo de vezes que o usu�rio pode
	 * errar
	 */
	private static final int MAX_ERROS = 5;

	/**
	 * M�todo que inicia o jogo.
	 * 
	 * @throws JogoDaForcaException
	 */
	public void iniciar() throws JogoDaForcaException {

		// Conjunto que armazena as letras j� informadas pelo usu�rio.
		Set<Character> letrasUsadas = new HashSet<Character>();

		// N�mero atual de erros do usu�rio.
		int erros = 0;

		// Pega uma inst�ncia da classe Dicion�rio.
		Dicionario dicionario = Dicionario.getInstance();

		// Sorteia a palavra que ser� usada no jogo da forca.
		Palavra palavra = dicionario.proximaPalavra();

		// D� ao usu�rio algumas informa��es sobre o jogo.
		System.out.println("Bem vindo ao Jogo da Forca!");
		System.out.println("A palavra tem " + palavra.tamanho() + " letras");

		// Loop
		while (true) {

			// A linha abaixo chama o m�todo toString() da classe Palavra
			System.out.println(palavra);
			System.out.println();

			// Vari�vel que armazena uma caractere informada pelo usu�rio.
			char letra;

			try {

				/*
				 * Aplicativo pede que o usu�rio informe uma letra da palavra
				 * sorteada.
				 */
				System.out.print("Digite uma letra: ");

				// Recupera o caracter digitado no console pelo usu�rio.
				letra = ConsoleUtils.lerLetra();

				// Se ele j� digitou esta letra anteriormente, lan�a uma
				// exce��o.
				if (letrasUsadas.contains(letra)) {
					throw new CaractereInvalidoException(
							"Esta letra j� foi utilizada");
				}

				// Adiciona a letra digita � lista de letras usadas.
				letrasUsadas.add(letra);

				// Verifica se a palavra possui a letra digitada.
				if (palavra.possuiLetra(letra)) {
					System.out.println("Voc� acertou uma letra!");
				} else {

					// Se n�o possuir, incrementa o n�mero de erros
					erros++;

					/*
					 * Se o usu�rio n�o atingiu o n�mero m�ximo de erros �
					 * exibida uma mensagem informando que ele errou e o n�mero
					 * de vezes que ele ainda pode errar.
					 */
					if (erros < MAX_ERROS) {
						System.out.println("Voc� errou! Voc� ainda pode errar "
								+ (MAX_ERROS - erros) + " vez(es)");
					}
				}

				System.out.println();

				// Se acertou a palavra inteira, avisa o usu�rio e sai do jogo.
				if (palavra.acertouPalavra()) {
					System.out.println("Parab�ns! Voc� acertou a palavra: "
							+ palavra.getPalavraOriginal());
					System.out.println("Fim do Jogo!");
					break;
				}

				/*
				 * Se atingiu o n�mero m�ximo de erros, avisa o usu�rio e sai do
				 * jogo
				 */
				if (erros == MAX_ERROS) {
					System.out.println("Voc� perdeu! A palavra correta era "
							+ palavra.getPalavraOriginal());
					System.out.println("Fim do Jogo!");
					break;
				}

			} catch (CaractereInvalidoException e) {
				/*
				 * Se ocorrer alguma exce��o, mostra a mensagem para o usu�rio e
				 * continua o loop
				 */
				System.out.println("Erro: " + e.getMessage());
				System.out.println();
			}
		}
	}
}
