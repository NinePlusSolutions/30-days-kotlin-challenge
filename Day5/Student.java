import java.util.Calendar;

public class Student extends Person{

    public int core;
     //Contructor
    //Setter

    public void setCore(int vcore){
        this.core=vcore;
    }

    //getter

    public int getCore(){
        return this.core;


    }
    public void showinfo(){
        super.showinfo();
        System.out.println("Score "+this.getCore());
    }



}
