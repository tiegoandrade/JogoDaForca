package tiegoandrade.github.jogoforca;

/**
 * Representa uma exce��o gen�rica ocorrida no jogo
 */
public class JogoDaForcaException extends Exception {

	/**
	 * Construtor
	 * 
	 * @param message
	 *            Mensagem exibida caso ocorra alguma exce��o
	 * @see Exception#Exception(String)
	 */
	public JogoDaForcaException(String message) {
		super(message);
	}

	/**
	 * Construtor
	 * 
	 * @param message
	 *            Mensagem exibida caso ocorra alguma exce��o
	 * @param cause
	 *            Causa da exce��o
	 * @see Exception#Exception(String, Throwable)
	 */
	public JogoDaForcaException(String message, Throwable cause) {
		super(message, cause);
	}
}
