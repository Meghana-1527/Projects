package player;

import java.util.Scanner;

public class Player {
    String name;
    String contactno;
    String emailID;
    String address;
    int age;
    
    public void setPlayerDetails(String name,String address,String contactno,String emailID,int age){
        this.name=name;
        this.age=age;
        this.contactno=contactno;
        this.address=address;
        this.emailID=emailID;
    }

    public void setPlayername(String name){
        this.name=name;
    }

    public void getPlayerDetails(){
        System.out.println("Player name:" +this.name);
        System.out.println("Player age:" +this.age);
        System.out.println("Player contactno:" +this.contactno);
        System.out.println("Player emailID:" +this.emailID);
        System.out.println("Player address:" +this.address);

    }

    public String getPLayerName(){
        return this.name;

    }

    public void setPlayerDetailsFromUserInput(Player p){    
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter player details");
        System.out.println("Enter the player name:");
        String name=scn.nextLine();
        System.out.println("Enter the player contact number:");
        String contactno=scn.nextLine();
        System.out.println("Enter the player address:");
        String address=scn.nextLine();
        System.out.println("Enter the player emailID:");
        String emailID=scn.nextLine();
        System.out.println("Enter the player age:");
        int age=scn.nextInt();
        p.setPlayerDetails(name,address,contactno,emailID,age);
    }
}