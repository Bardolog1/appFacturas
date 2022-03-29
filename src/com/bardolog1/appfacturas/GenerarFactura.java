package com.bardolog1.appfacturas;


import com.bardolog1.appfacturas.modelo.*;

import javax.swing.*;

import static javax.swing.JOptionPane.showConfirmDialog;

public class GenerarFactura {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNit(JOptionPane.showInputDialog(null,"Ingrese el nit cliente"));
        cliente.setNombre(JOptionPane.showInputDialog(null,"Ingrese el nombre cliente"));
        String descrip=JOptionPane.showInputDialog(null,"Ingrese la drescripción para\n la factura");

        Factura factura = new Factura(descrip,cliente);

        Producto producto;
        String confirma="N";

        do {
            try {
                producto = new Producto();
                producto.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nombre del producto"));
                producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el Precio del producto")));
                factura.addItemFactura(new ItemFactura(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad")), producto));

                JOptionPane.showMessageDialog(null, producto.getCodigo() + ".-" + producto.getNombre() + " " + producto.getPrecio() + "\t Agregado");

                confirma = JOptionPane.showInputDialog(null, "Desea ingresar otro producto S-N");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo");
                main(args);
                System.exit(1);
            }

        }while(confirma.equalsIgnoreCase("S"));

        System.out.println(factura);


    }
}
