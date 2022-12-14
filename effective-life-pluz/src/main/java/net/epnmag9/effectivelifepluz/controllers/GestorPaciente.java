package net.epnmag9.effectivelifepluz.controllers;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GestorPaciente implements Serializable{
    private final Map<Identificador,Paciente> pacientes;

    public GestorPaciente(){
        pacientes = new HashMap<>();
    }

        public Paciente registerPacienteIfNotPresent(
        Identificador identificador,
        String nombre,
        Date fechaNacimiento,
        String tipoSangre,
        String sexo){
            Paciente paciente = searchPaciente(identificador);
            if(paciente!=null) return null;
            return registerPaciente(identificador, nombre, fechaNacimiento, tipoSangre, sexo);
    }
    
    public Paciente registerPaciente(
        Identificador identificador,
        String nombre,
        Date fechaNacimiento,
        String tipoSangre,
        String sexo){
            
            Paciente newPaciente = new Paciente(
                identificador,
                nombre,
                fechaNacimiento,
                tipoSangre,
                sexo
            );
            pacientes.put(identificador, newPaciente);
            return newPaciente;
    }
    public EntradaDatosClinicos registerHistorial(
        Paciente paciente,
        double peso,
        double altura,
        double presionArterial,
        double temperatura,
        Date fechaIngreso,
        String observaciones
        ){
            return paciente.historialClinico.registerEntradaDatosClinicos(peso, altura, presionArterial, temperatura, fechaIngreso, observaciones);
            
            
    }

    public Paciente searchPaciente(Identificador identificador){
        return this.pacientes.get(identificador);
    }
}
