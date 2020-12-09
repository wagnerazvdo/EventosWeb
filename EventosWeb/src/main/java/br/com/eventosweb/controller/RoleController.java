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

import br.com.eventosweb.model.Role;
import br.com.eventosweb.service.RoleService;
import io.swagger.annotations.ApiOperation;

/**
 * @author wagne
 *
 */
@RestController
@RequestMapping("/roles/api")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/v1")
	public Role Salvarv1(@RequestBody Role role) {
		this.roleService.salvar(role);
		return role;
	}
	
	@ApiOperation(
			value="Cadastrar um role novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do role.")
	
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Role> salvarv2(@RequestBody Role role) {
		return ResponseEntity.ok().body(this.roleService.save(role));
	}
	
	@GetMapping("/v1")
	public List<Role> Listar(){
		return this.roleService.listarRole();
	}
	
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Role>> Listarv2() {
		return ResponseEntity.ok().body(this.roleService.listarRole());
	}
	
	@DeleteMapping("/v1/{id}")
	public String Remover1(@PathVariable("id") Integer id) {
		this.roleService.removerRole(this.roleService.buscarPorId(id));
		return "role informado deletado com sucesso!";
	}
	
	@DeleteMapping("/v2/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Object> remover2(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(this.roleService.buscarPorId(id));	
	}

 	@PutMapping("/{id}")
	public Role buscarRoleId(@PathVariable("id") Integer id, @RequestBody Role role) {
 		Role roleBD = this.roleService.buscarPorId(id);
		BeanUtils.copyProperties(role, roleBD, "id");
		this.roleService.salvar(roleBD);
		return roleBD;
	}


}