package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "update readers set vip_level = \"Not set \"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "call UpdateVipLevels()";
        statement.execute(sqlProcedureCall);

        //Then
        String sqlCheckTable = "select count(*) as how_many from readers where vip_level=\"Not set\"";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(resultSet.next()) {
            howMany = resultSet.getInt("how_many");
        }
        Assert.assertEquals(0, howMany);
    }

    @Test
    public void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "update books set bestseller = false";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

        //When
        String sqlProcedureCall = "call UpdateBestSellers()";
        statement.execute(sqlProcedureCall);

        String sqlCheckTable = "select count(*) as bestSellerCount from books where bestseller = 1";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if(resultSet.next()) {
            howMany = resultSet.getInt("bestSellerCount");
        }
        Assert.assertEquals(1, howMany); //na bazie taki wyszedł jeden jeśli procedura SQL jest poprawna
   }
}
