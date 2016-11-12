package com.tomoab;

import java.util.Comparator;

/**
 * Simple product class.
 */
public class Product implements Comparable {

    // Comparator for cost
    public static final Comparator<Product> BY_COST = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) { return Integer.compare(o1.getCost(), o2.getCost()); }
    };

    // Comparator for cost
    public static final Comparator<Product> BY_WEIGHT = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) { return Integer.compare(o1.getWeight(), o2.getWeight()); }
    };

    // Comparator for name
    public static final Comparator<Product> BY_NAME = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            Product p1 = (Product) o1;
            Product p2 = (Product) o2;
//            return String.compare(o1.getName(), o2.getName());
            return p1.getName().compareTo(p2.getName());
        }
    };

    private final String name;
    private final int cost;
    private final int weight;

    public Product(String name, int cost, int weight) {
        this.name = name;
        this.cost = cost;
        this. weight = weight;
    }

    // getters/setters
    public String getName() { return name; }
    public int getCost() { return cost; }
    public int getWeight() { return weight; }

    @Override
    public String toString() {
        return "Product{name = '" + name + "\'" + ", cost = " + cost + ", weight = " + weight + "}";
    }

    @Override
    // need to override equals and hashCode to just compare the key fields
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (cost != product.cost) return false;
        if (weight != product.weight) return false;
        return name != null ? name.equals(product.name) : product.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + cost;
        result = 31 * result + weight;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        // Default is to sort by name
        Product p = (Product) o;
        return this.getName().compareTo(p.getName());

        // Could sort by cost
/*
        int delta = this.getCost() - p.getCost();
        return delta == 0 ? -1 : delta;
*/
    }
}
