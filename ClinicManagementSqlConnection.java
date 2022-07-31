package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class ClinicManagementSqlConnection {
	static Connection connection;
	static Statement statement;
	static Scanner scanner;
	
	static
	{
		//1.Load the driver
		 try { 
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clinic","root","vaishuj@123");  
				scanner=new Scanner(System.in);
				statement=con.createStatement(); 
			} 
			catch(ClassNotFoundException c)
			{
				System.out.println(c.getMessage());
			}
			catch (SQLException e) 
			{
				System.out.println(e.getMessage());
			}
		}
		

public static void insertpatient_detailsValue() throws SQLException
{
	System.out.println("Enter patient id:");
	String patientid=scanner.next();
	
	System.out.println("Enter patient name:");
	String patientName=scanner.next();
	
	System.out.println("Enter patient age:");
	String patientage=scanner.next();
	
	System.out.println("Enter patient address:");
	String patientaddress=scanner.next();
	
	
	
	
	int result=statement.executeUpdate("insert into patient_details values('"+patientid+"','"+patientName+"','"+patientage+"','"+patientaddress+"')");
	if(result==1)
	{
		System.out.println("inserted successfully");
	}else
		System.out.println("failed");
}


public static void updatepatient_detailsValue() throws SQLException
{
	
	System.out.println("Enter patient id:");
	String patientid=scanner.next();
	
	System.out.println("Enter patient name:");
	String patientNm=scanner.next();
	
	
	
	int result=statement.executeUpdate("update patient_details set patientName='"+patientNm+"' where patientid="+patientid+"  ");
	if(result==1)
	{
		System.out.println("updated successfully");
	}else
		System.out.println("failed");
}

public static void deletepatient_detailsValue() throws SQLException
{
	
	System.out.println("Enter patient id:");
	String patientid=scanner.next();
	
	System.out.println("Enter patient name:");
	String patientNm=scanner.next();
	
	System.out.println("Enter patient address:");
	String patientaddress=scanner.next();
	
	
	int result=statement.executeUpdate("delete from patient_details where patientid="+patientid+" ");
	if(result==1)
	{
		System.out.println("deleted successfully");
	}else
		System.out.println("failed");
}
public static void selectpatient_detailsValue() throws SQLException
{ 
	ResultSet resultSet= statement.executeQuery("select *from patient_details");
	while(resultSet.next())
	{
		System.out.println(resultSet.getString("patientid"));
		System.out.println(resultSet.getString("patientName"));
		System.out.println(resultSet.getString("patientaddress"));
	}
	
}

public static void insertdoctor_detailsValue() throws SQLException
{
	System.out.println("Enter doctor id:");
	String id=scanner.next();
	
	System.out.println("Enter doctor name:");
	String Name=scanner.next();
	
	System.out.println("Enter doctor address:");
	String address=scanner.next();
	
	System.out.println("Enter doctor email:");
	String email=scanner.next();
	
	int result=statement.executeUpdate("insert into doctor_details values("+id+",'"+Name+"',"+address+"',"+email+")");
	if(result==1)
	{
		System.out.println("inserted successfully");
	}else
		System.out.println("failed");
}


public static void updatedoctor_detailsValue() throws SQLException
{
	
	System.out.println("Enter doctor id:");
	String id=scanner.next();
	
	System.out.println("Enter doctor name:");
	String Name=scanner.next();
	
	
	int result=statement.executeUpdate("update doctor_details set Name='"+Name+"' where id="+id+"  ");
	if(result==1)
	{
		System.out.println("updated successfully");
	}else
		System.out.println("failed");
}

public static void deletedoctor_detailsValue() throws SQLException
{
	
	System.out.println("Enter doctor id:");
	String id=scanner.next();
	
	//System.out.println("Enter doctor name:");
	//String Name=scanner.next();
	
	
	int result=statement.executeUpdate("delete from doctor_details where id="+id+" ");
	if(result==1)
	{
		System.out.println("deleted successfully");
	}else
		System.out.println("failed");
}
public static void selectdoctor_detailsValue() throws SQLException
{ 
	ResultSet resultSet= statement.executeQuery("select *from Doctor_Details");
	while(resultSet.next())
	{
		System.out.println(resultSet.getString("id"));
		System.out.println(resultSet.getString("Name"));
		System.out.println(resultSet.getString("address"));
	}
	
}
public static void insertprescriptionValue() throws SQLException
{
	System.out.println("Enter Patient id:");
	String Patientid=scanner.next();
	
	System.out.println("Enter Patient name:");
	String PatientName=scanner.next();
	
	System.out.println("Enter medicines:");
	String medicines=scanner.next();
	
	System.out.println("Enter fees:");
	int fees=scanner.nextInt();
	
	int result=statement.executeUpdate("insert into Prescription values("+Patientid+",'"+PatientName+"',"+medicines+"',"+fees+")");
	if(result==1)
	{
		System.out.println("inserted successfully");
	}else
		System.out.println("failed");
}

public static void selectprescriptionValue() throws SQLException
{ 
	ResultSet resultSet= statement.executeQuery("select *from Prescription");
	while(resultSet.next())
	{
		System.out.println(resultSet.getString("Patientid"));
		System.out.println(resultSet.getString("PatientName"));
		System.out.println(resultSet.getString("medicines"));
		System.out.println(resultSet.getString("fees"));
	}
	
}

public static void insertappointmentsValue() throws SQLException
{
	System.out.println("Enter  name:");
	String name=scanner.next();
	
	System.out.println("Enter Date:");
	String Date=scanner.next();
	
	System.out.println("Enter Time:");
	String Time=scanner.next();
	
	System.out.println("Enter Status:");
	String Status=scanner.next();
	
	int result=statement.executeUpdate("insert into appointments values("+name+",'"+Date+"',"+Time+"',"+Status+")");
	if(result==1)
	{
		System.out.println("inserted successfully");
	}else
		System.out.println("failed");
}

public static void selectappointmentsValue() throws SQLException
{ 
	ResultSet resultSet= statement.executeQuery("select *from Appointments");
	while(resultSet.next())
	{
		System.out.println(resultSet.getString("Patientname"));
		System.out.println(resultSet.getString("Date"));
		System.out.println(resultSet.getString("Time"));
		System.out.println(resultSet.getString("Status"));
	}
	
}

public static void insertreceptionValue() throws SQLException
{
	System.out.println("Enter id:");
	String id=scanner.next ();
	
	System.out.println("Enter name:");
	String name=scanner.next();
	
	System.out.println("Enter Email:");
	String Email=scanner.next();
	
	System.out.println("Enter Address:");
	String Address=scanner.next();
	
	int result=statement.executeUpdate("insert into reception values("+id+",'"+name+"',"+Email+"',"+Address+")");
	if(result==1)
	{
		System.out.println("inserted successfully");
	}else
		System.out.println("failed");
}

public static void selectreceptionValue() throws SQLException
{ 
	ResultSet resultSet= statement.executeQuery("select *from Reception");
	while(resultSet.next())
	{
		System.out.println(resultSet.getString("id"));
		System.out.println(resultSet.getString("name"));
		System.out.println(resultSet.getString("Email"));
		System.out.println(resultSet.getString("Address"));
	}
	
}

public static void main(String[] args) throws ClassNotFoundException, SQLException 
{
	try {
	char ch2;
	do {
		System.out.println("1.Patient_details");
		System.out.println("2.Doctor_Details");
		System.out.println("3.Appointments");
		System.out.println("4.Reception");
		System.out.println("5.Prescription");
		System.out.println("Enter the value:");
		int option1=scanner.nextInt();
		switch(option1)
		{
		
		case 1:
	char ch;
	do {
		System.out.println("1.insert ");
		System.out.println("2.update ");
		System.out.println("3.delete ");
		System.out.println("4.select ");
		int op=scanner.nextInt();
		switch(op)
		{
		case 1:insertpatient_detailsValue();
		break;
		
		case 2:updatepatient_detailsValue();
		break;
		
		case 3:deletepatient_detailsValue();
		break;
		
		case 4:selectpatient_detailsValue();
		break;
		
		default : System.out.println("Enter valid option");
		break;
		}
		System.out.println("Do you wants to continue:");
		ch=scanner.next().charAt(0);
	  }while(ch=='y' || ch=='Y');
		break;
		
		case 2:
			char ch1;
			do {
				System.out.println("1.insert ");
				System.out.println("2.update ");
				System.out.println("3.delete ");
				System.out.println("4.select ");
				int op=scanner.nextInt();
				switch(op)
				{
				case 1:insertdoctor_detailsValue();
				break;
				
				case 2:updatedoctor_detailsValue();
				break;
				
				case 3:deletedoctor_detailsValue();
				break;
				
				case 4:selectdoctor_detailsValue();
				break;
				
				default : System.out.println("Enter valid option");
				break;
				}
				System.out.println("Do you wants to continue:");
				ch1=scanner.next().charAt(0);
			  }while(ch1=='y' || ch1=='Y');
				break;
				
		case 3:
			char ch3;
			do {
				System.out.println("1.insert ");
				
				int op=scanner.nextInt();
				switch(op)
				{
				case 1 :insertappointmentsValue();
				break;
				
				
				default : System.out.println("Enter valid option");
				break;
				}
				System.out.println("Do you wants to continue:");
				ch3=scanner.next().charAt(0);
			  }while(ch3=='y' || ch3=='Y');
				break;
				
				
    case 4:
	char ch4;
	do {
		System.out.println("1.insert ");
		
		int op=scanner.nextInt();
		switch(op)
		{
		case 1 :insertreceptionValue();
		break;
		
		
		default : System.out.println("Enter valid option");
		break;
		}
		System.out.println("Do you wants to continue:");
		ch4=scanner.next().charAt(0);
	  }while(ch4=='y' || ch4=='Y');
		break;
		

    case 5:
    	char ch5;
    	do {
    		System.out.println("1.insert ");
    		
    		int op=scanner.nextInt();
    		switch(op)
    		{
    		case 1 :insertprescriptionValue();
    		break;
    		
    		
    		default : System.out.println("Enter valid option");
    		break;
    		}
    		System.out.println("Do you wants to continue:");
    		ch5=scanner.next().charAt(0);
    	  }while(ch5=='y' || ch5=='Y');
    		break;
    default : System.out.println("Enter valid option");
	break;
	}
	System.out.println("Do you wants to continue:");
	ch2=scanner.next().charAt(0);
  }while(ch2=='y' || ch2=='Y');
	}
	
	catch(Exception ex) {
		 System.out.println("eeee"+ex.getMessage());
	}
}
}
	
	
	

	

		

	
