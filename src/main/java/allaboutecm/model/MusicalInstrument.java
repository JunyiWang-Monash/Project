package allaboutecm.model;

import jdk.nashorn.internal.objects.annotations.Property;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;
import static org.apache.commons.lang3.Validate.notNull;

@NodeEntity
public class MusicalInstrument extends Entity {

    @Property(name = "nameOfInstrument")
    private String name;

    public MusicalInstrument() {
    }

    public MusicalInstrument(String name) {
        notNull(name,"Musical instrument name cannot be null");
        notBlank(name,"Musical instrument name cannot be empty or blank");
        if (name.length() >= 40){
            throw new IllegalArgumentException();
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        notNull(name,"Musical instrument name cannot be null");
        notBlank(name,"Musical instrument name cannot be empty or blank");
        if (name.length() >= 40){
            throw new IllegalArgumentException();
        }
        this.name = name.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicalInstrument that = (MusicalInstrument) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
