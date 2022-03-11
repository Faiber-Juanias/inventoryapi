package com.local.api.inventory.inventoryapi.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.api.inventory.inventoryapi.entity.Producto;
import com.local.api.inventory.inventoryapi.iservice.IProductoService;
import com.local.api.inventory.inventoryapi.repository.IProductoRepository;

@Service
public class ProductoServiceImp implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepo;

	@Override
	public List<Producto> getAllProducts() {
		return this.productoRepo.findAll();
	}

	@Override
	public Producto saveProducto(Producto producto) {
		return this.productoRepo.save(producto);
	}

	@Override
	public void deleteProducto(Integer id) {
		this.productoRepo.deleteById(id);
	}

	@Override
	public Optional<Producto> getProductoById(Integer id) {
		return this.productoRepo.findById(id);
	}

	@Override
	public List<Producto> findByFechaIngreso(Calendar fechaIngreso) {
		return this.productoRepo.findByFechaIngreso(fechaIngreso.get(Calendar.YEAR), (fechaIngreso.get(Calendar.MONTH)+1), fechaIngreso.get(Calendar.DATE));
	}

	@Override
	public List<Producto> findByUsuarioLikeOrNombreProductoLike(String search) {
		return this.productoRepo.findByUsuarioLikeOrNombreProductoLike(search.toLowerCase());
	}

	@Override
	public List<Producto> findByUsuarioLikeOrNombreProductoLikeOrFechaIngreso(Calendar fechaIngreso, String search) {
		return this.productoRepo.findByUsuarioLikeOrNombreProductoLikeOrFechaIngreso(fechaIngreso.get(Calendar.YEAR), (fechaIngreso.get(Calendar.MONTH)+1), fechaIngreso.get(Calendar.DATE), search.toLowerCase());
	}

}
