
package com.citybus.entidades;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bluesprogrammer
 */
@XmlRootElement
public class Localizacao {
    
    private int idOnibus;
    private double lat;
    private double longi;

    public Localizacao() {
    }

    public Localizacao(int idOnibus, double lat, double longi) {
        this.idOnibus = idOnibus;
        this.lat = lat;
        this.longi = longi;
    }
  
    public int getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(int idOnibus) {
        this.idOnibus = idOnibus;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLongi() {
        return longi;
    }

    public void setLongi(double longi) {
        this.longi = longi;
    }
    
    
}
