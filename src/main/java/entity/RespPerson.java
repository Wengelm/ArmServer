package entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class RespPerson implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String pasport;
    @Column(name="birt_day")
    private String birrthDay;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Assets> assetsList;

    public RespPerson(String name, String lastName, String pasport, String birrthDay) {
        this.name = name;
        this.lastName = lastName;
        this.pasport = pasport;
        this.birrthDay = birrthDay;
        assetsList = new ArrayList<>();
    }

    public RespPerson() {
    }

    public void addAssets(Assets assets) {
        assets.setPerson(this);
        assetsList.add(assets);

    }

    public void removeAssets(Assets assets) {
        assetsList.remove(assets);

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public String getBirrthDay() {
        return birrthDay;
    }

    public void setBirrthDay(String birrthDay) {
        this.birrthDay = birrthDay;
    }

    public List<Assets> getAssetsList() {
        return assetsList;
    }

    public void setAssetsList(List<Assets> assetsList) {
        this.assetsList = assetsList;
    }
}
