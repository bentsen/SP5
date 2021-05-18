package sample;
import java.sql.*;
import java.util.ArrayList;


public class DBConnector {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/BrickSlayer";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "peugeot405";


    public ArrayList<Player> loadPlayer()
    {
        ArrayList<Player> playerList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql =" SELECT * FROM Player";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String playerName = rs.getString("name");
                int score = rs.getInt("score");
                int deshCoins = rs.getInt("deshCoins");

                Player player = new Player(playerName,score,deshCoins);
                playerList.add(player);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return playerList;
    }


    public void savePlayers()
    {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;

        String sql = "REPLACE INTO Player(name,score,deshCoins) "
                + " VALUES(?,?,?) ";

        try
        {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            //STEP 2: Execute a query
            System.out.println("Creating statement...");
            //  stmt = conn.createStatement();

            for (int i = 0; i < Main.players.size(); i++)
            {
                pstmt.setString(1, Main.players.get(i).getName());
                pstmt.setInt(2, Main.players.get(i).getScore());
                pstmt.setInt(3, Main.players.get(i).getDeshCoins());

                pstmt.addBatch();
            }

            pstmt.executeBatch();

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }finally {
            try{
                if(rs != null) rs.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Player statement Done");
    }


    public ArrayList<BallSkin> loadBallSkin()
    {
        ArrayList<BallSkin> ballSkinList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql =" SELECT * FROM BallSkin";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String name = rs.getString("name");
                String url = rs.getString("url");
                boolean owned = rs.getBoolean("owned");
                int price = rs.getInt("price");
                boolean equipped = rs.getBoolean("equipped");

                BallSkin ballskin = new BallSkin(name,url,owned,price,equipped);
                ballSkinList.add(ballskin);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return ballSkinList;
    }

    public void saveBallSkin()
    {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;

        String sql = "REPLACE INTO BallSkin(name,url,owned,price,equipped) "
                + " VALUES(?,?,?,?,?) ";

        try
        {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            //STEP 2: Execute a query
            System.out.println("Creating statement...");
            //  stmt = conn.createStatement();

            for (int i = 0; i < Main.ballSkins.size(); i++)
            {
                pstmt.setString(1, Main.ballSkins.get(i).getName());
                pstmt.setString(2, Main.ballSkins.get(i).getUrl());
                pstmt.setBoolean(3, Main.ballSkins.get(i).isOwned());
                pstmt.setInt(4,Main.ballSkins.get(i).getPrice());
                pstmt.setBoolean(5,Main.ballSkins.get(i).isEquipped());

                pstmt.addBatch();
            }

            pstmt.executeBatch();

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }finally {
            try{
                if(rs != null) rs.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("BallSkin statement Done");
    }

    public ArrayList<PaddleSkin> loadPaddleSkin()
    {
        ArrayList<PaddleSkin> paddleSkinList = new ArrayList<>();

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            // Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql =" SELECT * FROM PaddleSkin";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String name = rs.getString("name");
                String url = rs.getString("url");
                boolean owned = rs.getBoolean("owned");
                int price = rs.getInt("price");
                boolean equipped = rs.getBoolean("equipped");

                PaddleSkin paddleSkin = new PaddleSkin(name,url,owned,price,equipped);
                paddleSkinList.add(paddleSkin);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        return paddleSkinList;
    }

    public void savePaddleSkin()
    {
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;

        String sql = "REPLACE INTO PaddleSkin(name,url,owned,price,equipped) "
                + " VALUES(?,?,?,?,?) ";

        try
        {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


            //STEP 2: Execute a query
            System.out.println("Creating statement...");
            //  stmt = conn.createStatement();

            for (int i = 0; i < Main.paddleSkins.size(); i++)
            {
                pstmt.setString(1, Main.paddleSkins.get(i).getName());
                pstmt.setString(2, Main.paddleSkins.get(i).getUrl());
                pstmt.setBoolean(3, Main.paddleSkins.get(i).isOwned());
                pstmt.setInt(4,Main.paddleSkins.get(i).getPrice());
                pstmt.setBoolean(5, Main.paddleSkins.get(i).isEquipped());

                pstmt.addBatch();
            }

            pstmt.executeBatch();

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }finally {
            try{
                if(rs != null) rs.close();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("PaddleSkin statement Done");
    }

}
