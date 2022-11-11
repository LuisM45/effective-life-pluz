package net.epnmag9.effectivelifepluz.io;

import net.epnmag9.effectivelifepluz.controllers.GestorPaciente;

public class GestorPacienteCrud extends FileCrud<GestorPaciente> {

    public GestorPacienteCrud(String basePath) {
        super(basePath);
        //TODO Auto-generated constructor stub
    }

    @Override
    public GestorPaciente read(String key) {
        try{
            GestorPaciente gp = super.read(key);
            if(gp==null) return new GestorPaciente();
            return gp;

        } catch (Exception e){
            return new GestorPaciente();
        }
    }
    
}
