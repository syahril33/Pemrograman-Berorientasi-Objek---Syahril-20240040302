package model;


public class Admin extends User {


    public Admin(int idUser, String nama){

        super(idUser,nama,"ADMIN");

    }


    @Override
    public void showRole(){

        System.out.println("Role : Admin");

    }


}