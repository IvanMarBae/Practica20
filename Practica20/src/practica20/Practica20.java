
package practica20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Practica20 {
     static String rutaCarpeta;
     static String separator;
     static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
          int option = -1;
          String nameFolder;
          p1_CreateFolder("ivan-monlau");
        while (option != 0) {
            userMenu();
            option = keyboard.nextInt();
            switch (option) {
                
                case 1:
                    System.out.println("Folder Name?:");
                    nameFolder= keyboard.next();
                    p1_CreateFolder(nameFolder);
                    break;
                    
                case 2:
                     //nombre extension ubicacion 
                    System.out.println("Nombre Fichero?");
                    String fileName = keyboard.next();
                    System.out.println("TEXTO?");
                    String text=keyboard.next();
                    p2_CreateFile(fileName, text);
                    break;
                    
                case 3:
                    //a- visualizar los archivos
                    showFiles();
                    
                    break;
                    
                case 4:
                    
                    break;
                    
                case 5:
                    
                    
                    break;
                    
                case 6:
                    
                    break;
                    
                case 7:
                    
                    break;
                    
                case 8:
                   
                    break;
                    
                case 10:
                      System.out.println("Quieres salir? Y/N");
                    String res= keyboard.next();
                    if (res.equals("Y"))System.out.println("Good Bye");
                    else { option =90;    }
                    break;
                case 0:
                    //p0();
                    break;
                    
                default:
                    System.out.println("Option no aviable");
            }
        }while (option !=0);
        
    }
     private static void userMenu() {
        System.out.println("Iván Martínez");
        System.out.println("Option 1-(Crear carpeta)");
        System.out.println("Option 2-(Crear un fichero)");
        System.out.println("Option 3-(DADO)");
        System.out.println("Option 4-(Numbers 2)");
        System.out.println("Option 5-(Marks M3)");
        System.out.println("Option 6-(Dates M3)");
        System.out.println("Option 7-(Said a number)");
        System.out.println("Option 0- ");
        System.out.print("\nOption == ? ");
    }

    private static void p1_CreateFolder(String nameFolder) {
        String path= System.getProperty("user.dir");
        //System.out.println(path);
         separator= File.separator;
         rutaCarpeta=path + File.separator + nameFolder; 
        //System.out.println(rutaCarpeta);
        File carpeta=new File(rutaCarpeta);
        //System.out.println(carpeta);
        if(!carpeta.exists()) carpeta.mkdir();
        
    }

    private static void p2_CreateFile(String fileName, String text) throws IOException {
       fileName= rutaCarpeta + separator + fileName + ".txt";
        
       FileWriter fw= new FileWriter (fileName);
       BufferedWriter bw=new BufferedWriter(fw);
       //2- escribir en el fichero
       bw.write(text);
       //1-cerrar ficher
       bw.flush();//borrar la memoria
       bw.close();//cerrar el fichero(fileName, );
    }

    private static void showFiles() {
        File Folder = new File(rutaCarpeta);
        String[] listDocuments = Folder.list();
        for(int i=0; i<listDocuments.length; i++){
            
          System.out.println((i + 1) + "-" + listDocuments [i]);
        }
    }
    private static void readFile(String fileName) 
            throws IOException {
       
        
       fileName= rutaCarpeta + separator + fileName + ".txt";
        
       FileReader fr= new FileReader (fileName);
       BufferedReader br=new BufferedReader(fr);
       //2- escribir en el fichero
       String line;
       while((line =br.readLine()) !=null){
                System.out.println(line);
            }
       //1-cerrar ficher
       br.close();//cerrar el fichero(fileName, );
    
}
}
