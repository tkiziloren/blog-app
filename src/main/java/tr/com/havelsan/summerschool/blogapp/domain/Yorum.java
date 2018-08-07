/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.com.havelsan.summerschool.blogapp.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "yorum")
@NamedQueries({
    @NamedQuery(name = "Yorum.findAll", query = "SELECT y FROM Yorum y"),
    @NamedQuery(name = "Yorum.findByYorumID", query = "SELECT y FROM Yorum y WHERE y.yorumID = :yorumID"),
    @NamedQuery(name = "Yorum.findByYorumBaslik", query = "SELECT y FROM Yorum y WHERE y.yorumBaslik = :yorumBaslik"),
    @NamedQuery(name = "Yorum.findByYorumTarih", query = "SELECT y FROM Yorum y WHERE y.yorumTarih = :yorumTarih")})
public class Yorum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "YorumID")
    private Integer yorumID;
    @Basic(optional = false)
    @Column(name = "YorumBaslik")
    private String yorumBaslik;
    @Basic(optional = false)
    @Lob
    @Column(name = "YorumIcerik")
    private String yorumIcerik;
    @Basic(optional = false)
    @Column(name = "YorumTarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date yorumTarih;
    @JoinColumn(name = "GirdiID", referencedColumnName = "GirdiID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Girdi girdiID;
    @JoinColumn(name = "KullaniciID", referencedColumnName = "KullaniciID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kullanici kullaniciID;

    public Yorum() {
    }

    public Yorum(Integer yorumID) {
        this.yorumID = yorumID;
    }

    public Yorum(Integer yorumID, String yorumBaslik, String yorumIcerik, Date yorumTarih) {
        this.yorumID = yorumID;
        this.yorumBaslik = yorumBaslik;
        this.yorumIcerik = yorumIcerik;
        this.yorumTarih = yorumTarih;
    }

    public Integer getYorumID() {
        return yorumID;
    }

    public void setYorumID(Integer yorumID) {
        this.yorumID = yorumID;
    }

    public String getYorumBaslik() {
        return yorumBaslik;
    }

    public void setYorumBaslik(String yorumBaslik) {
        this.yorumBaslik = yorumBaslik;
    }

    public String getYorumIcerik() {
        return yorumIcerik;
    }

    public void setYorumIcerik(String yorumIcerik) {
        this.yorumIcerik = yorumIcerik;
    }

    public Date getYorumTarih() {
        return yorumTarih;
    }

    public void setYorumTarih(Date yorumTarih) {
        this.yorumTarih = yorumTarih;
    }

    public Girdi getGirdiID() {
        return girdiID;
    }

    public void setGirdiID(Girdi girdiID) {
        this.girdiID = girdiID;
    }

    public Kullanici getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Kullanici kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yorumID != null ? yorumID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yorum)) {
            return false;
        }
        Yorum other = (Yorum) object;
        if ((this.yorumID == null && other.yorumID != null) || (this.yorumID != null && !this.yorumID.equals(other.yorumID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Yorum[yorumID=" + yorumID + "]";
    }

}
