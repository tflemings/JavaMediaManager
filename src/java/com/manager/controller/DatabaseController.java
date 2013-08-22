/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager.controller;

import com.manager.model.Genre;
import com.manager.model.MediaItem;
import com.manager.model.MediaType;
import com.manager.model.PurchaseInfo;
import com.manager.model.PurchaseInfoItemCrossRef;
import com.manager.model.PurchaseInfoMediaItem;
import com.manager.model.UserDetails;
import com.manager.model.V_Items;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Tony
 */
public class DatabaseController {
    private Connection con;
    
    public DatabaseController(String connectionString, String driver) throws SQLException {
        this.con = this.getConnection(connectionString, driver);
    }
    
    public Connection getConnection(String connectionString, String driver) {
        try {
            Class.forName(driver).newInstance();
            Connection con = DriverManager.getConnection(connectionString);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /*
    public String getConnectionURL() {
        //return "jdbc:mysql://localhost/media_manager?" +
        //        "user=root&password=!passw0rd@DB";
        return getServletContext().getInitParameter("databaseURL") +
                getServletContext().getInitParameter("queryString");
    } */
    
    public Connection getCon() {
        return this.con;
    }
    
    public boolean doesQueryExecute(String sql) {
        try {
            Statement sth = null;
            sth = this.con.createStatement();
            boolean b = sth.execute(sql);
            return b;
            /*
            if (n == -1) {
                return false;
            } */
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        //return true;
    }
    
    public boolean closeConnection() {
        try {
            if (this.con != null) {
                if (!this.con.isClosed()) {
                    this.con.close();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean isConnected() {
        return this.con != null;
    }
    
    public UserDetails getUserDetails(String u, String p) {
        UserDetails user = new UserDetails();
        try {
            String sql = "select * from userdetails where username = ? and password = ?";
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setString(1, u);
            sth.setString(2, p);
            ResultSet result = sth.executeQuery();
            if (result.next()) {
                user.setUsername(result.getString("username"));
                user.setAuthlevel(result.getInt("authlevel"));
            } else {
                return user;
            }
        } catch(SQLException e) {
            
        }
        return user;
    }
    
    public ArrayList<MediaItem> getNonCross() {
        ArrayList<MediaItem> noxref = new ArrayList<MediaItem>();
        String sql = "select mi.item_id, mi.`name` from mediaitem mi left join " +
                     "purchaseinfomediaitem pimi on mi.item_id = pimi.item_id " +
                     "where pimi.item_id is null;";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while (result.next()) {
                MediaItem mi = new MediaItem();
                mi.setItemID(result.getInt("ITEM_ID"));
                mi.setName(result.getString("Name"));
                noxref.add(mi);
            }
            if (noxref.isEmpty()) {
                noxref = null;
            }
        } catch(SQLException e) {
            
        }
        return noxref;
    }
    
    public ArrayList<Genre> getDBGenres() {
        ArrayList<Genre> genreList = new ArrayList<Genre>();
        String sql = "call spGetGenres();";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while (result.next()) {
                Genre genre = new Genre();
                genre.setGenreID(result.getInt("GENRE_ID"));
                genre.setGenreDescription(result.getString("GenreDescription"));
                genreList.add(genre);
            }
        } catch(SQLException e) {
            
        }
        return genreList;
    }
    
    public void addRecord(String[] args) {
        String table = args[0];
        String sql = "";
        if (table.equals("genre")) {
            sql += "insert into genre (GenreDescription) values (?);";
        } else if (table.equals("mediatype")) {
            sql += "insert into mediatype (mediatypedescription) values (?);";
        } else if (table.equals("purchaseinfo")) {
            sql += "insert into purchaseinfo (PurchaseLocation) values (?);";
        } else if (table.equals("purchaseinfomediaitem")) {
            sql += "insert into purchaseinfomediaitem (PurchasePrice, PurchaseDate, LOCATION_ID, ITEM_ID) values(?, ?, ?, ?);";
        } else {
            sql += "insert into mediaitem (GENRE_ID, MEDIA_ID, Year, CurrentValue, Comments, Name) values (?, ?, ?, ?, ?, ?)";
        }
        try{
            PreparedStatement sth = this.con.prepareStatement(sql);
            if (table.equals("genre") || table.equals("mediatype") || table.equals("purchaseinfo")) {
                sth.setString(1, args[1]);
            } else if (table.equals("purchaseinfomediaitem")) {
                sth.setDouble(1, new Double(args[3]));
                sth.setString(2, args[4]);
                sth.setInt(3, new Integer(args[2]));
                sth.setInt(4, new Integer(args[1]));
            } else {
                sth.setInt(1, new Integer(args[2]));
                sth.setInt(2, new Integer(args[3]));
                sth.setInt(3, new Integer(args[4]));
                sth.setDouble(4, new Double(args[5]));
                sth.setString(5, args[6]);
                sth.setString(6, args[1]);
            }
            sth.executeUpdate();
        } catch(SQLException e) {
            
        }
    }
    
    public void editRecord(String[] args) {
        String table = args[0];
        int id = new Integer(args[1]);
        String name = args[2];
        String sql = "";
        if (table.equals("genre")) {
            sql += "update genre set GenreDescription = ? where GENRE_ID = ?;";
        } else if (table.equals("mediatype")) {
            sql += "update mediatype set mediatypedescription = ? where MEDIA_ID = ?;";
        } else if (table.equals("purchaseinfo")) {
            sql += "update purchaseinfo set purchaselocation = ? where LOCATION_ID = ?;";
        }
        try{
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setString(1, name);
            sth.setInt(2, id);
            sth.executeUpdate();
        } catch(SQLException e) {
            
        }
    }
    
    public void deleteRecord(String[] args) {
        String table = args[0];
        String id = args[1];
        String sql = "";
        if (table.equals("genre")) {
            sql += "delete from genre where GENRE_ID = ?;";
        } else if (table.equals("mediatype")) {
            sql += "delete from mediatype where MEDIA_ID = ?;";
        } else if (table.equals("purchaseinfo")) {
            sql += "delete from purchaseinfo where LOCATION_ID = ?";
        } else if (table.equals("purchaseinfomediaitem")) {
            sql += "delete from purchaseinfomediaitem where PURCHASE_ID = ?";
        } else {
            sql += "delete from mediaitem where ITEM_ID = ?;";
        }
        try{
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setInt(1, new Integer(id));
            sth.executeUpdate();
        } catch(SQLException e) {
            
        }
    }
    
    public PurchaseInfoMediaItem getPurchaseInfo(String id) {
        PurchaseInfoMediaItem item = new PurchaseInfoMediaItem();
        String sql = "select * from purchaseinfomediaitem where purchase_id = ?;";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setInt(1, new Integer(id));
            ResultSet result = sth.executeQuery();
            if (result.next()) {
                item.setPurchaseID(result.getInt("PURCHASE_ID"));
                item.setPurchasePrice(result.getDouble("PurchasePrice"));
                item.setPurchaseDate(result.getString("PurchaseDate"));
                item.setLocationID(result.getInt("LOCATION_ID"));
                item.setItemID(result.getInt("ITEM_ID"));
            }
        } catch (SQLException e) {
            
        }
        
        return item;
    }
    
    public ArrayList<MediaType> getDBMediaTypes() {
        ArrayList<MediaType> typeList = new ArrayList<MediaType>();
        String sql = "call spGetMediaTypes();";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while (result.next()) {
                MediaType mt = new MediaType();
                mt.setMediaID(result.getInt("MEDIA_ID"));
                mt.setMediaTypeDescription(result.getString("MediaTypeDescription"));
                typeList.add(mt);
            }
        } catch(SQLException e) {
            
        }
        return typeList;
    }
    
    public ArrayList<PurchaseInfoItemCrossRef> getDBPIXref() {
        ArrayList<PurchaseInfoItemCrossRef> xrefList = new ArrayList<PurchaseInfoItemCrossRef>();
        String sql = "select pimi.PURCHASE_ID, mi.`Name` from purchaseinfomediaitem " +
                     "pimi join mediaitem mi on pimi.ITEM_ID = mi.ITEM_ID;";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while (result.next()) {
                PurchaseInfoItemCrossRef xref = new PurchaseInfoItemCrossRef();
                xref.setPurchaseID(result.getInt("PURCHASE_ID"));
                xref.setItemName(result.getString("Name"));
                xrefList.add(xref);
            }
        } catch (SQLException e) {
            
        }
        return xrefList;
    }
    
    public ArrayList<PurchaseInfo> getDBPurchaseInfo() {
        ArrayList<PurchaseInfo> locList = new ArrayList<PurchaseInfo>();
        String sql = "call spGetPurchaseInfo();";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while(result.next()) {
                PurchaseInfo pi = new PurchaseInfo();
                pi.setLocationID(result.getInt("LOCATION_ID"));
                pi.setPurchaseLocation(result.getString("PurchaseLocation"));
                locList.add(pi);
            }
        } catch(SQLException e) {
            
        }
        return locList;
    }
    
    public ArrayList<MediaItem> getDBMediaItem() {
        ArrayList<MediaItem> itemList = new ArrayList<MediaItem>();
        String sql = "select * from mediaitem;";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while(result.next()) {
                MediaItem mi = new MediaItem();
                mi.setItemID(result.getInt("ITEM_ID"));
                mi.setMediaID(result.getInt("MEDIA_ID"));
                mi.setGenreID(result.getInt("GENRE_ID"));
                mi.setName(result.getString("Name"));
                mi.setYear(result.getInt("Year"));
                mi.setComments(result.getString("Comments"));
                mi.setCurrentValue(result.getDouble("CurrentValue"));
                itemList.add(mi);
            }
        } catch(SQLException e) {
            
        }
        return itemList;
    }
    
