package com.example.uasoopl_1872005.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
/**Michael Sebastian Gunadi-1872005*/

@Entity
@Table(name = "fe_transaction", schema = "oopl20211", catalog = "")
public class FeTransactionEntity {
    private int id;
    private Date transDate;
    private String nominal;
    private String memberCitizenId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "trans_date")
    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    @Basic
    @Column(name = "nominal")
    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    @Basic
    @Column(name = "member_citizenId")
    public String getMemberCitizenId() {
        return memberCitizenId;
    }

    public void setMemberCitizenId(String memberCitizenId) {
        this.memberCitizenId = memberCitizenId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeTransactionEntity that = (FeTransactionEntity) o;
        return id == that.id && nominal == that.nominal && Objects.equals(transDate, that.transDate) && Objects.equals(memberCitizenId, that.memberCitizenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transDate, nominal, memberCitizenId);
    }
}
