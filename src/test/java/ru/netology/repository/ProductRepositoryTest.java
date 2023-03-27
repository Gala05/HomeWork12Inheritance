package ru.netology.repository;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Book prod1 = new Book(1, "Name1", 500, "author1");
    Book prod2 = new Book(2, "Name2", 500, "author2");
    Smartphone prod3 = new Smartphone(3, "name3", 10_000, "China1");
    Smartphone prod4 = new Smartphone(4, "name4", 15_000, "China2");
    @Test
    public void allProductsTest(){
        ProductRepository repo = new ProductRepository();
        repo.saveProduct(prod1);
        repo.saveProduct(prod2);
        repo.saveProduct(prod3);
        repo.saveProduct(prod4);

        Product[] expected = { prod1, prod2, prod3, prod4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void saveProductsTest(){
        ProductRepository repo = new ProductRepository();
        repo.saveProduct(prod1);

        Product[] expected = { prod1 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductByIdTest(){
        ProductRepository repo = new ProductRepository();
        repo.saveProduct(prod1);
        repo.saveProduct(prod2);
        repo.saveProduct(prod3);
        repo.saveProduct(prod4);
        repo.removeById(2);

        Product[] expected = { prod1, prod3, prod4 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonIdTest(){
        ProductRepository repo = new ProductRepository();
        repo.saveProduct(prod1);
        repo.saveProduct(prod2);
        repo.saveProduct(prod3);
        repo.saveProduct(prod4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }
    // тесты на сеттеры, на геттеры
    @Test
    public void getProductTest() {
        Product product = new Product(1,"book", 100);
        Assertions.assertEquals(1, product.getId());
        Assertions.assertEquals("book", product.getName());
        Assertions.assertEquals(100, product.getAmount());
    }
    @Test
    public void getBookTest() {
        Book book = new Book(1,"book", 100, "Author1");
        Assertions.assertEquals(1, book.getId());
        Assertions.assertEquals("book", book.getName());
        Assertions.assertEquals(100, book.getAmount());
        Assertions.assertEquals("Author1", book.getAuthor());
    }
    @Test
    public void getSmartphoneTest() {
        Smartphone smartphone = new Smartphone(1,"Phone1", 10_000, "Manufacturer1");
        Assertions.assertEquals(1, smartphone.getId());
        Assertions.assertEquals("Phone1", smartphone.getName());
        Assertions.assertEquals(10_000, smartphone.getAmount());
        Assertions.assertEquals("Manufacturer1", smartphone.getManufacturer());
    }
    @Test
    public void findByIdNegativTest() {
        ProductRepository repo = new ProductRepository();
        repo.saveProduct(prod1);
        repo.saveProduct(prod2);
        repo.saveProduct(prod3);
        repo.saveProduct(prod4);

        Product[] expected = null;
        Product[] actual = repo.findById(5);

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void findByIdTest() {
        ProductRepository repo = new ProductRepository();
        repo.saveProduct(prod1);
        repo.saveProduct(prod2);
        repo.saveProduct(prod3);
        repo.saveProduct(prod4);

        Product[] expected = {prod4};
        Product[] actual = repo.findById(4);

        Assertions.assertArrayEquals(expected, actual);
    }
}