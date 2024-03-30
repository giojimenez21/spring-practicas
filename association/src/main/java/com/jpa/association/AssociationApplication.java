package com.jpa.association;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.association.entities.Address;
import com.jpa.association.entities.Client;
import com.jpa.association.entities.Invoice;
import com.jpa.association.repositories.ClientRepository;
import com.jpa.association.repositories.InvoiceRepository;

@SpringBootApplication
public class AssociationApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(AssociationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		manyToOne();
	}

	@Transactional
	public void manyToOne() {
		Client client = Client.builder()
				.name("Jose")
				.lastname("Mendez")
				.build();
		clientRepository.save(client);
		Invoice invoice = Invoice.builder()
				.description("Compras de oficina")
				.total(2000L)
				.client(client)
				.build();
		Invoice newInvoice = invoiceRepository.save(invoice);
		System.out.println(newInvoice);
	}

	@Transactional
	public void manyToOneFindByIdClient() {
		Optional<Client> optionalClient = clientRepository.findById(1L);
		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();
			Invoice invoice = Invoice.builder()
					.description("Compras de oficina")
					.total(2000L)
					.client(client)
					.build();
			Invoice newInvoice = invoiceRepository.save(invoice);
			System.out.println(newInvoice);
		}
	}

	@Transactional
	public void oneToMay() {
		Client client = Client.builder()
				.name("Cliente")
				.lastname("Apellidos")
				.build();
		Address address1 = Address.builder()
				.street("Calle")
				.number(12)
				.build();
		Address address2 = Address.builder()
				.street("Calle")
				.number(12)
				.build();
		client.getAddresses().add(address1);
		client.getAddresses().add(address2);
		clientRepository.save(client);
	}

}
