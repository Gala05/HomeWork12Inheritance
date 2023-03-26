package ru.netology.manager;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;


public class ProductManager {
    private ProductRepository repo;

    public ProductRepository getRepo() {
        return repo;
    }

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.saveProduct(product);
    }

    public Product[] AllProducts() {
        Product[] tmp = repo.findAll();
        return tmp;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product; // "добавляем в конец" массива result продукт product
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}