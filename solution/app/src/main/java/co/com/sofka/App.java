package co.com.sofka;

import co.com.sofka.cargame.datos.BaseDatos;
import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BaseDatos consultas = new BaseDatos();
        consultas.Conectar();
        consultas.insertar("dd");
        int i=0;
          while(i!=100)
        {
        i= Integer.parseInt(JOptionPane.showInputDialog("Opciones \n "
                + "1.Iniciar juego \n "
                + "100.salir"));
        
        
         switch (i){

                case 1:
                    
                    
                    break;
         }
        
        }
    
    
    }
}
