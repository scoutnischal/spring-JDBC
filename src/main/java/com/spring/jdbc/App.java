package com.spring.jdbc;

import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.student.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	System.out.println( "My Program started......." );
//            ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/dbconfig.xml");
        	//for with using xml.file
        	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfigDemo.class);
            StudentDao studentDao =(StudentDao) context.getBean("studentDao");
            
            Student student = new Student();
            //insert part
//            student.setId(15);
//            student.setName("Prabin Nepal");
//            student.setCity("Jhapa");
//            int result = studentDao.insert(student);
            
            //update part
//            student.setId(15);
//            student.setName("Shyam Baba");
//            student.setCity("Pokhara");
//            int result = studentDao.changeInfo(student);
            
            //delete operation
            student.setId(15);
//            int result = studentDao.deleteInfo(15);


//            if(result == 0) {
//            	System.out.println("Data is not insert into DB");
//            }else {            	
//            	System.out.println("Successfully Insert Data"+result);
//            	System.out.println("Successfully Update Data" + result);
//            	System.out.println("Successfully Delete Data from DB" + result);
//            }
            
            //select student data by Id
//            Student result = studentDao.getStudent(3);
//            System.out.println(result);
//            
            //select multi student data
            List<Student> students = studentDao.getMultiStudent();
            for(Student data : students ) {
            	System.out.println(data);
            }
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
    }
}
