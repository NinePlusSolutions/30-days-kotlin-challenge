public class Main {
    public static void main(String[]args){
      //Access modifier
        //Cùng package
        //Private chỉ truy cập được trong class              (property,method)
        //Null(rỗng) truy cập trong package                  (class,property,method)
        //protected truy cập trong package và các subclasses (property,method)
        //Public truy cập được bất kỳ đâu                    (class,property,method)

       Student studentObj=new Student();
       studentObj.setTen("duonmg");
       studentObj.showinfo();






    }

}
