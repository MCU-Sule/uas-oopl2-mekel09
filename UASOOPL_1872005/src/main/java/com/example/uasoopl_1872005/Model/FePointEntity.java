package com.example.uasoopl_1872005.Model;

import javax.persistence.*;
import java.util.Objects;
/**Michael Sebastian Gunadi-1872005*/

@Entity
@Table(name = "fe_point", schema = "oopl20211", catalog = "")
public class FePointEntity {
    private int id;
    private int value;
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
    @Column(name = "value")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
        FePointEntity that = (FePointEntity) o;
        return id == that.id && value == that.value && Objects.equals(memberCitizenId, that.memberCitizenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, memberCitizenId);
    }
}
