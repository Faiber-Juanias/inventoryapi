package com.local.api.inventory.inventoryapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.local.api.inventory.inventoryapi.config.InventoryConfig;
import com.local.api.inventory.inventoryapi.entity.Producto;
import com.local.api.inventory.inventoryapi.entity.Usuario;
import com.local.api.inventory.inventoryapi.error.ManageOutputException;
import com.local.api.inventory.inventoryapi.iservice.IProductoService;
import com.local.api.inventory.inventoryapi.iservice.IUsuarioService;
import com.local.api.inventory.inventoryapi.util.ResponseApi;

@RestController
@RequestMapping("/product")
public class ProductoController {

	@Autowired
	private IProductoService serviceProd;
	@Autowired
	private IUsuarioService serviceUsu;
	@Autowired
	private InventoryConfig config;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public ResponseEntity<?> getAllProducts() {
		ResponseApi response = null;
		response = ManageOutputException.manageException(HttpStatus.OK, this.serviceProd.getAllProducts(), null, null, null);
		return new ResponseEntity<ResponseApi>(response, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/filter")
	public ResponseEntity<?> getAllProductsByFilters(@RequestParam(name = "fecha", required = false) String fechaF, @RequestParam(name = "search", required = false) String search) {
		List<Producto> listProd = new ArrayList<>();
		Calendar fecha = Calendar.getInstance();
		ResponseApi response = null;
		SimpleDateFormat dateFor = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (fechaF != null) {
				if (fechaF.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
					fecha.setTime(dateFor.parse(fechaF));					
				} else {
					throw new IllegalArgumentException(this.config.getMessageExceptionValueFecha());
				}
			} else {
				fecha = null;
			}
			if (fecha != null && search != null) {
				listProd = this.serviceProd.findByUsuarioLikeOrNombreProductoLikeOrFechaIngreso(fecha, search);
			} else if (fecha != null && search == null) {
				listProd = this.serviceProd.findByFechaIngreso(fecha);
			} else if (fecha == null && search != null) {
				listProd = this.serviceProd.findByUsuarioLikeOrNombreProductoLike(search);
			}
			response = ManageOutputException.manageException(HttpStatus.OK, listProd, null, null, null);
		} catch (Exception e) {
			response = ManageOutputException.manageException(HttpStatus.BAD_REQUEST, null, this.config.getMessageExceptionFilters(), e.getMessage(), null);
			return new ResponseEntity<ResponseApi>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseApi>(response, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/save")
	public ResponseEntity<?> saveProduct(@RequestBody Producto producto) {
		ResponseApi response = null;
		Producto prod = null;
		try {
			prod = this.serviceProd.saveProducto(producto);			
			Optional<Usuario> usu = this.serviceUsu.getUsuarioById(prod.getUsuarioRegistro().getIdUsuario());
			if (usu.isPresent()) {
				prod.setUsuarioRegistro(usu.get());
			}
			response = ManageOutputException.manageException(HttpStatus.OK, prod, null, null, null);
		} catch (Exception ex) {
			response = ManageOutputException.manageException(HttpStatus.BAD_REQUEST, null, this.config.getMessageSave(), ex.getMessage(), null);
			return new ResponseEntity<ResponseApi>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseApi>(response, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/save")
	public ResponseEntity<?> updateProduct(@RequestBody Producto producto) {
		ResponseApi response = null;
		try {
			if (producto.getIdProducto() == null) {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
			}
			Optional<Producto> prod = this.serviceProd.getProductoById(producto.getIdProducto());
			if (!prod.isPresent()) {
				throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
			}
			response = ManageOutputException.manageException(HttpStatus.OK, this.serviceProd.saveProducto(producto), null, null, null);
		} catch (HttpClientErrorException e) {                                                                                                                  	
			response = ManageOutputException.manageException(HttpStatus.BAD_REQUEST, null, this.config.getMessageUpdateRequiredId(), this.config.getMessageExceptionUpdateRequiredId(), null);
			return new ResponseEntity<ResponseApi>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseApi>(response, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
		ResponseApi response = null;
		try {
			this.serviceProd.deleteProducto(id);
			response = ManageOutputException.manageException(HttpStatus.OK, this.config.getMessageDeleteById(), null, null, id);
		} catch (Exception e) {
			response = ManageOutputException.manageException(HttpStatus.BAD_REQUEST, null,
					this.config.getMessageExceptionDeleteById(), e.getMessage(), id);
			return new ResponseEntity<ResponseApi>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseApi>(response, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/get/{id}")
	public ResponseEntity<?> productById(@PathVariable("id") String id) {
		ResponseApi response = null;
		try {			
			Optional<Producto> prod = this.serviceProd.getProductoById(Integer.valueOf(id));
			if (prod.isPresent()) {
				response = ManageOutputException.manageException(HttpStatus.OK, prod.get(), null, null, null);
			} else {
				throw new Exception(this.config.getMessageExceptionProductNotExist());
			}
		} catch (Exception ex) {
			response = ManageOutputException.manageException(HttpStatus.BAD_REQUEST, null, this.config.getMessageProductNotExist(), ex.getMessage(), null);
			return new ResponseEntity<ResponseApi>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ResponseApi>(response, HttpStatus.OK);
	}
	
}
