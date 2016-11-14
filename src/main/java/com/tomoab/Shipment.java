package com.tomoab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * By implementing the Iterable interface, allows this object to be target of foreach loop.
 */
public class Shipment implements Iterable<Product> {

    private static final int EXPENSIVE_THRESHOLD = 40000;

    private List<Product> products = new ArrayList<>();
    private List<Product> cheapProducts;
    private List<Product> expensiveProducts;

    // getters
    public List<Product> getProducts() { return products; }
    public List<Product> getCheapProducts() { return cheapProducts; }
    public List<Product> getExpensiveProducts() { return expensiveProducts; }

    // add item to shipment
    public void add(Product product) { products.add(product); }

    // prepare shipment
    public void prepare() {
        int splitPoint = findSplitPoint();
        cheapProducts = products.subList(0, splitPoint);
        expensiveProducts = products.subList(splitPoint, products.size());
    }

    // sort and find index where product price at/beyond threshold
    private int findSplitPoint() {
        if (products.size() < 1) return 0;
        products.sort(Product.BY_COST);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCost() >= EXPENSIVE_THRESHOLD)
                return i;
        }
        return products.size() - 1;
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
