package com.shpshopista.pruebass.model;

import java.util.List;

/**
 *
 * @author gus
 */
public class Carro {

    private int numItems;
    private double total;
    private List<Producto> productos;

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Carro(int numItems, double total, List<Producto> productos) {
        this.numItems = numItems;
        this.total = total;
        this.productos = productos;
    }

    public Carro() {
    }

    public Carro(int numItems, double total) {
        this.numItems = numItems;
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
