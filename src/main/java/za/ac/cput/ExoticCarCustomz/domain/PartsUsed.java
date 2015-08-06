package za.ac.cput.ExoticCarCustomz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/07/29.
 */
@Entity
public class PartsUsed implements Parts, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String partNumber;
    private String description;
    private double price;

    public PartsUsed()
    {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getPartNumber() {
        return partNumber;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }



    public PartsUsed(Builder builder)
    {
        this.id=builder.id;
        this.partNumber=builder.partNumber;
        this.description=builder.description;
        this.price=builder.price;
    }

    public static class Builder
    {
        private Long id;
        private String partNumber;
        private String description;
        private double price;

        public Builder(String partNumber)
        {
            this.partNumber = partNumber;
        }

        public Builder description(String description)
        {
            this.description = description;
            return this;
        }

        public Builder price(double price)
        {
            this.price = price;
            return this;
        }


        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(PartsUsed partsUsed)
        {
            this.id = partsUsed.id;
            this.partNumber = partsUsed.partNumber;
            this.description = partsUsed.description;
            this.price = partsUsed.price;

            return this;
        }

        public PartsUsed build()
        {
            return new PartsUsed(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PartsUsed partsUsed = (PartsUsed) o;

        return id.equals(partsUsed.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Part Number: " + partNumber + "" + "Description: " + description;
    }

}

