/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author vl
 */
@Entity
@Table(name = "elements")
@NamedQueries({
    @NamedQuery(name = "Elements.findAll", query = "SELECT e FROM Elements e")})
public class Elements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "elementid")
    private Integer elementid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;

    public Elements() {
    }

    public Elements(Integer elementid) {
        this.elementid = elementid;
    }

    public Elements(Integer elementid, String name) {
        this.elementid = elementid;
        this.name = name;
    }

    public Integer getElementid() {
        return elementid;
    }

    public void setElementid(Integer elementid) {
        this.elementid = elementid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (elementid != null ? elementid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elements)) {
            return false;
        }
        Elements other = (Elements) object;
        if ((this.elementid == null && other.elementid != null) || (this.elementid != null && !this.elementid.equals(other.elementid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Elements[ elementid=" + elementid + " ]";
    }
    
}
