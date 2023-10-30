package com.xpanxion.java.assignments;

import java.util.List;

import com.xpanxion.java.assignments.model.Product;
import com.xpanxion.solution.Worker;

public class Main {

    public static void main(String[] args) {
        Worker justALowlyWorker = new Worker();
        List<Product> productsWithDepartmentNames = justALowlyWorker.getProductWithDepartmentNames();

        // Testing exercise 1
        for (Product product : productsWithDepartmentNames) {
            System.out.println(product);
        }
    }
}
