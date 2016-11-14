package com.tomoab;

import java.sql.*;

/*
    do some basic stuff with mySQL
 */

public class mySQL {

    private static String username = "root";
    private static String password = "f00bar";
    private static String dbUrl = "jdbc:mysql://localhost:3306/sakila";

    public Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection(dbUrl, username, password);
        System.out.println("connection established");
        return conn;
    }

    public void printMetadata(Connection conn) throws SQLException {
        DatabaseMetaData dbm = conn.getMetaData();
        System.out.println();
        System.out.println("driver name: " + dbm.getDriverName());
        System.out.println("driver version: " + dbm.getDriverVersion());
        System.out.println("username: " + dbm.getUserName());
        System.out.println("db product name: " + dbm.getDatabaseProductName());
        System.out.println("db product version: " + dbm.getDatabaseProductVersion());
        System.out.println("url: " + dbm.getURL());
    }

    public void printColumnMetadata(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println();
        System.out.println(query);
        System.out.println("column name, column type, isNullable, isWritable");
        int columns = rsmd.getColumnCount();
        for (int i = 1; i < columns; i++) {
            System.out.printf("%s, %d, %d, %s %n",
                    rsmd.getColumnName(i),
                    rsmd.getColumnType(i),
                    rsmd.isNullable(i),
                    rsmd.isWritable(i));
        }
    }

    public void printStaffTableRows(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from staff");
        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println();
        rs.beforeFirst();
        while (rs.next()) {
            System.out.printf("%s, %s, %s%n",
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"));
        }
    }

    public void updateLanguageTable(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

        printLanguageTable(stmt);

        // insert new language
        PreparedStatement pstmt = conn.prepareStatement("insert into language values (?, ?, ?)");
        pstmt.setInt(1, 7);
        pstmt.setString(2, "Esperanto");
        pstmt.setString(3, "2016-09-20");
        if (pstmt.executeUpdate() > 0) {
            System.out.println("added language");
        } else {
            System.err.println("error adding language");
        }

        // print table to confirm
        printLanguageTable(stmt);

        // delete language
        pstmt = conn.prepareStatement("delete from language where language_id = ?");
        pstmt.setInt(1, 7);
        if (pstmt.executeUpdate() > 0) {
            System.out.println("deleted language");
        } else {
            System.err.println("error deleting language");
        }

        // print table to confirm
        printLanguageTable(stmt);
    }

    private void printLanguageTable(Statement stmt) throws SQLException {
        ResultSet rs;
        System.out.println();
        rs = stmt.executeQuery("select * from language");
        rs.beforeFirst();
        while (rs.next()) {
            System.out.printf("%s, %s%n",
                    rs.getString("language_id"),
                    rs.getString("name"));
        }
    }

}
