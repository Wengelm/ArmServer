package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "code")
public class CodeAmortization implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String text;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "codeAmortization")
    private Assets assets;

    public CodeAmortization() {
    }

    public CodeAmortization(String code, String text, Assets assets) {
        this.code = code;
        this.text = text;
        this.assets = assets;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public Assets getAssets() {
        return assets;
    }
}
