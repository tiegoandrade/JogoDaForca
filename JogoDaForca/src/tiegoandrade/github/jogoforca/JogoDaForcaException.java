package tiegoandrade.github.jogoforca;

/**
 * Representa uma exceção genérica ocorrida no jogo
 */
public class JogoDaForcaException extends Exception {

	/**
	 * Construtor
	 * 
	 * @param message
	 *            Mensagem exibida caso ocorra alguma exceção
	 * @see Exception#Exception(String)
	 */
	public JogoDaForcaException(String message) {
		super(message);
	}

	/**
	 * Construtor
	 * 
	 * @param message
	 *            Mensagem exibida caso ocorra alguma exceção
	 * @param cause
	 *            Causa da exceção
	 * @see Exception#Exception(String, Throwable)
	 */
	public JogoDaForcaException(String message, Throwable cause) {
		super(message, cause);
	}
}
