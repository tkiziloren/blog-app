/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tr.com.havelsan.summerschool.blogapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author User
 */
@Entity
@Table(name = "girdi")
@NamedQueries({
    @NamedQuery(name = "Girdi.findAll", query = "SELECT g FROM Girdi g"),
    @NamedQuery(name = "Girdi.findByGirdiID", query = "SELECT g FROM Girdi g WHERE g.girdiID = :girdiID"),
    @NamedQuery(name = "Girdi.findByGirdiBaslik", query = "SELECT g FROM Girdi g WHERE g.girdiBaslik = :girdiBaslik"),
    @NamedQuery(name = "Girdi.findByGirdiTarih", query = "SELECT g FROM Girdi g WHERE g.girdiTarih = :girdiTarih")})
public class Girdi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GirdiID")
    private Integer girdiID;
    @Basic(optional = false)
    @Column(name = "GirdiBaslik")
    private String girdiBaslik;
    @Basic(optional = false)
    @Lob
    @Column(name = "GirdiIcerik")
    private String girdiIcerik;
    @Basic(optional = false)
    @Column(name = "GirdiTarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date girdiTarih;
    @JoinColumn(name = "BlogID", referencedColumnName = "BlogID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Blog blogID;
    @JoinColumn(name = "KullaniciID", referencedColumnName = "KullaniciID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kullanici kullaniciID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "girdiID", fetch = FetchType.LAZY)
    private List<Yorum> yorumList;

    public Girdi() {
    }

    public Girdi(Integer girdiID) {
        this.girdiID = girdiID;
    }

    public Girdi(Integer girdiID, String girdiBaslik, String girdiIcerik, Date girdiTarih) {
        this.girdiID = girdiID;
        this.girdiBaslik = girdiBaslik;
        this.girdiIcerik = girdiIcerik;
        this.girdiTarih = girdiTarih;
    }

    public Integer getGirdiID() {
        return girdiID;
    }

    public void setGirdiID(Integer girdiID) {
        this.girdiID = girdiID;
    }

    public String getGirdiBaslik() {
        return girdiBaslik;
    }

    public void setGirdiBaslik(String girdiBaslik) {
        this.girdiBaslik = girdiBaslik;
    }

    public String getGirdiIcerik() {
        return girdiIcerik;
    }

    public void setGirdiIcerik(String girdiIcerik) {
        this.girdiIcerik = girdiIcerik;
    }

    public Date getGirdiTarih() {
        return girdiTarih;
    }

    public void setGirdiTarih(Date girdiTarih) {
        this.girdiTarih = girdiTarih;
    }

    public Blog getBlogID() {
        return blogID;
    }

    public void setBlogID(Blog blogID) {
        this.blogID = blogID;
    }

    public Kullanici getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Kullanici kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public List<Yorum> getYorumList() {
        return yorumList;
    }

    public void setYorumList(List<Yorum> yorumList) {
        this.yorumList = yorumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (girdiID != null ? girdiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Girdi)) {
            return false;
        }
        Girdi other = (Girdi) object;
        if ((this.girdiID == null && other.girdiID != null) || (this.girdiID != null && !this.girdiID.equals(other.girdiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Girdi[girdiID=" + girdiID + "]";
    }

}
