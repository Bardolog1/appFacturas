package com.bardolog1.appfacturas.modelo;

public class ItemFactura {

    private int cantidad;
    private Producto producto;

    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double importeP (){
        return  cantidad * producto.getPrecio();
    }


    @Override
    public String toString() {
        return producto +"\t"+cantidad+"\t"+importeP();
    }
}
