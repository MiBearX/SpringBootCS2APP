package com.csapp.inventory;
import jakarta.persistence.*;

@Entity
@Table(name = "skins")
public class Skin {
    @Id
    private Integer id;

    @Column(name = "gun_name", nullable = false)
    private String gunName;

    @Column(name = "skin_name", nullable = false)
    private String skinName;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "gun_type")
    private String gunType;

    @Column(name = "collection")
    private String collection;

    @Column(name = "image_url", length = 512)
    private String imageUrl;

    @Column(name = "price")
    private String price;

    @Column(name = "stattrak_price")
    private String stattrakPrice;

    public Integer getId() { return id; }
    public String getGunName() { return gunName; }
    public String getSkinName() { return skinName; }
    public String getRarity() { return rarity; }
    public String getGunType() { return gunType; }
    public String getCollection() { return collection; }
    public String getImageUrl() { return imageUrl; }
    public String getPrice() { return price; }
    public String getStattrakPrice() { return stattrakPrice; }
}
