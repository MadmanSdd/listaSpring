package github.com.listaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import github.com.listaspring.pedidos.Pedido;

public interface IPedido_Repository extends JpaRepository<Pedido, Long>{

}
