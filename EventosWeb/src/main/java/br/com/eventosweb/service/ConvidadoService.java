package br.com.eventosweb.service;

import java.util.List;

import br.com.eventosweb.model.Convidado;

public interface ConvidadoService {

	Convidado salvar(Convidado convidado);

	List<Convidado> listarConvidado();

	void removerConvidado(Convidado convidado);

	void removerPorId(int idConvidado);

	Convidado buscarPorId(int idConvidado);

}
