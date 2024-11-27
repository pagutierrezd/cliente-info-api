package com.nttdata.clienteinfo.services;

import com.nttdata.clienteinfo.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    /**
     * Metodo con una lista de clientes con datos quemados en lugar de ser consultados en una base de datos
     *
     * @return una lista de Clientes que contiene cuatro instancias de clientes.
     */
    public List<Cliente> clienteList() {
        return Arrays.asList(
                new Cliente("Juan", "Carlos", "Rios", "Quevedo", "P", "7658943200", "987654321", "Carrera Falsa 321", "Cali"),
                new Cliente("Karol", "Daniela", "Conde", "Diaz", "C", "5928757654", "097865342", "Avenida Laureles 564", "Medellin"),
                new Cliente("José", "Luis", "Pérez", "González", "C", "1003812765", "123456789", "Calle Falsa 123", "Bogotá"),
                new Cliente("Ana", "Lucia", "Navarro", "Perdomo", "P", "5522475423", "068235885", "Autopista Norte 098", "Ibague")

        );
    }

    /**
     * Metodo para obtener un cliente de la lista de datos quemados.
     *
     * @param tipoDocumento   el tipo de documento del cliente a buscar, por ejemplo, "C" para cédula o "P" para pasaporte.
     * @param numeroDocumento el numero de documento del cliente a buscar.
     * @return el cliente con información "quemada" del sistema
     * @author Paula A. Gutierrez
     */
    public Optional<Cliente> obtenerCliente(String tipoDocumento, String numeroDocumento) {

        return clienteList().stream().filter(cliente -> cliente.getTipoDocumento().equals(tipoDocumento)
                && cliente.getNumeroDocumento().equals(numeroDocumento)).findFirst();
    }
}
