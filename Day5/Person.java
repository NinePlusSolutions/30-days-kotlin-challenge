import java.util.Calendar;

public class Person {
    public String Ten;
    public int NamSinh;
    public int Tuoi;

    //Contructor
    public Person(String VTen,int VNamSinh,int VTuoi){

        this.NamSinh=VNamSinh;
        this.Tuoi=VTuoi;
        this.Ten=VTen;

    }
    public Person(){

    }
    //Setter
    public void setTen(String vTen){
        this.Ten=vTen;
    }
    public void setNamSinh(int vNamSinh){
        this.NamSinh=vNamSinh;
    }
    public void setNamSinh(){
        this.NamSinh = 2002;
    }
    public void setTuoi(int vTuoi){
        this.Tuoi=vTuoi;
    }


    //getter
    public String getTen(){
        return this.Ten;
    }
    public int getNamSinh(){
        return  this.NamSinh;
    }
    public int getTuoi() {
        return this.Tuoi;
    }

    public int getAge(){
        int age=0;
        Calendar now =Calendar.getInstance();
        age=now.get(Calendar.YEAR)-getNamSinh();
        return age;
    }

    //show person info
    public void showinfo(){
        System.out.println("Ten cua ban la:"+this.getTen());
        System.out.println("Tuoi cua ban la:"+this.getTuoi());
        System.out.println("Nam Sinh cua ban la:"+this.getNamSinh());

    }
}
