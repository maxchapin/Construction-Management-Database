import java.util.Scanner;

public class sub_companies {

    public static String run(Scanner in){
        String sql = "";

        boolean run = true;
        while (run){
            System.out.println("What would you like to do?");
            System.out.println("Enter \"1\" to view all subcontractor companies, \"2\" to add a subcontractor company, \"3\" to delete a subcontractor company, or \"4\" to exit.");
            int choice = in.nextInt();
            if (choice == 1){
                sql = "Select * from subcontractor_companies";
            }
            else if(choice == 2){
                System.out.println("Enter company name:");
                String companyName = in.nextLine();
                System.out.println("Enter number of employees on site:");
                int empsOnSite = in.nextInt(); in.nextLine();
                System.out.println("Enter contact number (XXX-XXX-XXXX)");
                String contactNumber = in.next(); in.nextLine();
                System.out.println("Enter project ID:");
                int projectID = in.nextInt(); in.nextLine();

                sql = "INSERT INTO `constructiondb`.`subcontractor_companies` (`companyName`, `numOfEmpsOnSite`, `contactNumber`, `project`) VALUES ('"+companyName+"', '"+empsOnSite+"', '"+contactNumber+"', '"+projectID+"');";
            }
            else if(choice == 3) {
                System.out.println("Enter company name to be deleted:");
                String id = in.nextLine();
                sql = "delete from subcontractor_companies where companyName='" + id + "';";
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
