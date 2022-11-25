package net.epnmag9.effectivelifepluz.ui;

import java.util.Date;
import java.util.Scanner;
import net.epnmag9.effectivelifepluz.controllers.Paciente;
import net.epnmag9.effectivelifepluz.controllers.GestorPaciente;
import net.epnmag9.effectivelifepluz.controllers.Identificador;
import net.epnmag9.effectivelifepluz.io.GestorPacienteCrud;
import net.epnmag9.lib.NombresValidador;

public class MenuCLI {
    private static String filename = "gestorData.dump";
    private static String basePath = ".";
    private static String dateFormat = "yyyy-MM-dd";
    private static String genericErrorMsg = "Intente de nuevo: ";
    private static Scanner scn = new Scanner(System.in);
    private static GestorPacienteCrud gpC = new GestorPacienteCrud(basePath);
    private static GestorPaciente gp = gpC.read(filename);
    private static CLIInteractiveIOManager cliIO = new CLIInteractiveIOManager(System.in, System.out);

    private static Paciente pacienteSeleccionado;

    private static String menu =
        "0: Salir\n"+
        "1: Registrar paciente\n"+
        "2: Seleccionar paciente\n"+
        "3: Registrar entrada\n"+
        "4: Seleccionar entrada\n"+ //Deprecated?
        "5: Mostrar paciente\n"+
        "6: Mostrar historial del paciente\n";

        public static void registrarPaciente(){
            Identificador identificador = cliIO.readIdentificadorUntilSuccess();
            Paciente paciente = gp.searchPaciente(identificador);
                if(paciente!=null){
                    cliIO.getOut().println("Ya existe un paciente con ese identificador. No es posible volverlo a registrar");
                    return;
                }
            String nombre = cliIO.readNameUntilSuccess("Ingrese el nombre: ",null,"Ingrese el nombre completo: ");
            Date fechaNacimiento = cliIO.readDateUntilSuccess("Ingrese la fecha de nacimiento("+dateFormat+"): ", dateFormat, null, genericErrorMsg);
            String tipoSangre = cliIO.nextLine("Ingrese el tipo de sangre: ");
            String sexo = cliIO.nextLine("Ingrese el sexo: ");
            Paciente newPaciente = gp.registerPacienteIfNotPresent(identificador, nombre, fechaNacimiento, tipoSangre, sexo);
            pacienteSeleccionado = newPaciente;
            cliIO.getOut().println("Paciente registrado y seleccionado.\n");
            gpC.update(filename, gp);
        }

    public static void seleccionarPaciente(){
        cliIO.getOut().print("Ingrese el identificador del paciente: ");
        Identificador identificador = cliIO.readIdentificadorUntilSuccess();
        pacienteSeleccionado = gp.searchPaciente(identificador);
        if (pacienteSeleccionado == null) {
            cliIO.getOut().println("No existe paciente con el identificador especificado. Desea registrarlo (y/N)?: ");
            if(scn.nextLine().equalsIgnoreCase("Y"))
                registrarPaciente();
        }else{
            cliIO.getOut().println("Paciente seleccionado.");
        }
        
    }
    public static void seleccionarEntrada(){
        System.out.println("Deprecated?");
    }

    public static void registrarEntrada(){
        if(pacienteSeleccionado==null){
            System.out.println("No existe paciente seleccionado, seleccione uno.");
            return;
        }
        double peso = cliIO.readDoubleUntilSuccess("Ingrese el peso(Kg): ", null, genericErrorMsg);
        double altura = cliIO.readDoubleUntilSuccess("Ingrese la altura(m): ", null, genericErrorMsg);;
        double presionArterialSis = cliIO.readDoubleUntilSuccess("Ingrese la presion arterial sistólica(mmHg): ", null, genericErrorMsg);;
        double presionArterialDia = cliIO.readDoubleUntilSuccess("Ingrese la presion arterial diastólica(mmHg): ", null, genericErrorMsg);;
        double temperatura = cliIO.readDoubleUntilSuccess("Ingrese la temperatura(C): ", null, genericErrorMsg);
        Date fechaIngreso = cliIO.readDateUntilSuccess("Ingrese la fecha de nacimiento("+dateFormat+"): ", dateFormat, null, genericErrorMsg);
        String observaciones = cliIO.nextLine("Ingrese observaciones adicionales: ");
        gp.registerHistorial(pacienteSeleccionado, peso, altura, presionArterialSis, presionArterialDia, temperatura, fechaIngreso, observaciones);
        gpC.update(filename, gp);
    }

    public static void mostrarPaciente(){
        if (pacienteSeleccionado != null) {
            System.out.println(pacienteSeleccionado.toString());
        }else{
            System.out.println("No se ha seleccionado paciente");
        }
    }

    public static void mostrarEntradas(){
        if (pacienteSeleccionado != null) {
            System.out.println(pacienteSeleccionado.getHistorialClinico().toString());
        }else{
            System.out.println("No se ha seleccionado paciente");
        }
    }

    public static void exit(){
        System.exit(0);
    }

    public static void main(String[] args) {
        while(true){
            System.out.println(menu);
            switch(scn.nextLine()){
                case "0": exit();
                    break;
                case "1": registrarPaciente();
                break;
                case "2": seleccionarPaciente();
                break;
                case "3": registrarEntrada();
                break;
                case "4": seleccionarEntrada();
                break;
                case "5": mostrarPaciente();
                break;
                case "6": mostrarEntradas();
                break;
                default:
            }
        }
    }
    
}
