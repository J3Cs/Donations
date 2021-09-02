/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.j3cs.Telus.donations.domain;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juliocardona
 */
@Entity
@Table(name = "donation", catalog = "donation", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donation.findAll", query = "SELECT d FROM Donation d"),
    @NamedQuery(name = "Donation.findByAmount", query = "SELECT d FROM Donation d WHERE d.amount = :amount"),
    @NamedQuery(name = "Donation.findByDonationDate", query = "SELECT d FROM Donation d WHERE d.donationDate = :donationDate"),
    @NamedQuery(name = "Donation.findByIdDonation", query = "SELECT d FROM Donation d WHERE d.idDonation = :idDonation")})
public class Donation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount", precision = 22, scale = 0)
    private Double amount;
    @Column(name = "donation_date")
    @Temporal(TemporalType.DATE)
    private Date donationDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_donation", nullable = false)
    private Integer idDonation;
    @JoinColumn(name = "id_institution", referencedColumnName = "id_institution")
    @ManyToOne(fetch = FetchType.LAZY)
    private Institution idInstitution;

    public Donation() {
    }

    public Donation(Integer idDonation) {
        this.idDonation = idDonation;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public Integer getIdDonation() {
        return idDonation;
    }

    public void setIdDonation(Integer idDonation) {
        this.idDonation = idDonation;
    }

    public Institution getIdInstitution() {
        return idInstitution;
    }

    public void setIdInstitution(Institution idInstitution) {
        this.idInstitution = idInstitution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDonation != null ? idDonation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donation)) {
            return false;
        }
        Donation other = (Donation) object;
        if ((this.idDonation == null && other.idDonation != null) || (this.idDonation != null && !this.idDonation.equals(other.idDonation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.j3cs.Telus.donations.domain.Donation[ idDonation=" + idDonation + " ]";
    }
    
}
