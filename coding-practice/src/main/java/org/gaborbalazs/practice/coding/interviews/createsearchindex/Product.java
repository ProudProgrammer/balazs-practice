package org.gaborbalazs.practice.coding.interviews.createsearchindex;

import java.util.Objects;

public class Product {

    private int id;
    private String name;
    private int score;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && score == product.score && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, score);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
