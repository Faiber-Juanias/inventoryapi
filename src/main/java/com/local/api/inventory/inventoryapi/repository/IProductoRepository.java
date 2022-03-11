package com.local.api.inventory.inventoryapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.local.api.inventory.inventoryapi.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query(value = "select * from producto p \r\n"
			+ "where extract(year from p.fecha_ingreso) = :YEAR and \r\n"
			+ "	extract(month from p.fecha_ingreso) = :MONTH and \r\n"
			+ "	extract(day from p.fecha_ingreso) = :DAY", nativeQuery = true)
	List<Producto> findByFechaIngreso(@Param("YEAR") int year, @Param("MONTH") int month, @Param("DAY") int day);
	
	@Query(value = "select p.* from producto p \r\n"
			+ "inner join usuario u on p.usuario_registro = u.idusuario \r\n"
			+ "where lower(u.nombre) like %:SEARCH% or lower(p.nombre_producto) like %:SEARCH%", nativeQuery = true)
	List<Producto> findByUsuarioLikeOrNombreProductoLike(@Param("SEARCH") String search);
	
	@Query(value = "select p.* from producto p \r\n"
			+ "inner join usuario u on p.usuario_registro = u.idusuario \r\n"
			+ "where (lower(u.nombre) like %:SEARCH% or lower(p.nombre_producto) like %:SEARCH%) or \r\n"
			+ "(extract(year from p.fecha_ingreso) = :YEAR and \r\n"
			+ "	extract(month from p.fecha_ingreso) = :MONTH and \r\n"
			+ "	extract(day from p.fecha_ingreso) = :DAY)", nativeQuery = true)
	List<Producto> findByUsuarioLikeOrNombreProductoLikeOrFechaIngreso(@Param("YEAR") int year, @Param("MONTH") int month, @Param("DAY") int day, @Param("SEARCH") String search);
	
}
