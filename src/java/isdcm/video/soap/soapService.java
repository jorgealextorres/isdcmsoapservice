/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isdcm.video.soap;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import videos.Video;
import videos.VideoDAO;

/**
 *
 * @author jorgetorres
 */
@WebService(serviceName = "soapService")
@Stateless()
public class soapService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchByTitle")
    public Video[] searchByTitle(@WebParam(name = "searchText") String searchText) {
        try {
            List<Video> videos = VideoDAO.searchByTitle(searchText);
            return videos.toArray(new Video[videos.size()]);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }   
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchByAutor")
    public Video[] searchByAutor(@WebParam(name = "searchText") String searchText) {
        try {
            List<Video> videos = VideoDAO.searchByAutor(searchText);
            return videos.toArray(new Video[videos.size()]);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "searchByYear")
    public Video[] searchByYear(@WebParam(name = "searchYear") int searchYear) {
        try {
            List<Video> videos = VideoDAO.searchByYear(searchYear);
            return videos.toArray(new Video[videos.size()]);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
