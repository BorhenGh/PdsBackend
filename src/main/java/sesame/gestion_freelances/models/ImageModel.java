package sesame.gestion_freelances.models;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "image_model")
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;
    @Column(length = 50000000)
    private byte[] picByte;

    public ImageModel() {
        super();
    }

    public ImageModel(String name, String type, byte[] picByte) {
        super();
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    @Override
    public String toString() {
        return "ImageModel [id=" + id + ", name=" + name + ", type=" + type + ", picByte=" + Arrays.toString(picByte)
                + "]";
    }


}