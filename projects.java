import java.util.Scanner;

public class projects {

    public static String run(Scanner in){
        String sql = "";

        boolean run = true;
        while (run){
            System.out.println("What would you like to do?");
            System.out.println("Enter \"1\" to view all projects, \"2\" to add a project, \"3\" to delete a projects, or \"4\" to exit.");
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 1){
                sql = "Select * from projects";
            }
            else if(choice == 2){
                System.out.println("Enter tenant name:");
                String tenantName = in.nextLine();
                System.out.println("Enter budget:");
                int budget = in.nextInt();
                in.nextLine();
                sql = "INSERT INTO `constructiondb`.`projects` (`tenantName`, `budget`) VALUES ('"+tenantName+"', '"+budget+"');";
            }
            else if(choice == 3) {
                System.out.println("Enter project ID to be deleted:");
                int id = in.nextInt();
                in.nextLine();
                sql = "delete from projects where projectID='" + id + "';";
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
