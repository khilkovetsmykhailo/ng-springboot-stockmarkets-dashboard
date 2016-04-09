package io.lingani.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by linx on 2015-08-10.
 */
@Entity
public class Sector implements java.io.Serializable {

	private static final long serialVersionUID = 7297255635910057599L;

	@Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", length = 64)
	private String name;

    public Sector() {
    }

    public Sector(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sector)) return false;

        Sector sector = (Sector) o;

        if (id != null ? !id.equals(sector.id) : sector.id != null) return false;
        return !(name != null ? !name.equals(sector.name) : sector.name != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
