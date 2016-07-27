package tiegoandrade.github.jogoforca;

/**
 * Exceçao que indica que o caractere digitado é inválido.
 */
public class CaractereInvalidoException extends JogoDaForcaException {

	/**
	 * Construtor
	 * 
	 * @param message
	 *            Mensagem que será mostrada ao usuário caso haja algum erro.
	 * 
	 * @see JogoDaForcaException#JogoDaForcaException(String)
	 * 
	 */
	public CaractereInvalidoException(String message) {
		super(message);
	}
}