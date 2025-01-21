package DAO;//Data Access Object
import java.sql.*;
public class DBConnect {

  public Connection cn=null;
  public DBConnect() throws Exception
  {
     Class.forName("org.postgresql.Driver");//postgre driver load in java prog
        cn = DriverManager.getConnection(
           "jdbc:postgresql://localhost:5432/postgres","postgres","Password#12");
  }
  
  public void QueryExecuter(String sql) throws Exception
  {
    Statement st = cn.createStatement();
    st.execute(sql);
    st.close();
  }
  public ResultSet QueryReturner(String sql) throws Exception
  {
    Statement st  = cn.createStatement();
    ResultSet rs  = st.executeQuery(sql);
    return rs;
  }
}

/*

create table userreg(
email     varchar(100),
password  varchar(50),
mobile    varchar(15),
name      varchar(50)
);



  create table testresult( 
testid int primary key auto_increment,
 emailid varchar(100), 
name varchar(100), 
subject varchar(100), 
dateofexam timestamp default current_timestamp);
 
  create table testresultdesc(
     testid int,
     qno int,   
     question varchar(500),
     yourans varchar(1),
     correctans varchar(1));
     
     
     create table resultanalysis(
  testid int,
   name varchar(100),
    subject varchar(100),
    marks int);
 */