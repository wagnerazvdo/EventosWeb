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

	Evento Save(Evento evento);

	List<Evento> listaEventos1();

	void remover(Evento evento);

	void remove(Evento evento);

	Evento buscarPorId(int idEvento);

	Evento buscaPorId(int idEvento);

	Evento Salvar(Evento evento);

	List<Evento> listaEventos();

	Evento buscarPorId(Integer id);

	List<Evento> listaEvento();

	

}
