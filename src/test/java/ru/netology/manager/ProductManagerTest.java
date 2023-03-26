package ru.netology.manager;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Book prod1 = new Book(1, "Name1", 500, "author1");
    Book prod2 = new Book(2, "Name2", 500, "author2");
    Smartphone prod3 = new Smartphone(3, "name3", 10_000, "China1");
    Smartphone prod4 = new Smartphone(4, "name4", 15_000, "China2");

    @Test
    public void searchByManufacturerTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        Product[] expected = { prod3 };
        Product[] actual = manager.searchBy("China1");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByAuthorTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        Product[] expected = { prod1, prod2 };
        Product[] actual = manager.searchBy("author");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNegativTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("any");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchByNameTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        Product[] expected = { prod1 };
        Product[] actual = manager.searchBy("Name1");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchManyProductTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        Product[] expected = { prod1, prod2 };
        Product[] actual = manager.searchBy("Name");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchAllProductTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        Product[] expected = { prod1, prod2, prod3, prod4 };
        Product[] actual = manager.searchBy("ame");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchProductNoResultTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Name5");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void AllProductTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        Product[] expected = { prod1, prod2, prod3, prod4 };
        Product[] actual = manager.AllProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    // на геттер
    @Test
    public void getRepositoryTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(prod1);
        manager.add(prod2);
        manager.add(prod3);
        manager.add(prod4);

        ProductRepository expected = repo;
        ProductRepository actual = manager.getRepo();

        Assertions.assertEquals(expected, actual);
    }
}