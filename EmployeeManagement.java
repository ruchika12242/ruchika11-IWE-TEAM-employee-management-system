package internshipprep;
import java.util.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.time.Instant;
public class EmployeeManagement {
  static class Employee {
      String firstName;
      String lastName;
      String dateOfBirth;
      String title;
      String startDate;
      String endDate;
      String kerberos;
      static String str3 ;

      public String getFirstName() {
          return firstName;
      }

      public void setFirstName(String firstName) {
          this.firstName = firstName;
      }

      public String getLastName() {
          return lastName;
      }

      public void setLastName(String lastName) {
          this.lastName = lastName;
      }

      public String getDateOfBirth() {
          return dateOfBirth;
      }

      public void setDateOfBirth(String dateOfBirth) {
          this.dateOfBirth = dateOfBirth;
      }

      public String getTitle() {
          return title;
      }

      public void setTitle(String title) {
          this.title = title;
      }

      public String getStartDate() {
          return startDate;
      }

      public void setStartDate(String startDate) {
          this.startDate = startDate;
      }

      public String getEndDate() {
          return endDate;
      }

      public void setEndDate(String endDate2) {
          this.endDate = endDate2;
      }

	public String getKerberos() {
		return kerberos;
	}

	public void setKerberos(String kerberos) {
		this.kerberos = kerberos;
	}
      
      
  }

 static List<Employee> employees;

  EmployeeManagement() {
      employees = new ArrayList<Employee>();
  }
  static String str3="";

  static void addEmployeeInput() {
      // Code for user prompt to input the required values

	  Employee e = new Employee();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Employee's First Name:");
      String firstName = sc.nextLine();
      e.setFirstName(firstName);

      System.out.println("Enter Employee's Last Name:");
      String lastName = sc.nextLine();
      e.setLastName(lastName);

      System.out.println("Enter Employee's Date of Birth:");
      String dateOfBirth = sc.nextLine();
      e.setDateOfBirth(dateOfBirth);

      System.out.println("Enter Employee's Title:");
      String title = sc.nextLine();
      e.setTitle(title);

      System.out.println("Enter Employee's Start Date:");
      String startDate = sc.nextLine();
      e.setStartDate(startDate);

      System.out.println("Enter End Date:");
      String endDate = sc.nextLine();
      //Date endDate = new Date();
      e.setEndDate(endDate);
      //Generating kerberos ID
      String st = e.getFirstName().substring(0, 2);
      String kerberos = e.getLastName() + st;
      e.setKerberos(kerberos);
      
      employees.add(e);
      
      System.out.println("       Employee's First Name :" + firstName);
      System.out.println("\n       Employee's Last Name :" + lastName);
      System.out.println("\n       Employee's DOB :" + dateOfBirth);
      System.out.println("\n       Employee's Title : " + title);
      System.out.println("\n       Employee's Start Date :\t" + startDate);
      System.out.println("\n       Employee's End Date:" + endDate);
      System.out.println("\n       Employee's Kerberos id: " + kerberos);
      
  }

  static void filter(int filterChoice) throws ParseException {
      // Code to filter employees based on selected filter
	  
	  if(filterChoice == 1) {
		  for(int i = 0; i < employees.size(); i++) {
			  System.out.println("\nEnter the current date ");
	    	  SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	  Date endDate = sdFormat.parse(employees.get(i).getEndDate());
	    	  Date currentDate = sdFormat.parse(Instant.now().toString().substring(0, 10));
	    	  
	    	  if(endDate.compareTo(currentDate)>=0) {
	    		  System.out.println("\n\nEmployee Information");
	    		  System.out.println("FirstName: " + employees.get(i).getFirstName());
	    		  System.out.println("LastName: " + employees.get(i).getLastName());
	    		  System.out.println("Date of Birth: " + employees.get(i).getDateOfBirth());
	    		  System.out.println("Title: " + employees.get(i).getTitle());
	    		  System.out.println("Start Date: " + employees.get(i).getStartDate());
	    		  System.out.println("End Date: " + employees.get(i).getEndDate());
	    		  System.out.println("Kerberos Id: " + employees.get(i).getKerberos());
	    	  }
	      }
	  } else if(filterChoice == 2) {
		  Scanner sc =new Scanner(System.in);
          System.out.println("Enter Title of Employee: ");
          String employeeTitle = sc.nextLine();
          int flag = 0;
          for(int i = 0; i < employees.size(); i++) {
        	  if(employeeTitle.equals(employees.get(i).getTitle())) {
	    		  System.out.println("\n\nEmployee Information");
	    		  System.out.println("FirstName: " + employees.get(i).getFirstName());
	    		  System.out.println("LastName: " + employees.get(i).getLastName());
	    		  System.out.println("Date of Birth: " + employees.get(i).getDateOfBirth());
	    		  System.out.println("Title: " + employees.get(i).getTitle());
	    		  System.out.println("Start Date: " + employees.get(i).getStartDate());
	    		  System.out.println("End Date: " + employees.get(i).getEndDate());
	    		  System.out.println("Kerberos Id: " + employees.get(i).getKerberos());
	    		  flag++;
	    	  }
          }
          if(flag == 0) {
        	  System.out.println("Employee Not Found with Title:" + employeeTitle);
          }
	  } else {
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Press 1 to filter by isActive as of a date");
          System.out.println("Press 2 to filter by title");
          filterChoice = sc.nextInt();
          filter(filterChoice);
		  
	  }
      
      
      
     
  }

