/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juliocardona
 */
@Entity
@Table(name = "institution", catalog = "donation", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i"),
    @NamedQuery(name = "Institution.findByIdInstitution", query = "SELECT i FROM Institution i WHERE i.idInstitution = :idInstitution"),
    @NamedQuery(name = "Institution.findByName", query = "SELECT i FROM Institution i WHERE i.name = :name")})
public class Institution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_institution", nullable = false)
    private Integer idInstitution;
    @Column(name = "name", length = 100)
    private String name;
    @ManyToMany(mappedBy = "institutionList", fetch = FetchType.LAZY)
    private List<Country> countryList;
    @OneToMany(mappedBy = "idInstitution", fetch = FetchType.LAZY)
    private List<Donation> donationList;
    @OneToMany(mappedBy = "idInstitution", fetch = FetchType.LAZY)
    private List<User> userList;

    public Institution() {
    }

    public Institution(Integer idInstitution) {
        this.idInstitution = idInstitution;
    }

    public Integer getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Integer idInstitution) {
        this.idInstitution = idInstitution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    @XmlTransient
    public List<Donation> getDonationList() {
        return donationList;
    }

    public void setDonationList(List<Donation> donationList) {
        this.donationList = donationList;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstitution != null ? idInstitution.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        if ((this.idInstitution == null && other.idInstitution != null) || (this.idInstitution != null && !this.idInstitution.equals(other.idInstitution))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j3cs.Telus.donations.domain.Institution[ idInstitution=" + idInstitution + " ]";
    }
    
}
