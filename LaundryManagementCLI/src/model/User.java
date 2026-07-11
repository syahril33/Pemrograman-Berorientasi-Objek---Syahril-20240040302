package model;

public class User {

    private int idUser;
    private String nama;
    private String role;


    public User(int idUser, String nama, String role) {

        this.idUser = idUser;
        this.nama = nama;
        this.role = role;

    }


    public int getIdUser() {

        return idUser;

    }


    public void setIdUser(int idUser) {

        this.idUser = idUser;

    }


    public String getNama() {

        return nama;

    }


    public void setNama(String nama) {

        this.nama = nama;

    }


    public String getRole() {

        return role;

    }


    public void setRole(String role) {

        this.role = role;

    }


    public void showRole(){

        System.out.println("Role User : " + role);

    }

}