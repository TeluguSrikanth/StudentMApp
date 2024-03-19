package com.skv.www.main;

import java.util.Scanner;

import com.skv.www.dao.StudentDao;
import com.skv.www.dao.StudentDaoInterface;
import com.skv.www.model.Student;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		StudentDaoInterface dao=new StudentDao();
		
		System.out.println("Welcome to Studnet management application");
		while(true) {
			
			System.out.println("\n1.Add Student details\n"
					+ "2.Show All Studnets"
					+ "\n3.Show Student By Roll no"
					+ "\n5.Update Students"
					+ "\n4.Delete Student"
					+ "\n6.Exit");
			System.out.println("Enter Your Choice :");
			int ch=sc.nextInt();
			
			switch (ch) {
			case 1:
				System.out.println("Add Student");
				System.out.println("Enter Student name :");
				String name=sc.next();
				System.out.println("Enter Student clgname :");
				String clgname=sc.next();
				System.out.println("Enter Student city :");
				String city=sc.next();
				System.out.println("Enter Student Percentage");
				double percentage=sc.nextDouble();
				
				Student st=new Student(name, clgname, city, percentage);

				boolean g=dao.insertStudent(st);
				
				if(g)
					System.out.println("Record Added Successfully....");
				else
					System.out.println("Something went wrong");
				break;
				
			case 2:
				System.out.println("Show All Students");
				
				dao.showAllStudents();
				
				break;
			case 3:
				System.out.println("Show student by roll no");
				System.out.println("Enetr roll no :");
				int roll=sc.nextInt();
				
				boolean f=dao.showStudentById(roll);
				if(!f)
					System.out.println("Id is not found");
				
				break;
			case 4:
				System.out.println("Delete Student Record");
				System.out.println("Eneter roll number :");
				int rollnum=sc.nextInt();
				
				boolean b=dao.delete(rollnum);
				
				if(b)
					System.out.println("Record deleted Successfully");
				else
					System.out.println("Somthing went wrong");
				
				break;
			case 5:
				System.out.println("Update Student");
				System.out.println("\n1.update student name\n2. Update Clg name");
				System.out.println("enetr ur choice :");
				int choice=sc.nextInt();
				
				if(choice==1) {
					System.out.println("Enter roll number :");
					int rollno=sc.nextInt();
					System.out.println("Enetr new Student name :");
					String sname1=sc.next();
					
					Student std=new Student();
					std.setName(sname1);
					boolean flag=dao.update(rollno,sname1,choice,std);
					
					if(flag) {
						System.out.println("Record updated successfully");
					}
					else {
						System.out.println("something went wrong");
					}
					
				}
				
				
				if(choice==2) {
					System.out.println("Enter roll number :");
					int rollno=sc.nextInt();
					System.out.println("Enetr new College name :");
					String clgname1=sc.next();
					
					Student std=new Student();
					std.setClgname(clgname1);
					boolean flag=dao.update(rollno,clgname1,choice,std);
					
					if(flag) {
						System.out.println("Record updated successfully");
					}
					else {
						System.out.println("something went wrong");
					}
					
				}
				
				break;
				
				
//				 System.out.println("Update the student");
//                 System.out.println("\n1.Update name\n2.Update clgName");
//                 System.out.println("enter your choice");
//                 int choice=sc.nextInt();
//                 if(choice==1){
//                     System.out.println("enter roll number");
//                     int rnum=sc.nextInt();
//                     System.out.println("Enter new name");
//                     String sname1=sc.next();
//                     Student std=new Student();
//                     std.setName(sname1);
//                   boolean flag=  dao.update(rnum,sname1,choice,std);
//                   if(flag)
//                       System.out.println("Name updated successfully");
//                   else
//                       System.out.println("Something went wrong...");
//}
//                 break;
				
				
				
				
			case 6:
				System.out.println("Thanks for visisting Student management application");
				System.exit(0);
				break;
			

			default:
				System.out.println("you choose Incurrect Option");
				System.exit(0);
				break;
			}
			
		}
		
		
	}
	
}
