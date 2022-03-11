package com.local.api.inventory.inventoryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.local.api.inventory.inventoryapi.entity.Usuario;
import com.local.api.inventory.inventoryapi.iservice.IUsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceUsu;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public List<Usuario> getAllProducts() {
		return this.serviceUsu.getAllUsers();
	}

}
