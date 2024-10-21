/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import Model.Mentee;
import Model.User;

public class WalletDAO extends DBContext {

    public Wallet getWalletByUsername(String name) {
        String sql = "select * from Wallet\n"
                + "where Wallet.Username = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Wallet s = new Wallet();
                s.setBalance(rs.getDouble("Balance"));
                s.setUsername(rs.getString("Username"));
                s.setWalletID(rs.getInt("WalletID"));
                return s;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return null;
    }
    
    public boolean updateWalletBalanceByUsername(String username, double newBalance) {
    String sql = "UPDATE Wallet SET Balance = ? WHERE Username = ?";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setDouble(1, newBalance);
        st.setString(2, username);
        int rowsUpdated = st.executeUpdate(); // Execute the update statement
        return rowsUpdated > 0; // Return true if the update was successful
    } catch (SQLException e) {
        System.out.println(e);
    }
    return false;
}

    
    public static void main(String[] args) {
        WalletDAO act = new WalletDAO();
        System.out.println(act.getWalletByUsername("hoanganhgp23"));
        act.updateWalletBalanceByUsername("hoanganhgp23", 3000000);
         System.out.println(act.getWalletByUsername("hoanganhgp23"));
    }
}
