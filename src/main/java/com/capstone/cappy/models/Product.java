package com.capstone.cappy.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter//makes setter $ getter for us
@Getter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;
    private String description;
    private String softCorporation;
    private String logoPath;
    private String hiResPhotoPath;
    private String apkPath;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (price != product.price) return false;
        if (size != product.size) return false;
        if (!id.equals(product.id)) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (softCorporation != null ? !softCorporation.equals(product.softCorporation) : product.softCorporation != null)
            return false;
        if (logoPath != null ? !logoPath.equals(product.logoPath) : product.logoPath != null) return false;
        if (hiResPhotoPath != null ? !hiResPhotoPath.equals(product.hiResPhotoPath) : product.hiResPhotoPath != null)
            return false;
        return apkPath != null ? apkPath.equals(product.apkPath) : product.apkPath == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (softCorporation != null ? softCorporation.hashCode() : 0);
        result = 31 * result + (logoPath != null ? logoPath.hashCode() : 0);
        result = 31 * result + (hiResPhotoPath != null ? hiResPhotoPath.hashCode() : 0);
        result = 31 * result + (apkPath != null ? apkPath.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }

    private int size;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", softCorporation='" + softCorporation + '\'' +
                ", logoPath='" + logoPath + '\'' +
                ", hiResPhotoPath='" + hiResPhotoPath + '\'' +
                ", apkPath='" + apkPath + '\'' +
                ", size=" + size +
                '}';
    }
}
