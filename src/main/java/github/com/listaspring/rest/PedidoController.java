package github.com.listaspring.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import github.com.listaspring.pedidos.Pedido;
import github.com.listaspring.repository.IPedido_Repository;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("https://madmansdd.github.io/")
public class PedidoController {

	@Autowired
	private IPedido_Repository pRepository;
	
	
	@PostMapping
	public Pedido save(@RequestBody Pedido pedido) {
			return pRepository.save(pedido);
	} 
	
	@GetMapping
	public List<Pedido> getAll(){
		return pRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Pedido getById(@PathVariable Long id) {
		return pRepository.findById(id).orElseThrow(
				()->new  ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	public void delet(@PathVariable Long id) {
		pRepository.deleteById(id);
	}
	
	@PatchMapping("{id}/feito")
	public Pedido pedidoRealizado(@PathVariable  Long id) {
		return pRepository.findById(id).map(pedido ->{
			pedido.setFinalizado(true);
			pedido.setMomentFinalizado(LocalDateTime.now());
			pRepository.save(pedido);
			return pedido;
		}).orElse(null);
	}
	
	
}