    public ArrayList<V_Items> getItemDetails(int id) {
        ArrayList<V_Items> items = new ArrayList<V_Items>();
        try {
            String sql = "select mi.`name`, mt.mediatypedescription, g.genredescription, " +
                         "mi.`year`, pimi.purchasedate, mi.currentvalue, pimi.purchaseprice, " +
                         "mi.comments, pi.purchaselocation from mediaitem mi join mediatype mt " +
                         "on mi.media_id = mt.media_id join genre g on mi.genre_id = g.genre_id " +
                         "left join purchaseinfomediaitem pimi on mi.item_id = pimi.item_id left join " +
                         "purchaseinfo pi on pimi.location_id = pi.location_id where mi.item_id = ?";
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setInt(1, id);
            ResultSet result = sth.executeQuery();
            items = buildItems(result);
        } catch (SQLException e) {
            
        }
        return items;
    }
    
    public ArrayList<V_Items> getSearchItems(String name) {
        ArrayList<V_Items> items = new ArrayList<V_Items>();
        try {
            String sql = "call spGetSearchItems(?);";
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setString(1, name);
            ResultSet result = sth.executeQuery();
            items = buildItems(result);
        } catch (SQLException e) {
            
        }
        return items;
    }
    
    public ArrayList<V_Items> getItemDetailsByGenre(int id) {
        ArrayList<V_Items> items = new ArrayList<V_Items>();
        try {
            String sql = "call spGetItemDetailsByGenre(?);";
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setInt(1, id);
            ResultSet result = sth.executeQuery();
            items = buildItems(result);
        } catch (SQLException e) {
            
        }
        return items;
    }
    