  static void searchEmployee(String kerberos) {
      // Code to search the employee with given kerberos

	  int flag = 0;
      for(int i = 0; i < employees.size(); i++) {
    	  if(kerberos.equals(employees.get(i).getKerberos())) {
    		  System.out.println("FirstName: " + employees.get(i).getFirstName());
    		  System.out.println("LastName: " + employees.get(i).getLastName());
    		  System.out.println("Date of Birth: " + employees.get(i).getDateOfBirth());
    		  System.out.println("Title: " + employees.get(i).getTitle());
    		  System.out.println("Start Date: " + employees.get(i).getStartDate());
    		  System.out.println("End Date: " + employees.get(i).getEndDate());
    		  flag++;
              break;
          }
      }
      if(flag == 0) {
    	  System.out.println("Employee Not Found with id:" + kerberos);
      }
      
  }

  static void terminate(String kerberos) {
      // Code to terminate the employee with given kerberos
	  Employee e = new Employee();
	  int flag = 0;
      for(int i = 0; i < employees.size(); i++) {
    	  if(kerberos.equals(employees.get(i).getKerberos())) {
    		  employees.remove(i);
    		  flag++;
    		  
              break;
          }
      }
      if(flag == 0) {
    	  System.out.println("Employee Not Found with id:" + kerberos);
      }
      
  }

  public static void main(String[] args) throws ParseException {
      EmployeeManagement employeeManagement = new EmployeeManagement();
      Employee e1 = new Employee();
      e1.setFirstName("XYZ");
      e1.setLastName("ABC");
      e1.setDateOfBirth("1999-05-22");
      e1.setTitle("manager");
      e1.setEndDate("2023-12-31");
      e1.setStartDate("2022-10-01");
      e1.setKerberos("ABCXY");

      
      Employee e2 = new Employee();
      e2.setFirstName("PQR");
      e2.setLastName("LMN");
      e2.setDateOfBirth("1999-05-22");
      e2.setTitle("employee");
      e2.setEndDate("2022-10-31");
      e2.setStartDate("2021-10-01");
      e2.setKerberos("LMNPQ");
      
      Employee e3 = new Employee();
      e3.setFirstName("OPQ");
      e3.setLastName("RST");
      e3.setDateOfBirth("1999-05-22");
      e3.setTitle("employee");
      e3.setEndDate("2022-12-31");
      e3.setStartDate("2021-10-01");
      e3.setKerberos("RSTOP");

      
      employees.add(e1);
      employees.add(e2);
      employees.add(e3);
  
      Scanner sc = new Scanner(System.in);
      int choice=0;
      do{
      System.out.println("\n------------------Employee Management----------------------\n");
      System.out.println("Press 1 to Add an Employee\n");
      System.out.println("Press 2 to Search an Employee\n");
      System.out.println("Press 3 to Filter Employees\n");
      System.out.println("Press 4 to Terminate an Employee\n");
      System.out.println("Press 5 to Terminate Program\n");
      choice = sc.nextInt();
      switch (choice) {
          case 1:
              Scanner sce =new Scanner(System.in);
              System.out.println("Enter number of employees");
              int num = sce.nextInt();
              for (int i = 0; i < num; i++) {
                  System.out.println("Enter the details of employee " + i);
                  addEmployeeInput();
              }
              
              break;
          case 2:
              System.out.println("Enter a kerberos id to search: ");
              String kerberos = sc.next();
              searchEmployee(kerberos);
              break;
          case 3:
              System.out.println("Press 1 to filter by isActive as of a date");
              System.out.println("Press 2 to filter by title");
              int filterChoice = sc.nextInt();
              filter(filterChoice);
              break;
          case 4:
              System.out.println("Enter a kerberos id to terminate: ");
              String kerberosId = sc.next();
              terminate(kerberosId);
              break;
          default:
              System.out.println("Please select a valid choice");
              break;
      }
  }while(choice != 5);
  }
}
