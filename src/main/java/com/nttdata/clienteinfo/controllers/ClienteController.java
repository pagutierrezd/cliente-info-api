package com.nttdata.clienteinfo.controllers;

import com.nttdata.clienteinfo.models.Cliente;
import com.nttdata.clienteinfo.responses.ApiResponse;
import com.nttdata.clienteinfo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/cliente/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    /**
     * Busca el cliente por su tipo de documento y su numero de documento.
     *
     * @param tipoDocumento   el tipo de documento del cliente a buscar, por ejemplo, "C" para cédula o "P" para pasaporte.
     * @param numeroDocumento el numero de documento del cliente a buscar.
     * @return ResponseEntity que contiene el cliente buscado y un código de estado 200 OK,
     * o un código de estado 404 Not Found si no se encuentra el cliente, o 400 Bad Request si el documento es inválido.
     * @author Paula A. Gutierrez
     */
    @CrossOrigin(origins = "*")
    @GetMapping(value = "obtener/{tipoDocumento}/{numeroDocumento}", headers = "Accept=application/json")
    public ResponseEntity<ApiResponse<?>> consultarCliente(@PathVariable String tipoDocumento, @PathVariable String numeroDocumento) {

        //Validación del tipo de documento, "C" para cédula o "P" para pasaporte.
        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            ApiResponse<String> response = new ApiResponse<>(400, "Tipo de documento inválido.", null);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Optional<Cliente> cliente = clienteService.obtenerCliente(tipoDocumento, numeroDocumento);
        if (cliente.isPresent()) {
            ApiResponse<Cliente> response = new ApiResponse<>(200, "Cliente encontrado.", cliente.get());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        ApiResponse<String> response = new ApiResponse<>(404, "Cliente no encontrado.", null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
