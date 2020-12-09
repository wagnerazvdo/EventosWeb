/**
 * 
 */
package br.com.eventosweb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eventosweb.model.Evento;
import br.com.eventosweb.repository.EventoRepository;

/**
 * @author wagne
 *
 */
@Service
public class EventoServiceImpl implements EventoService{

	@Autowired
	private EventoRepository eventoRepository;
	
	@Override
	@Transactional
	public Evento salvar(Evento evento) {
		return this.eventoRepository.save(evento);
	}

	@Override
	public List<Evento> listarEvento() {
		return this.eventoRepository.findAll();
	}
	@Override
	@Transactional
	public void remover(Evento evento) {
		this.eventoRepository.delete(evento);
	}

	@Override
	public Evento buscarPorId(Integer idEvento) {
		return this.eventoRepository.findById(idEvento).get();
	}

	@Override
	public void removerEndereco(Evento buscarPorId) {
		// TODO Auto-generated method stub
		
	}

}	