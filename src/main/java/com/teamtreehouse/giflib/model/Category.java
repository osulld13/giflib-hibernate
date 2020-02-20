package com.teamtreehouse.giflib.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "valuerequired")
    @Size(min = 3, max = 12, message = "{category.name.size}")
    private String name;

    @NotNull(message = "{valuerequired}")
    @Pattern(regexp = "#[0-9a-fA-F]{6}", message = "{category.colorcode.format}")
    private String colorCode;

    @OneToMany(mappedBy = "category")
    private List<Gif> gifs = new ArrayList<>();

    public Category(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public List<Gif> getGifs() {
        return gifs;
    }

}
