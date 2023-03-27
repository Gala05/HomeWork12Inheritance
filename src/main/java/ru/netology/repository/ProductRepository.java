package ru.netology.repository;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public ProductRepository() {
    }

    public Product[] getProducts() {
        return products;
    }

    public Product[] findAll() {
        Product[] all = getProducts();
        return all;
    }

    public void saveProduct(Product newProduct) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = newProduct;
        products = tmp;
    }

    public Product[] findById(int id) { // возвращает объект по идентификатору
        Product[] result = new Product[1];
        for (Product product : products) {
            if (product.getId() == id) {
                result = new Product[]{product};
                return result;
            }
        }
        return null;
    }
    public void removeById(int id) {

        if (this.findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}