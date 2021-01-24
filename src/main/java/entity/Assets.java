package entity;

import javax.persistence.*;

@Entity
@Table(name = "asset")
public class Assets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long inventoryNumber;
    private String name;
    private CodeAmortization codeAmortization;
    private String percentAmortization;
    private String typeAssets;
    private String balanceCost;
    private String MonthAmortization;
    private String deplicrationAmount;
    private String dateStart;
    private String ostCost;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private RespPerson person;

    public Assets(Long inventoryNumber, String name, CodeAmortization codeAmortization, String percentAmortization, String typeAssets, String balanceCost, String monthAmortization, String deplicrationAmount, String dateStart, String ostCost, RespPerson person) {
        this.inventoryNumber = inventoryNumber;
        this.name = name;
        this.codeAmortization = codeAmortization;
        this.percentAmortization = percentAmortization;
        this.typeAssets = typeAssets;
        this.balanceCost = balanceCost;
        MonthAmortization = monthAmortization;
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

    public Long getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Long inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
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
        return MonthAmortization;
    }

    public void setMonthAmortization(String monthAmortization) {
        MonthAmortization = monthAmortization;
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
