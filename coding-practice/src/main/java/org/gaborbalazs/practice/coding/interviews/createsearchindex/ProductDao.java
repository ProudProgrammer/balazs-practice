package org.gaborbalazs.practice.coding.interviews.createsearchindex;

import java.util.List;

public class ProductDao {

    public List<Product> getAllProducts() {
        return List.of(new Product(1, "Amul milk"),
                new Product(2, "Nandini Chocolate Milk"),
                new Product(3, "Milk Chocolate"),
                new Product(4, "Chocolate Milk"),
                new Product(5, "Milky Way Chocolate Bar"));
    }
}
