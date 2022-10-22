package com.capstone.cappy.service;

import com.capstone.cappy.entities.Product;
import com.capstone.cappy.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.getReferenceById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findTop6() {
        return productRepository.findTop6ByOrderById();//implements automatically
    }

    public List<Product> search(String keyword) {
        return productRepository.findAllByNameContainsIgnoreCase(keyword);
    }

    public void downloadProduct(Long productId, HttpServletResponse response) throws IOException {

        Product product = productRepository.getReferenceById(productId);

        String apk_path = product.getApkPath();
        apk_path = apk_path.replace('\\', '/');//coz windows is odd;)
        System.out.println(apk_path);
        File file = new File(apk_path);
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename = " + file.getName();
        response.setHeader(headerKey, headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[250 * 1024 * 1024];//max apk size = 215mb
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }

}
