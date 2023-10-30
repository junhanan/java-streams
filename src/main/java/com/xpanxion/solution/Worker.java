package com.xpanxion.solution;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.HashMap;

import com.xpanxion.java.assignments.DataAccess;
import com.xpanxion.java.assignments.model.Department;
import com.xpanxion.java.assignments.model.Product;

public class Worker {
    public List<Product> getProductWithDepartmentNames() {
        // getting the list of products and departments
        List<Product> products = DataAccess.getProducts();
        List<Department> departments = DataAccess.getDepartments();

        // creating a map of departmentId to departmentName
        // stream method, converts the list of departments into a stream, 
        // which allows for processing the elements in a functional and efficient way.
        // var departmentMap = departments.stream()
        //         .collect(Collectors.toMap(Department::getId, Department::getName));
        Map<Integer, String> departmentMap = new HashMap<>();
        for (Department department : departments) {
            departmentMap.put(department.getId(), department.getName());
        }
        // Create a list to store products with department names
        List<Product> productsWithDepartmentNames = new ArrayList<>();

        // now using loop to add department names to products
        for (Product product : products){
            String departmentName = departmentMap.get(product.getDepartmentId());
            if (departmentName != null) {
                Product productWithDeptName= new Product(
                    product.getId(),
                    product.getDepartmentId(),
                    departmentName,
                    product.getName(),
                    product.getPrice(),
                    product.getSku()
                );
                productsWithDepartmentNames.add(productWithDeptName);
            }
        }
        return productsWithDepartmentNames;
    }
}
