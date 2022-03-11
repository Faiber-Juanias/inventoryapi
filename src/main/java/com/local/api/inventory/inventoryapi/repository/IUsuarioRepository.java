package com.local.api.inventory.inventoryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.local.api.inventory.inventoryapi.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

}
