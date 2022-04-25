/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.testPIJava.services;


import edu.testPIJava.entities.Publication;
import edu.testPIJava.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class PublicationCRUD {

      Connection connection = null;

    public PublicationCRUD () {
        connection = DataSource.getInstance().getCnx();
    }

    
    
    public void AjoutPublication(Publication P) {
        try {
            String req = "INSERT INTO publication (titre,description) VALUES "
                    + "('" + P.getTitre()+ "'" + ",'" + P.getDescription()+ "')";
            PreparedStatement pst=DataSource.getInstance().getCnx().prepareStatement(req);
            pst.executeUpdate(req);
            System.out.println("publication ajouté avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public static List<Publication> ReadPersonne(){    
        List<Publication> plist = new ArrayList<>();
        try {
            String req = "select * from publication";
            Statement st = DataSource.getInstance().getCnx().createStatement();
            ResultSet rs= st.executeQuery(req);
            while(rs.next()){
                Publication P =new Publication(req, req);
                P.setId(rs.getInt("id"));
                P.setTitre(rs.getString(5));
                P.setDescription(rs.getString(2));
                plist.add(P);
            }
        } catch (Exception e) {
        }
        return plist;
    }

    public void supprimerPublication(int r) {
        try {
            String requete = "delete from `publication` where id=?";
            PreparedStatement ps;
            ps = DataSource.getInstance().getCnx().prepareStatement(requete);
            ps.setInt(1, r);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public void consulterpublication(int r){    
       
       try {
            String requete = "select from `publication` where id=?";
            PreparedStatement ps;
            ps = DataSource.getInstance().getCnx().prepareStatement(requete);
            ps.setInt(1, r);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     public List<Publication> searchByTitle(String title) {
        String req = "SELECT * FROM `publication` WHERE enabled=true AND cancled=false and title LIKE '%" + title + "%'";
        
            req = "SELECT * FROM `lost_object` WHERE enabled=true AND cancled=false and type='annonce' and title LIKE '%" + title + "%'";


        PreparedStatement preparedStatement;
        List<Publication> Ads = new ArrayList<Publication>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            while (resultSet.next()) {
                Publication LO = new Publication(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                Ads.add(LO);
            }

        } catch (SQLException ex) {
            
        }
        return Ads;
    }
}
