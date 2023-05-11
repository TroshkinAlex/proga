package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * class with person location
 */
@AllArgsConstructor
public class Location implements Comparable<Location> {
    @Getter
    @Setter
    @NotNull
    private Integer x; //Поле не может быть null
    @Getter
    @Setter
    @NotNull
    private Long y; //Поле не может быть null
    @Getter
    @Setter
    private int z;

    /**
     * @param _x parameter for x coordinate
     * @param _y parameter for y coordinate
     */
    public Location(Integer _x, Long _y) {
        setX(_x);
        setY(_y);
    }


    /**
     * @param o the object to be compared.
     * @return compared info
     */
    @Override
    public int compareTo(Location o) {
        if (this == o) return 0;
        return Long.compare(x + y + z, o.x + o.y + o.z);
    }

    /**
     * @return text info about location
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}