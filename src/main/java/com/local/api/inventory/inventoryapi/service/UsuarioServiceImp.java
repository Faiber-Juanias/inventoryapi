package com.local.api.inventory.inventoryapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.api.inventory.inventoryapi.entity.Usuario;
import com.local.api.inventory.inventoryapi.iservice.IUsuarioService;
import com.local.api.inventory.inventoryapi.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository usuarioRepo;

	@Override
	public Optional<Usuario> getUsuarioById(Integer id) {
		return this.usuarioRepo.findById(id);
	}

	@Override
	public List<Usuario> getAllUsers() {
		return this.usuarioRepo.findAll();
	}

}
