package com.calzateu.tareacalificada;

public class Mascota {
    private String nombre;
    private int foto, numLikes, cambiarNumeroLikes;

    public Mascota(String nombre, int foto, int numLikes) {
        this.nombre = nombre;
        this.foto = foto;
        this.numLikes = numLikes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getCambiarNumeroLikes() {
        return cambiarNumeroLikes;
    }

    public void setCambiarNumeroLikes(int cambiarNumeroLikes) {
        this.cambiarNumeroLikes = cambiarNumeroLikes;
    }
}
