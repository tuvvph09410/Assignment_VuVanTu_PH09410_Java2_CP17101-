/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XFile;

import Assignment.Employee;
import Assignment.EmployeeManager;
import Assignment.EmployeeManager_Interface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author vuvantu
 */
public class XFile {
    
    public static void writeFile(String path, Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream objectOS = new ObjectOutputStream(fos);
            
            objectOS.writeObject(object);
            
            objectOS.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static Object readFile(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ObjectIS = new ObjectInputStream(fis);
            
           Object object=ObjectIS.readObject();
            
            ObjectIS.close();
            
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } 
        
    }
}
