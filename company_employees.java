import java.util.Scanner;

public class company_employees {

    public static String run(Scanner in){
         String sql = "";

        boolean run = true;
        while (run){
            System.out.println("What would you like to do?");
            System.out.println("Enter \"1\" to view all company employees, \"2\" to add an employee, \"3\" to delete an employee, or \"4\" to exit.");
            int choice = in.nextInt();
            if (choice == 1){
                sql = "Select * from company_employees";
            }
            else if(choice == 2){
                System.out.println("Enter name:");
                String name = in.next();
                System.out.println("Enter DOB (yyyy-mm-dd):");
                String dob = in.next();
                System.out.println("Enter title:");
                String title = in.next();
                System.out.println("Enter current project:");
                int project = in.nextInt();

                sql = "INSERT INTO `constructiondb`.`company_employees` (`empName`, `dob`, `title`, `project`) VALUES ('"+name+"', '"+dob+"', '"+title+"', '"+project+"');";
            }
            else if(choice == 3) {
                System.out.println("Enter employee ID to be deleted:");
                int id = in.nextInt();
                sql = "delete from company_employees where empId='" + id + "';";
            /*stmt.execute(sql);
            sql = "select * from company_employees;";
            rs = stmt.executeQuery(sql);
            output(rs, choice);*/
            }
            else if(choice == 4){
                System.out.println("Returning to main menu.");
                run = false;
            }
            else{
                System.out.println("Not valid input.");
            }
            return sql;
        }

       return sql;

    }

}
