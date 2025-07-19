package dbBeans;
/*
 *
 * Professor Darrell Payne
 * Bellevue University
 *
 */
public class MyDatabaseBeanMySQL implements java.io.Serializable {
    private java.sql.Connection connection = null;
    private java.sql.Statement statement = null;
    private java.sql.ResultSet resultSet = null;
    
    private String userID = null;
    private String password = null;
    
    public MyDatabaseBeanMySQL() {
    }
    
    public void setUserID(String user){
        userID = user;
    }
    
    public void setPassword(String p){
        password = p;
    }
    
    public java.sql.ResultSet getResults(String SQL){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/baseball?";
            connection = java.sql.DriverManager.getConnection(url + "user=student1&password=pass");
            statement = connection.createStatement();
        }
        catch(Exception e){
        }
        
        try{
            resultSet = statement.executeQuery(SQL);
        }
        catch(java.sql.SQLException e){
        }
        
        return resultSet;
    }
    
    public void closeConnection(){
        try{
            statement.close();
            connection.close();
        }
        catch(java.sql.SQLException e){
        }
    }
}