    public ArrayList<V_Items> getItemDetailsByMediaType(int id) {
        ArrayList<V_Items> items = new ArrayList<V_Items>();
        try {
            String sql = "call spGetItemDetailsByMediaType(?);";
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setInt(1, id);
            ResultSet result = sth.executeQuery();
            items = buildItems(result);
        } catch (SQLException e) {
            
        }
        return items;
    }
    
    public ArrayList<V_Items> getItemDetailsByPurchaseInfo( int id) {
        ArrayList<V_Items> items = new ArrayList<V_Items>();
        try {
            String sql = "call spGetItemDetailsByPurchaseLocation(?);";
            PreparedStatement sth = this.con.prepareStatement(sql);
            sth.setInt(1, id);
            ResultSet result = sth.executeQuery();
            items = buildItems(result);
        } catch (SQLException e) {
            
        }
        return items;
    }
    
    public Hashtable getGenreCounts() {
        Hashtable genres = new Hashtable();
        String sql = "call spGetGenres();";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while(result.next()) {
                Genre genre = new Genre();
                genre.setGenreID(result.getInt("genre_id"));
                genre.setGenreDescription(result.getString("genredescription"));
                genres.put(genre, result.getInt("item_count"));
            }
        } catch(SQLException e) {
            
        }
        return genres;
    }
    
    public Hashtable getMediaTypeCounts() {
        Hashtable mediaItems = new Hashtable();
        String sql = "call spGetMediaTypes();";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while(result.next()) {
                MediaType i = new MediaType();
                i.setMediaID(result.getInt("media_id"));
                i.setMediaTypeDescription(result.getString("mediatypedescription"));
                mediaItems.put(i, result.getInt("item_count"));
            }
        } catch(SQLException e) {
            
        }
        return mediaItems;
    }
    
    public Hashtable getPurchaseInfoCounts() {
        Hashtable purchaseInfo = new Hashtable();
        String sql = "call spGetPurchaseInfo();";
        try {
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while(result.next()) {
                PurchaseInfo p = new PurchaseInfo();
                p.setLocationID(result.getInt("location_id"));
                p.setPurchaseLocation(result.getString("purchaselocation"));
                purchaseInfo.put(p, result.getInt("item_count"));
            }
        } catch(SQLException e) {
            
        }
        return purchaseInfo;
    }
    
    public ArrayList<V_Items> getMediaItems() {
        ArrayList<V_Items> items = new ArrayList<V_Items>();
        try {
            String sql = "select mi.item_id, mi.`name`, mt.mediatypedescription, g.genredescription, " +
                         "mi.comments from mediaitem mi join mediatype mt on mi.media_id = " +
                         "mt.media_id join genre g on mi.genre_id = g.genre_id order by mi.`name`;";
            PreparedStatement sth = this.con.prepareStatement(sql);
            ResultSet result = sth.executeQuery();
            while (result.next()) {
                V_Items item = new V_Items();
                item.setItemID(result.getInt("item_id"));
                item.setName(result.getString("name"));
                item.setMediaTypeDescription(result.getString("mediatypedescription"));
                item.setGenreDescription(result.getString("genredescription"));
                item.setComments(result.getString("comments"));
                items.add(item);
            }
        } catch (Exception e) {
            
        }
        return items;
    }
    
    public ArrayList<V_Items> buildItems(ResultSet result) {
        ArrayList<V_Items> items = new ArrayList<V_Items>();
        try {
            while (result.next()) {
                V_Items item = new V_Items();
                item.setName(result.getString("name"));
                item.setMediaTypeDescription(result.getString("mediatypedescription"));
                item.setGenreDescription(result.getString("genredescription"));
                item.setYear(new Integer(result.getInt("year")));
                item.setCurrentValue(new Double(result.getDouble("currentvalue")));
                item.setComments(result.getString("comments"));
                item.setPurchasePrice(new Double(result.getDouble("purchaseprice")));
                item.setPurchaseLocation(result.getString("purchaselocation"));
                item.setPurchaseDate(result.getDate("purchasedate").toString());
                items.add(item);
            }
            
        } catch(SQLException e) {
                
        }
        return items;
    }
}
