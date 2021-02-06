package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "asset")
public class Assets implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id",insertable = false, updatable = false)
    private CodeAmortization codeAmortization;
    @Column(name = "percent_amo")
    private String percentAmortization;
    @Column(name = "type_assets")
    private String typeAssets;
    @Column(name="balance_cost")
    private String balanceCost;
    @Column(name = "month_amort")
    private String monthAmortization;
    @Column(name = "dep_amount")
    private String deplicrationAmount;
    @Column(name = "date_start")
    private String dateStart;
    @Column(name = "ost_cost")
    private String ostCost;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",insertable = false, updatable = false)
    private RespPerson person;

    public Assets() {
    }

    public Assets(String name, CodeAmortization codeAmortization, String percentAmortization, String typeAssets, String balanceCost, String monthAmortization, String deplicrationAmount, String dateStart, String ostCost, RespPerson person) {
        this.name = name;
        this.codeAmortization = codeAmortization;
        this.percentAmortization = percentAmortization;
        this.typeAssets = typeAssets;
        this.balanceCost = balanceCost;
        this.monthAmortization = monthAmortization;
        this.deplicrationAmount = deplicrationAmount;
        this.dateStart = dateStart;
        this.ostCost = ostCost;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CodeAmortization getCodeAmortization() {
        return codeAmortization;
    }

    public void setCodeAmortization(CodeAmortization codeAmortization) {
        this.codeAmortization = codeAmortization;
    }

    public String getPercentAmortization() {
        return percentAmortization;
    }

    public void setPercentAmortization(String percentAmortization) {
        this.percentAmortization = percentAmortization;
    }

    public String getTypeAssets() {
        return typeAssets;
    }

    public void setTypeAssets(String typeAssets) {
        this.typeAssets = typeAssets;
    }

    public String getBalanceCost() {
        return balanceCost;
    }

    public void setBalanceCost(String balanceCost) {
        this.balanceCost = balanceCost;
    }

    public String getMonthAmortization() {
        return monthAmortization;
    }

    public void setMonthAmortization(String monthAmortization) {
        this.monthAmortization = monthAmortization;
    }

    public String getDeplicrationAmount() {
        return deplicrationAmount;
    }

    public void setDeplicrationAmount(String deplicrationAmount) {
        this.deplicrationAmount = deplicrationAmount;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getOstCost() {
        return ostCost;
    }

    public void setOstCost(String ostCost) {
        this.ostCost = ostCost;
    }

    public RespPerson getPerson() {
        return person;
    }

    public void setPerson(RespPerson person) {
        this.person = person;
    }
}
