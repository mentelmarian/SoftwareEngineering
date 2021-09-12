/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapcldb;

import com.mycompany.soapservdb.Student;

/**
 *
 * @author studente
 */
public class SOAPClDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student student = getStudent(1);
        System.out.println("Studente: "+student.getID() +" "+  student.getName() +" "+ student.getYearOfBirth());
        
    
    }


    private static Student getStudent(int arg0) {
        com.mycompany.soapservdb.ExamImplService service = new com.mycompany.soapservdb.ExamImplService();
        com.mycompany.soapservdb.Exam port = service.getExamImplPort();
        return port.getStudent(arg0);
    }
    
}
