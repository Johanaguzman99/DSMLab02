package com.example.rta;

public class Persona {
    private String dui;
    private String nombre;
    private String peso;
    private String altura;
    private String fecha;
    private String sexo;
    String key;

    public Persona() {
    }

    public Persona(String dui, String nombre,String peso,String altura,String fecha,String sexo) {
        this.dui = dui;
        this.nombre = nombre;
        this.peso= peso;
        this.altura=altura;
        this.fecha=fecha;
        this.sexo=sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
