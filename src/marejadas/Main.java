package marejadas;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class Main {
    public static void main(String[] args){
        //LectorArchivo lector = new LectorArchivo();
        //List<Dato> datos = lector.leer("C:\\Users\\Duoc\\Downloads\\NodoIquique.txt");
        
        
        //for(Dato d : datos){
           // d.mostrar();
      //  }
      //cONSULTA EN EL SITIO WEB
      try{
          // 1. Definir la URL
          String urlStr = "https://fundacion-instituto-profesional-duoc-uc.github.io/ATY1102-Surf/Nodo%207%20(-31,-73)%20-%20Tongoy.txt";
          var url = new URL(urlStr);
          //2. Crear un archivo temporal
          File tempFile = File.createTempFile("NodoTongoy", ".txt");
          tempFile.deleteOnExit();
          //3. copiar desde la url el archivo temporal
          try(InputStream in = url.openStream()){
              Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
          
          }
          //4. Unificar el archivo temporal con los objetos
          LectorArchivo lector = new LectorArchivo();
          List<Dato> datos = lector.leer("C:\\Users\\Duoc\\Downloads\\NodoIquique.txt");
          //Mostrar resultados
          for(Dato d : datos){
              d.mostrar();
          }
      }  
      
      catch(Exception e){
          e.printStackTrace();
      }
    }   
}
