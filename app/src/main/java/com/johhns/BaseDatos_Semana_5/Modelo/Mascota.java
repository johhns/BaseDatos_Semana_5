package com.johhns.BaseDatos_Semana_5.Modelo;

public class Mascota  {

    private int id_mascota ;
    private int foto ;
    private String nombre ;
    private int rating ;

    public Mascota() {
    }

    public Mascota(int foto, String nombre, int rating) {
        this.foto = foto;
        this.nombre = nombre;
        this.rating = rating;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /// fin
}
