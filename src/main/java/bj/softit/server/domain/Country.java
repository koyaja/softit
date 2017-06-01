package bj.softit.server.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Country.
 */
@Entity
@Table(name = "country")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "countryname", nullable = false)
    private String countryname;

    @NotNull
    @Column(name = "countrycode", nullable = false)
    private String countrycode;

    @OneToOne(mappedBy = "country")
    @JsonIgnore
    private Client clients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryname() {
        return countryname;
    }

    public Country countryname(String countryname) {
        this.countryname = countryname;
        return this;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public Country countrycode(String countrycode) {
        this.countrycode = countrycode;
        return this;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public Client getClients() {
        return clients;
    }

    public Country clients(Client client) {
        this.clients = client;
        return this;
    }

    public void setClients(Client client) {
        this.clients = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Country country = (Country) o;
        if (country.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), country.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Country{" +
            "id=" + getId() +
            ", countryname='" + getCountryname() + "'" +
            ", countrycode='" + getCountrycode() + "'" +
            "}";
    }
}
