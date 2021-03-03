import java.util.Scanner;

public class tenants {

    public static String run(Scanner in){
        String sql = "";

        boolean run = true;
        while (run){
            System.out.println("What would you like to do?");
            System.out.println("Enter \"1\" to view all tenants, \"2\" to add a tenant, \"3\" to delete a tenant, or \"4\" to exit.");
            int choice = in.nextInt();
            if (choice == 1){
                sql = "Select * from tenants";
            }
            else if(choice == 2){
                System.out.println("Enter tenant name:");
                String tenantName = in.nextLine();
                System.out.println("Enter number of employees:");
                int numOfEmps = in.nextInt(); in.nextLine();
                System.out.println("Enter building ID where located:");
                int building = in.nextInt(); in.nextLine();

                sql = "INSERT INTO `constructiondb`.`tenants` (`tenantName`, `numOfEmps`, `building`) VALUES ('"+tenantName+"', '"+numOfEmps+"', '"+building+"');";
            }
            else if(choice == 3) {
                System.out.println("Enter tenant name to be deleted:");
                String id = in.nextLine();
                sql = "delete from tenants where tenantName='" + id + "';";
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
