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

import br.com.eventosweb.model.Usuario;
import br.com.eventosweb.service.UsuarioService;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/usuarios/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/v1")
	public Usuario Salvarv1(@RequestBody Usuario usuario) {
		this.usuarioService.salvar(usuario);
		return usuario;
	}
	
	@ApiOperation(
			value="Cadastrar um usuario novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do usuario.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Usuario> salvarv2(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(this.usuarioService.salvar(usuario));
	}
	
	@GetMapping("/v1")
	public List<Usuario> Listar(){
		return this.usuarioService.listarUsuario();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Usuario>> Listarv2() {
		return ResponseEntity.ok().body(this.usuarioService.listarUsuario());
	}
	
	@DeleteMapping("/v1/{id}")
	public String Remover1(@PathVariable("id") Integer id) {
		this.usuarioService.removerUsuario(this.usuarioService.buscarPorId(id));
		return "usuario informado deletado com sucesso!";
	}
	
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Usuario> remover2(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(this.usuarioService.buscarPorId(id));	
	}

 	@PutMapping("/{id}")
	public Usuario buscarUsuarioId(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
 		Usuario usuarioBD = this.usuarioService.buscarPorId(id);
		BeanUtils.copyProperties(usuario, usuarioBD, "id");
		this.usuarioService.salvar(usuarioBD);
		return usuarioBD;
	}


}
