package tiegoandrade.github.jogoforca;

import java.util.HashSet;
import java.util.Set;
import tiegoandrade.github.jogoforca.utils.ConsoleUtils;

/**
 * Implementa a lógica de funcionamento do jogo
 */
public class Jogo {

	/**
	 * Constante que representa o número máximo de vezes que o usuário pode
	 * errar
	 */
	private static final int MAX_ERROS = 5;

	/**
	 * Método que inicia o jogo.
	 * 
	 * @throws JogoDaForcaException
	 */
	public void iniciar() throws JogoDaForcaException {

		// Conjunto que armazena as letras já informadas pelo usuário.
		Set<Character> letrasUsadas = new HashSet<Character>();

		// Número atual de erros do usuário.
		int erros = 0;

		// Pega uma instância da classe Dicionário.
		Dicionario dicionario = Dicionario.getInstance();

		// Sorteia a palavra que será usada no jogo da forca.
		Palavra palavra = dicionario.proximaPalavra();

		// Dá ao usuário algumas informações sobre o jogo.
		System.out.println("Bem vindo ao Jogo da Forca!");
		System.out.println("A palavra tem " + palavra.tamanho() + " letras");

		// Loop
		while (true) {

			// A linha abaixo chama o método toString() da classe Palavra
			System.out.println(palavra);
			System.out.println();

			// Variável que armazena uma caractere informada pelo usuário.
			char letra;

			try {

				/*
				 * Aplicativo pede que o usuário informe uma letra da palavra
				 * sorteada.
				 */
				System.out.print("Digite uma letra: ");

				// Recupera o caracter digitado no console pelo usuário.
				letra = ConsoleUtils.lerLetra();

				// Se ele já digitou esta letra anteriormente, lança uma
				// exceção.
				if (letrasUsadas.contains(letra)) {
					throw new CaractereInvalidoException(
							"Esta letra já foi utilizada");
				}

				// Adiciona a letra digita à lista de letras usadas.
				letrasUsadas.add(letra);

				// Verifica se a palavra possui a letra digitada.
				if (palavra.possuiLetra(letra)) {
					System.out.println("Você acertou uma letra!");
				} else {

					// Se não possuir, incrementa o número de erros
					erros++;

					/*
					 * Se o usuário não atingiu o número máximo de erros é
					 * exibida uma mensagem informando que ele errou e o número
					 * de vezes que ele ainda pode errar.
					 */
					if (erros < MAX_ERROS) {
						System.out.println("Você errou! Você ainda pode errar "
								+ (MAX_ERROS - erros) + " vez(es)");
					}
				}

				System.out.println();

				// Se acertou a palavra inteira, avisa o usuário e sai do jogo.
				if (palavra.acertouPalavra()) {
					System.out.println("Parabéns! Você acertou a palavra: "
							+ palavra.getPalavraOriginal());
					System.out.println("Fim do Jogo!");
					break;
				}

				/*
				 * Se atingiu o número máximo de erros, avisa o usuário e sai do
				 * jogo
				 */
				if (erros == MAX_ERROS) {
					System.out.println("Você perdeu! A palavra correta era "
							+ palavra.getPalavraOriginal());
					System.out.println("Fim do Jogo!");
					break;
				}

			} catch (CaractereInvalidoException e) {
				/*
				 * Se ocorrer alguma exceção, mostra a mensagem para o usuário e
				 * continua o loop
				 */
				System.out.println("Erro: " + e.getMessage());
				System.out.println();
			}
		}
	}
}
