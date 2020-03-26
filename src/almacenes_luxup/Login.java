package almacenes_luxup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
    Connection con;
    public Login(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ALMACENES_LUXUP","root","");
        } catch (Exception e) {
            System.err.println("Error:" +e);
        }
    }

    public static void main(String[] args) { 
        String consulta = "";
        String usuario = "";
        String pass = "";
        
        System.out.println ("Bienvenido, por favor scanee el código en su gafete:");
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        usuario = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        usuario = usuario.replace("'","''");
        
        System.out.println ("Por favor ingrese su contraseña:");
        Scanner passEscaner = new Scanner (System.in); //Creación de un objeto Scanner
        pass = passEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        
        consulta=("select * from USUARIOS where ID = '"+usuario+"' and CONTRASENIA = '"+pass+"';");
        //System.out.println(consulta);
        
        Login cn=new Login();
        Statement st;
        ResultSet rs;
        try {
            st=cn.con.createStatement();
            rs=st.executeQuery(consulta);
            while (rs.next()) {                
                System.out.println(rs.getString("NOMBRE"));
            }
            cn.con.close();
        } catch (Exception e) {
        }
    }
}