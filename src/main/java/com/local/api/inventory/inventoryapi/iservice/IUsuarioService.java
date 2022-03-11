package com.local.api.inventory.inventoryapi.iservice;

import java.util.List;
import java.util.Optional;

import com.local.api.inventory.inventoryapi.entity.Usuario;

public interface IUsuarioService {

	Optional<Usuario> getUsuarioById(Integer id);
	List<Usuario> getAllUsers();
	
}
