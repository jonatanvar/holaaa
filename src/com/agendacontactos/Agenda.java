package com.agendacontactos;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
        } else {
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        }
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public boolean eliminarContacto(String nombre) {
        Contacto contactoAEliminar = buscarContacto(nombre);
        if (contactoAEliminar != null) {
            contactos.remove(contactoAEliminar);
            return true;
        }
        return false;
    }
}