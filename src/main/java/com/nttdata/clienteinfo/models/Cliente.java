package com.nttdata.clienteinfo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String tipoDocumento;

    private String numeroDocumento;

    private String telefono;

    private String direccion;

    private String ciudadResidencia;
}
