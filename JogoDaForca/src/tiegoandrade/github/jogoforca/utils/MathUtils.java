package tiegoandrade.github.jogoforca.utils;

/**
 * Métodos utilitários relacionados à matemática
 */
public class MathUtils {

	/**
	 * Gera um número randômico entre min (inclusive) e max.
	 * 
	 * @param min
	 *            Valor mínimo do intervalo
	 * @param max
	 *            Valor máximo do intervalo
	 * @return Número randômico gerado
	 */
	public static int gerarNumeroRandomico(int min, int max) {
		int intervalo = max - min;
		return (int) (Math.random() * intervalo) + min;
	}

}
