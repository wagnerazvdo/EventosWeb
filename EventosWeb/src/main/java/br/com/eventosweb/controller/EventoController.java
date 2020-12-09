/**
 * 
 */
package br.com.eventosweb.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.eventosweb.model.Evento;
import br.com.eventosweb.service.EventoService;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/eventos/api")
public class EventoController {

	@Autowired
	private EventoService eventoService;
	
	@PostMapping("/v1")
	public Evento salvarv1(@RequestBody Evento evento) {
		return this.eventoService.Salvar(evento);
	}
	 
	@ApiOperation(
			value="Cadastrar um Evento novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do Evento.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Evento> salvarv2(@RequestBody Evento evento) {
		return ResponseEntity.ok().body(this.eventoService.Salvar(evento));
	}	
	
	@GetMapping("/v1")
	public List<Evento> listarv1() {
		System.out.println("Chamando a versão 1");
		return this.eventoService.listaEventos();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Evento>> Listarv2() {
		return ResponseEntity.ok().body(this.eventoService.listaEventos());
	}
	
	@DeleteMapping("/v1/{id}")
	public String remover(@PathVariable("id") Integer id) {
		this.eventoService.remover(this.eventoService.buscarPorId(id));
		return "Evento informado deletado com sucesso!";
	}
	
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Evento> remover2(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(this.eventoService.buscarPorId(id));	
	}
	
	@PutMapping("/v1/{id}")
	public Evento buscarEventoId(@PathVariable("id") Integer id, @RequestBody Evento evento) {
		Evento eventoBD = this.eventoService.buscarPorId(id);
		BeanUtils.copyProperties(evento, eventoBD, "id");
		this.eventoService.Salvar(eventoBD);
		return eventoBD;	
	}
	
	@PutMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Evento> editarEventov2(@PathVariable("id") Integer id, @RequestBody Evento evento) {
		Evento eventoBD = this.eventoService.buscarPorId(id);
		BeanUtils.copyProperties(evento, eventoBD, "id");
		return ResponseEntity.ok().body(this.eventoService.buscarPorId(id));	
	}
	
}