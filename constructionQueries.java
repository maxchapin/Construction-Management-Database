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
            System.out.println("2. buildings");
            System.out.println("3. projects");
            System.out.println("4. subcontractor_companies");
            System.out.println("5. tenants");
            System.out.println("6. Leave program");

            int choice = in.nextInt();
            if (choice == 1){//company employees
                if(!company_employees.run(in).equals("")){
                    stmt.execute(company_employees.run(in));
                    sql = "select * from company_employees;";
                    rs = stmt.executeQuery(sql);
                    output(rs, choice);
                }
            }
            else if (choice == 2){ //buildings
                if(!buildings.run(in).equals("")){
                    stmt.execute(buildings.run(in));
                    sql = "select * from buildings;";
                    rs = stmt.executeQuery(sql);
                    output(rs, choice);
                }
            }
            else if (choice == 3){ //projects
                if(!projects.run(in).equals("")){
                    stmt.execute(projects.run(in));
                    sql = "select * from projects;";
                    rs = stmt.executeQuery(sql);
                    output(rs, choice);
                }
            }
            else if (choice == 4){ //subcontractor companies
                if(!sub_companies.run(in).equals("")){
                    stmt.execute(sub_companies.run(in));
                    sql = "select * from subcontractor_companies;";
                    rs = stmt.executeQuery(sql);
                    output(rs, choice);
                }
            }
            else if (choice == 5){ //tenants
                if(!tenants.run(in).equals("")){
                    stmt.execute(tenants.run(in));
                    sql = "select * from tenants;";
                    rs = stmt.executeQuery(sql);
                    output(rs, choice);
                }
            }

            else if(choice == 6){
                System.out.println("Goodbye.");
                run = false;
            }
            else{
                System.out.println("Not valid input.");
            }

        }


    }

    public static void output(ResultSet rs, int choice) throws SQLException {
        if(choice == 1){ //company employees
            while (rs.next()) {
                String output = rs.getString("empID") + " " + rs.getString("empName") + " " + rs.getString("dob") + " " + rs.getString("title") + " " + rs.getString("project");
                System.out.println(output);

            }

        }
        else if(choice == 2){//buildings
            while (rs.next()) {
                String output = rs.getString("buildingID") + " " + rs.getString("address") + " " + rs.getString("city") + " " + rs.getString("dateOfPurchase") + " " + rs.getString("purchasePrice");
                System.out.println(output);

            }
        }
        else if(choice == 3){//projects
            while (rs.next()) {
                String output = rs.getString("projectID") + " " + rs.getString("tenantName") + " " + rs.getString("budget");
                System.out.println(output);

            }
        }
        else if(choice == 4){//subcontractor companies
            while (rs.next()) {
                String output = rs.getString("companyName") + " " + rs.getString("numOfEmpsOnSite") + " " + rs.getString("contactNumber") + " " + rs.getString("project");
                System.out.println(output);

            }
        }
        else if(choice == 5){//tenants
            while (rs.next()) {
                String output = rs.getString("tenantName") + " " + rs.getString("numOfEmps") + " " + rs.getString("building");
                System.out.println(output);

            }
        }
    }

}