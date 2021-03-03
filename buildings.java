import java.util.Scanner;

public class buildings {

    public static String run(Scanner in){
        String sql = "";

        boolean run = true;
        while (run){
            System.out.println("What would you like to do?");
            System.out.println("Enter \"1\" to view all buildings, \"2\" to add a building, \"3\" to delete a building, or \"4\" to exit.");
            int choice = in.nextInt();
            if (choice == 1){
                sql = "Select * from buildings";
            }
            else if(choice == 2){
                System.out.println("Enter address:");
                String address = in.nextLine();
                System.out.println("Enter city:");
                String city = in.nextLine();
                System.out.println("Enter dateofPurchase (YYYY-MM--DD:");
                String dateOfPurchase = in.nextLine();
                System.out.println("Enter purchase price:");
                int purchaseprice = in.nextInt(); in.nextLine();

                sql = "INSERT INTO `constructiondb`.`buildings` (`address`, `city`, `dateOfPurchase`, `purchasePrice`) VALUES ('"+address+"', '"+city+"', '"+dateOfPurchase+"', '"+purchaseprice+"');";
            }
            else if(choice == 3) {
                System.out.println("Enter building ID to be deleted:");
                int id = in.nextInt();
                sql = "delete from buildings where buildingID='" + id + "';";
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
