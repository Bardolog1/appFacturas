package com.bardolog1.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int nFactura;
    private String descrip;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItem;
    private static int ultimaFactura;

    public Factura(String description, Cliente cliente) {
        this.nFactura = ++ultimaFactura;
        this.descrip = description;
        this.cliente = cliente;
        this.items = new ItemFactura[10];
        this.fecha = new Date();
    }

    public Date getFecha() {
        return fecha;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public ItemFactura[] getItem() {
        return items;
    }


    public void addItemFactura(ItemFactura item) {
        if (indiceItem <= this.items.length) {
            this.items[indiceItem++] = item;
        }
    }
    public double granTotal() {
        double total = 0;
        for (ItemFactura item : this.items) {
            if (item == null) {
                continue;
            }
            total += item.importeP();
        }

        return total;
    }
    public String verDetalle() {
        SimpleDateFormat df= new SimpleDateFormat("dd 'de' MMMM, yyyy");
        StringBuilder sb = new StringBuilder("\nFactura N: ");
                                                                         sb.append(this.nFactura)
                .append("\nCliente: ").append(this.cliente.getNombre()).append("\tIdentificación: ").append(this.cliente.getNit())
                .append("\nDescripción: ").append(this.descrip).append("\tFecha: ").append(df.format(this.fecha)).append("\n\n")
                .append("\n#\tNombre\tPUnit\tCant.\tTotal \n");

           for(ItemFactura item : this.items){
               if (item == null) {
                   continue;
               }
               sb.append(item).append("\n");
               /*sb.append(item.getProducto().getCodigo())
                       .append("\t")
                       .append(item.getProducto().getNombre())
                       .append("\t")
                       .append(item.getProducto().getPrecio())
                       .append("\t")
                       .append(item.getCantidad())
                       .append("\t")
                       .append(item.importeP())
                       .append("\n");
*/
           }
           sb.append("\nGran Total:\t").append(granTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return verDetalle();
    }
}
