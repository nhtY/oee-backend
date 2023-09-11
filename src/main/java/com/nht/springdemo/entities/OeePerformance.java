package com.nht.springdemo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;

import java.util.Objects;

// Getter
// Setter
// Builder
// RequiredArgsConstructor
// NoArgsConstructor
@Entity
public class OeePerformance {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", type = org.hibernate.id.IncrementGenerator.class)
    private Long id;

    @NonNull
    private Double ggOee;
    @NonNull
    private Double gOee1s;
    @NonNull
    private Double ttGp;
    @NonNull
    private Double ttGg;
    @NonNull
    private Double tt1s;
    @NonNull
    private Integer redTamir;
    @NonNull
    private Integer farkliUrun;
    @NonNull
    private Integer urunGrubu;

    public OeePerformance(Long id, @NonNull Double ggOee, @NonNull Double gOee1s,
                          @NonNull Double ttGp, @NonNull Double ttGg, @NonNull Double tt1s,
                          @NonNull Integer redTamir, @NonNull Integer farkliUrun,
                          @NonNull Integer urunGrubu) {
        this.id = id;
        this.ggOee = ggOee;
        this.gOee1s = gOee1s;
        this.ttGp = ttGp;
        this.ttGg = ttGg;
        this.tt1s = tt1s;
        this.redTamir = redTamir;
        this.farkliUrun = farkliUrun;
        this.urunGrubu = urunGrubu;
    }

    public OeePerformance() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public Double getGgOee() {
        return ggOee;
    }

    public void setGgOee(@NonNull Double ggOee) {
        this.ggOee = ggOee;
    }

    @NonNull
    public Double getgOee1s() {
        return gOee1s;
    }

    public void setgOee1s(@NonNull Double gOee1s) {
        this.gOee1s = gOee1s;
    }

    @NonNull
    public Double getTtGp() {
        return ttGp;
    }

    public void setTtGp(@NonNull Double ttGp) {
        this.ttGp = ttGp;
    }

    @NonNull
    public Double getTtGg() {
        return ttGg;
    }

    public void setTtGg(@NonNull Double ttGg) {
        this.ttGg = ttGg;
    }

    @NonNull
    public Double getTt1s() {
        return tt1s;
    }

    public void setTt1s(@NonNull Double tt1s) {
        this.tt1s = tt1s;
    }

    @NonNull
    public Integer getRedTamir() {
        return redTamir;
    }

    public void setRedTamir(@NonNull Integer redTamir) {
        this.redTamir = redTamir;
    }

    @NonNull
    public Integer getFarkliUrun() {
        return farkliUrun;
    }

    public void setFarkliUrun(@NonNull Integer farkliUrun) {
        this.farkliUrun = farkliUrun;
    }

    @NonNull
    public Integer getUrunGrubu() {
        return urunGrubu;
    }

    public void setUrunGrubu(@NonNull Integer urunGrubu) {
        this.urunGrubu = urunGrubu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OeePerformance that = (OeePerformance) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!ggOee.equals(that.ggOee)) return false;
        if (!gOee1s.equals(that.gOee1s)) return false;
        if (!ttGp.equals(that.ttGp)) return false;
        if (!ttGg.equals(that.ttGg)) return false;
        if (!tt1s.equals(that.tt1s)) return false;
        if (!redTamir.equals(that.redTamir)) return false;
        if (!farkliUrun.equals(that.farkliUrun)) return false;
        return urunGrubu.equals(that.urunGrubu);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + ggOee.hashCode();
        result = 31 * result + gOee1s.hashCode();
        result = 31 * result + ttGp.hashCode();
        result = 31 * result + ttGg.hashCode();
        result = 31 * result + tt1s.hashCode();
        result = 31 * result + redTamir.hashCode();
        result = 31 * result + farkliUrun.hashCode();
        result = 31 * result + urunGrubu.hashCode();
        return result;
    }

    public static OeePerformanceBuilder builder() {
        return new OeePerformanceBuilder();
    }

    public static class OeePerformanceBuilder {
        private Long id;
        private Double ggOee;
        private Double gOee1s;
        private Double ttGp;
        private Double ttGg;
        private Double tt1s;
        private Integer redTamir;
        private Integer farkliUrun;
        private Integer urunGrubu;

        OeePerformanceBuilder() {

        }

        public OeePerformanceBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OeePerformanceBuilder ggOee(Double ggOee) {
            this.ggOee = ggOee;
            return this;
        }

        public OeePerformanceBuilder gOee1s(Double gOee1s) {
            this.gOee1s = gOee1s;
            return this;
        }

        public OeePerformanceBuilder ttGp(Double ttGp) {
            this.ttGp = ttGp;
            return this;
        }

        public OeePerformanceBuilder ttGg(Double ttGg) {
            this.ttGg = ttGg;
            return this;
        }

        public OeePerformanceBuilder tt1s(Double tt1s) {
            this.tt1s = tt1s;
            return this;
        }

        public OeePerformanceBuilder redTamir(Integer redTamir) {
            this.redTamir = redTamir;
            return this;
        }

        public OeePerformanceBuilder farkliUrun(Integer farkliUrun) {
            this.farkliUrun = farkliUrun;
            return this;
        }

        public OeePerformanceBuilder urunGrubu(Integer urunGrubu) {
            this.urunGrubu = urunGrubu;
            return this;
        }

        public OeePerformance build() {
            return new OeePerformance(this.id, this.ggOee, this.gOee1s, this.ttGp, this.ttGg,
                    this.tt1s, this.redTamir, this.farkliUrun, this.urunGrubu);
        }

    }

    @Override
    public String toString() {
        return "OeePerformance{" +
                "id=" + id +
                ", ggOee=" + ggOee +
                ", gOee1s=" + gOee1s +
                '}';
    }
}
