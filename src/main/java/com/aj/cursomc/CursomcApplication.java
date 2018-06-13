package com.aj.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aj.cursomc.domain.Categoria;
import com.aj.cursomc.domain.Cidade;
import com.aj.cursomc.domain.Cliente;
import com.aj.cursomc.domain.Endereco;
import com.aj.cursomc.domain.Estado;
import com.aj.cursomc.domain.Produto;
import com.aj.cursomc.domain.enums.TipoCliente;
import com.aj.cursomc.repositories.CategoriaRepository;
import com.aj.cursomc.repositories.CidadeRepository;
import com.aj.cursomc.repositories.ClienteRepository;
import com.aj.cursomc.repositories.EnderecoRepository;
import com.aj.cursomc.repositories.EstadoRepository;
import com.aj.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	CategoriaRepository categoriaRepo;
	
	@Autowired
	ProdutoRepository produtoRepo;
	
	@Autowired
	EstadoRepository estadoRepo;
	
	@Autowired
	CidadeRepository cidadeRepo;
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	EnderecoRepository enderecoRepo;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");		
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null,"Ceará");
		Estado est2 = new Estado(null, "Rio de Janeiro");
		
		Cidade c1 = new Cidade(null, "Fortaleza", est1);
		Cidade c2 = new Cidade(null, "Rio de Janeiro",est2);
		Cidade c3 = new Cidade(null, "Teresópolis", est2);		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		Cliente cli1 = new Cliente(null,"Fulano de Tal","fulano@gmail.com","66786703704",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("30161841","988271888"));
		
		Endereco e1 = new Endereco(null,"Rua Dr. José Lourenço","2270","ap. 1302","Joaquim Tavora","60115-282",cli1,c1);
		Endereco e2 = new Endereco(null, "Rua Hernane Cardoso","161","casa 31","Cascadura","21000-000",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		categoriaRepo.save(Arrays.asList(cat1,cat2));
		produtoRepo.save(Arrays.asList(p1,p2,p3));
		estadoRepo.save(Arrays.asList(est1,est2));
		cidadeRepo.save(Arrays.asList(c1,c2,c3));
		
		clienteRepo.save(Arrays.asList(cli1));
		enderecoRepo.save(Arrays.asList(e1,e2));
	}
}
