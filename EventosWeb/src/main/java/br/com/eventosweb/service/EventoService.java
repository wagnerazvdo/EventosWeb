/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import br.com.eventosweb.model.Evento;

/**
 * @author wagne
 *
 */
public interface EventoService {

	Evento salvar(Evento evento);
	List<Evento> listarEvento();
	void remover(Evento evento);
	Evento buscarPorId(Integer idEvento);
	void removerEndereco(Evento buscarPorId);
	
	

}
