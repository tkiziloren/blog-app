
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
@Table(name = "blog")
@NamedQueries({
    @NamedQuery(name = "Blog.findAll", query = "SELECT b FROM Blog b"),
    @NamedQuery(name = "Blog.findByBlogID", query = "SELECT b FROM Blog b WHERE b.blogID = :blogID"),
    @NamedQuery(name = "Blog.findByBlogBaslik", query = "SELECT b FROM Blog b WHERE b.blogBaslik = :blogBaslik"),
    @NamedQuery(name = "Blog.findByAciklama", query = "SELECT b FROM Blog b WHERE b.aciklama = :aciklama"),
    @NamedQuery(name = "Blog.findByOlusturmaTarih", query = "SELECT b FROM Blog b WHERE b.olusturmaTarih = :olusturmaTarih")})
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BlogID")
    private Integer blogID;
    @Basic(optional = false)
    @Column(name = "BlogBaslik")
    private String blogBaslik;
    @Basic(optional = false)
    @Column(name = "Aciklama")
    private String aciklama;
    @Column(name = "OlusturmaTarih")
    @Temporal(TemporalType.TIMESTAMP)
    private Date olusturmaTarih;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blogID", fetch = FetchType.LAZY)
    private List<Girdi> girdiList;
    @JoinColumn(name = "KullaniciID", referencedColumnName = "KullaniciID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kullanici kullaniciID;

    public Blog() {
    }

    public Blog(Integer blogID) {
        this.blogID = blogID;
    }

    public Blog(Integer blogID, String blogBaslik, String aciklama) {
        this.blogID = blogID;
        this.blogBaslik = blogBaslik;
        this.aciklama = aciklama;
    }

    public Integer getBlogID() {
        return blogID;
    }

    public void setBlogID(Integer blogID) {
        this.blogID = blogID;
    }

    public String getBlogBaslik() {
        return blogBaslik;
    }

    public void setBlogBaslik(String blogBaslik) {
        this.blogBaslik = blogBaslik;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getOlusturmaTarih() {
        return olusturmaTarih;
    }

    public void setOlusturmaTarih(Date olusturmaTarih) {
        this.olusturmaTarih = olusturmaTarih;
    }

    public List<Girdi> getGirdiList() {
        return girdiList;
    }

    public void setGirdiList(List<Girdi> girdiList) {
        this.girdiList = girdiList;
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
        hash += (blogID != null ? blogID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blog)) {
            return false;
        }
        Blog other = (Blog) object;
        if ((this.blogID == null && other.blogID != null) || (this.blogID != null && !this.blogID.equals(other.blogID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Blog[blogID=" + blogID + "]";
    }

}
