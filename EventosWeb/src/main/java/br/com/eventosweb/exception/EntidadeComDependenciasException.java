/**
 * 
 */
package br.com.eventosweb.exception;

/**
 * @author wagne
 *
 */
public class EntidadeComDependenciasException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public EntidadeComDependenciasException(String mensagem) {
		super(mensagem);
	}
}
