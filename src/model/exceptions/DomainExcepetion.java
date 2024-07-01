package model.exceptions;

public class DomainExcepetion extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DomainExcepetion(String msg) {
		super(msg);//Repasso msg para o construtor da superClasse.
		/* Permito assim instanciar exceção personalizada
		 * Passo assim uma mensagem. E esse msg fica armazenada na exceção.
		 */
	}
	
}
