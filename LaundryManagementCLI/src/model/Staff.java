package model;


public class Staff extends User {


    public Staff(int idUser, String nama){

        super(idUser,nama,"STAFF");

    }



    @Override
    public void showRole(){

        System.out.println("Role : Staff");

    }


}