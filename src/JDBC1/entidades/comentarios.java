/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC1.entidades;

/**
 *
 * @author Usuario
 */
public class comentarios {
    
    private int id_comentario;
    private int id_casa;
    private String comentario;

    public comentarios() {
    }

    public comentarios(int id_comentario, int id_casa, String comentario) {
        this.id_comentario = id_comentario;
        this.id_casa = id_casa;
        this.comentario = comentario;
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
}
