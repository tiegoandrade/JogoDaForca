package tiegoandrade.github.jogoforca.utils;

/**
 * M�todos utilit�rios relacionados � matem�tica
 */
public class MathUtils {

	/**
	 * Gera um n�mero rand�mico entre min (inclusive) e max.
	 * 
	 * @param min
	 *            Valor m�nimo do intervalo
	 * @param max
	 *            Valor m�ximo do intervalo
	 * @return N�mero rand�mico gerado
	 */
	public static int gerarNumeroRandomico(int min, int max) {
		int intervalo = max - min;
		return (int) (Math.random() * intervalo) + min;
	}

}
