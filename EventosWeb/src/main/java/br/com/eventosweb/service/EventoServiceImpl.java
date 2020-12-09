/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.eventosweb.exception.EntidadeComDependenciasException;
import br.com.eventosweb.model.Evento;
import br.com.eventosweb.repository.EventoRepository;

/**
 * @author wagne
 *
 */
@Service
public class EventoServiceImpl implements EventoService{


	private EventoRepository EventoRepository;
	
	
	@Override
	@Transactional
	public Evento Save(Evento evento) {
		return this.EventoRepository.save(evento);
	}

	
	@Override
	public List<Evento> listaEvento() {
		return this.EventoRepository.findAll();
	}


	@Override
	@Transactional
	public void remove(Evento evento) {
		if(!evento.getcConvidados().isEmpty()) {
			throw new EntidadeComDependenciasException("Evento não pode ser removido, existem convidados vinculados!");
		} else
		this.EventoRepository.delete(evento);
	
	}

	
	@Override
	public Evento buscaPorId(int idEvento) {
		return this.EventoRepository.findById(idEvento).get();
	}

	@Override
	public Evento Salvar(Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Evento evento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evento buscarPorId(int idEvento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> listaEventos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Evento> listaEventos1() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Evento buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
