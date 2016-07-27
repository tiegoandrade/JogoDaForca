package tiegoandrade.github.jogoforca;

/**
 * Exce�ao que indica que o caractere digitado � inv�lido.
 */
public class CaractereInvalidoException extends JogoDaForcaException {

	/**
	 * Construtor
	 * 
	 * @param message
	 *            Mensagem que ser� mostrada ao usu�rio caso haja algum erro.
	 * 
	 * @see JogoDaForcaException#JogoDaForcaException(String)
	 * 
	 */
	public CaractereInvalidoException(String message) {
		super(message);
	}
}