package com.nttdata.clienteinfo;

import com.nttdata.clienteinfo.models.Cliente;
import com.nttdata.clienteinfo.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;


    @Test
    void obtenerCliente_devuelveClienteExistente() {

        Optional<Cliente> cliente = clienteService.obtenerCliente("C", "1003812765");

        assertTrue(cliente.isPresent());
        assertEquals("José", cliente.get().getPrimerNombre());
        assertEquals("Pérez", cliente.get().getPrimerApellido());
    }

    @Test
    void obtenerCliente_devuelveVacioClienteNoExistente() {

        Optional<Cliente> cliente = clienteService.obtenerCliente("P", "0987654320");
        assertFalse(cliente.isPresent());
    }
}