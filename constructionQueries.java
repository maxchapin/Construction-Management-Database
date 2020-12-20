import java.sql.*;
import java.util.Scanner;

public class constructionQueries {

    public static void main (String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/constructiondb?allowPublicKeyRetrieval=true&useSSL=false", "boss", "password");

        Statement stmt = conn.createStatement();

        Scanner in = new Scanner(System.in);
        String sql = "";

        boolean run = true;
        while (run){
            ResultSet rs;
            System.out.println("Which table would you like to access?");
            System.out.println("1. company_employees");
            int choice = in.nextInt();
            if (choice == 1){
                if(!company_employees.run(in).equals("")){
                    stmt.execute(company_employees.run(in));
                    sql = "select * from company_employees;";
                    rs = stmt.executeQuery(sql);
                    output(rs, choice);
                }
            }
           /* else if(choice == 2){
                System.out.println("Enter name:");
                String name = in.next();
                System.out.println("Enter DOB (yyyy-mm-dd):");
                String dob = in.next();
                System.out.println("Enter title:");
                String title = in.next();
                System.out.println("Enter current project:");
                int project = in.nextInt();

                sql = "INSERT INTO `constructiondb`.`company_employees` (`empName`, `dob`, `title`, `project`) VALUES ('"+name+"', '"+dob+"', '"+title+"', '"+project+"');";
                stmt.execute(sql);
                sql = "select * from company_employees;";
                rs = stmt.executeQuery(sql);
                output(rs, choice);
            }
            else if(choice == 3){
                System.out.println("Enter employee ID to be deleted:");
                int id = in.nextInt();
                sql = "delete from company_employees where empId='"+id+"';";
                stmt.execute(sql);
                sql = "select * from company_employees;";
                rs = stmt.executeQuery(sql);
                output(rs, choice);
            }*/
            else if(choice == 4){
                System.out.println("Goodbye.");
                run = false;
            }
            else{
                System.out.println("Not valid input.");
            }

        }


    }

    public static void output(ResultSet rs, int choice) throws SQLException {
        if(choice == 1){
            while (rs.next()) {
                String output = rs.getString("empID") + " " + rs.getString("empName") + " " + rs.getString("dob") + " " + rs.getString("title") + " " + rs.getString("project");
                System.out.println(output);

            }

        }
        else{
            while (rs.next()) {
                String output = rs.getString("buildingID") + " " + rs.getString("address") + " " + rs.getString("city") + " " + rs.getString("dateOfPurchase") + " " + rs.getString("purchasePrice");
                System.out.println(output);

            }
        }

    }

}