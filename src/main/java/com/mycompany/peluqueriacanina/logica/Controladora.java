
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String Observ, String alergico, String atencionEspecial, String nombreDuenio, String celduenio) {
        
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celduenio);
        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencionEspecial);
        masco.setObservaciones(Observ);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
        
        
    }

    public List<Mascota> traerMascota() {
        
    return controlPersis.traerMascotas();
    
    }

    public void borrarMascota(int num_cliente) {
       controlPersis.borrarMascota(num_cliente);
    }


    public Mascota traerMascotas(int num_cliente) {
        return controlPersis.traerMascotas(num_cliente);
        

    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza, String color, String Observ, String alergico, String atencionEspecial, String nombreDuenio, String celduenio) {
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(Observ);
        masco.setAtencion_especial(atencionEspecial);
        masco.setAlergico(alergico);
        
        controlPersis.modificarMascota(masco);
        
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_Duenio());
        dueno.setCelDuenio(celduenio);
        dueno.setNombre(nombreDuenio);
        
        this.modificarDuenio(dueno);

    }

    private Duenio buscarDuenio(int id_Duenio) {

        return controlPersis.traerDuenio(id_Duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        
        controlPersis.modificarDuenio(dueno);
    }
      } 
