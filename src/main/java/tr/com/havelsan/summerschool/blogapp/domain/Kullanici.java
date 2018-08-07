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
@Table(name = "kullanici")
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k"),
    @NamedQuery(name = "Kullanici.findByKullaniciID", query = "SELECT k FROM Kullanici k WHERE k.kullaniciID = :kullaniciID"),
    @NamedQuery(name = "Kullanici.findByKullaniciEmail", query = "SELECT k FROM Kullanici k WHERE k.kullaniciEmail = :kullaniciEmail"),
    @NamedQuery(name = "Kullanici.findByKullaniciSifre", query = "SELECT k FROM Kullanici k WHERE k.kullaniciSifre = :kullaniciSifre"),
    @NamedQuery(name = "Kullanici.findByKullaniciAdSoyad", query = "SELECT k FROM Kullanici k WHERE k.kullaniciAdSoyad = :kullaniciAdSoyad"),
    @NamedQuery(name = "Kullanici.findByKullaniciIzin", query = "SELECT k FROM Kullanici k WHERE k.kullaniciIzin = :kullaniciIzin"),
    @NamedQuery(name = "Kullanici.findByKayitTarih", query = "SELECT k FROM Kullanici k WHERE k.kayitTarih = :kayitTarih")})
public class Kullanici implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KullaniciID")
    private Integer kullaniciID;
    @Basic(optional = false)
    @Column(name = "KullaniciEmail")
    private String kullaniciEmail;
    @Basic(optional = false)
    @Column(name = "KullaniciSifre")
    private String kullaniciSifre;
    @Basic(optional = false)
    @Column(name = "KullaniciAdSoyad")
    private String kullaniciAdSoyad;
    @Basic(optional = false)
    @Column(name = "KullaniciIzin")
    private char kullaniciIzin;
    @Column(name = "KayitTarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date kayitTarih;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciID", fetch = FetchType.LAZY)
    private List<Girdi> girdiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciID", fetch = FetchType.LAZY)
    private List<Yorum> yorumList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kullaniciID", fetch = FetchType.LAZY)
    private List<Blog> blogList;

    public Kullanici() {
    }

    public Kullanici(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public Kullanici(Integer kullaniciID, String kullaniciEmail, String kullaniciSifre, String kullaniciAdSoyad, char kullaniciIzin) {
        this.kullaniciID = kullaniciID;
        this.kullaniciEmail = kullaniciEmail;
        this.kullaniciSifre = kullaniciSifre;
        this.kullaniciAdSoyad = kullaniciAdSoyad;
        this.kullaniciIzin = kullaniciIzin;
    }

    public Integer getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getKullaniciEmail() {
        return kullaniciEmail;
    }

    public void setKullaniciEmail(String kullaniciEmail) {
        this.kullaniciEmail = kullaniciEmail;
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }

    public String getKullaniciAdSoyad() {
        return kullaniciAdSoyad;
    }

    public void setKullaniciAdSoyad(String kullaniciAdSoyad) {
        this.kullaniciAdSoyad = kullaniciAdSoyad;
    }

    public char getKullaniciIzin() {
        return kullaniciIzin;
    }

    public void setKullaniciIzin(char kullaniciIzin) {
        this.kullaniciIzin = kullaniciIzin;
    }

    public Date getKayitTarih() {
        return kayitTarih;
    }

    public void setKayitTarih(Date kayitTarih) {
        this.kayitTarih = kayitTarih;
    }

    public List<Girdi> getGirdiList() {
        return girdiList;
    }

    public void setGirdiList(List<Girdi> girdiList) {
        this.girdiList = girdiList;
    }

    public List<Yorum> getYorumList() {
        return yorumList;
    }

    public void setYorumList(List<Yorum> yorumList) {
        this.yorumList = yorumList;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciID != null ? kullaniciID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.kullaniciID == null && other.kullaniciID != null) || (this.kullaniciID != null && !this.kullaniciID.equals(other.kullaniciID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kullanici[kullaniciID=" + kullaniciID + "]";
    }

}
