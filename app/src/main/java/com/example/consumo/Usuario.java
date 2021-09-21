package com.example.consumo;
public class Usuario {
    private int id;
    private String nombre;
    private int edad;
    private String genero;
    public Usuario() {
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getGenero() {
        return genero;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +

                ", nombre='" + nombre + '\'' +

                ", edad=" + edad +

                ", genero='" + genero + '\'' +

                '}';
    }
}