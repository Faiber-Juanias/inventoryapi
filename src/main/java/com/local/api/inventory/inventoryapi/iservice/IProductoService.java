package com.local.api.inventory.inventoryapi.iservice;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.local.api.inventory.inventoryapi.entity.Producto;

public interface IProductoService {
	
	List<Producto> getAllProducts();
	Producto saveProducto(Producto producto);
	void deleteProducto(Integer id);
	Optional<Producto> getProductoById(Integer id);
	List<Producto> findByFechaIngreso(Calendar fechaIngreso);
	List<Producto> findByUsuarioLikeOrNombreProductoLike(String search);
	List<Producto> findByUsuarioLikeOrNombreProductoLikeOrFechaIngreso(Calendar fechaIngreso, String search);

}
