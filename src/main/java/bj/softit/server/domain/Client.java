package bj.softit.server.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Client.
 */
@Entity
@Table(name = "client")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "signature")
    private String signature;

    @Column(name = "apigetwayurl")
    private String apigetwayurl;

    @OneToOne
    @JoinColumn(unique = true)
    private Country country;

    @ManyToOne
    private Groupe groupe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Client name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public Client signature(String signature) {
        this.signature = signature;
        return this;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getApigetwayurl() {
        return apigetwayurl;
    }

    public Client apigetwayurl(String apigetwayurl) {
        this.apigetwayurl = apigetwayurl;
        return this;
    }

    public void setApigetwayurl(String apigetwayurl) {
        this.apigetwayurl = apigetwayurl;
    }

    public Country getCountry() {
        return country;
    }

    public Client country(Country country) {
        this.country = country;
        return this;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public Client groupe(Groupe groupe) {
        this.groupe = groupe;
        return this;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        if (client.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Client{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", signature='" + getSignature() + "'" +
            ", apigetwayurl='" + getApigetwayurl() + "'" +
            "}";
    }
}
