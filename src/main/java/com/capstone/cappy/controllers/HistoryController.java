package com.capstone.cappy.controllers;

import com.capstone.cappy.auth.UserDetailsImpl;
import com.capstone.cappy.models.History;
import com.capstone.cappy.models.Product;
import com.capstone.cappy.models.User;
import com.capstone.cappy.service.HistoryService;
import com.capstone.cappy.service.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

@Controller
public class HistoryController {
    private final ProductService productService;
    private final HistoryService historyService;

    public HistoryController(ProductService productService,
                             HistoryService historyService) {
        this.productService = productService;
        this.historyService = historyService;
    }


    @GetMapping("/download/{productId}")
    public String downloadFIle(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long productId, HttpServletResponse response) throws IOException {
        if (userDetails == null) {
            return "redirect:/login";
        }

        Product product = productService.getProductById(productId);

        String apk_path = product.getApkPath();
        apk_path = apk_path.replace('\\', '/');
        System.out.println(apk_path);
        File file = new File(apk_path);
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename = " + file.getName();
        response.setHeader(headerKey,headerValue);
        ServletOutputStream outputStream = response.getOutputStream();
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        byte[] buffer = new byte[250*1024*1024];//max apk size = 215mb
        int bytesRead = -1;

        while((bytesRead = inputStream.read(buffer))!=-1)
        {
            outputStream.write(buffer,0,bytesRead);
        }
        inputStream.close();
        outputStream.close();

        User user = userDetails.getUser();
        History history = new History(
                user.getId(),
                product.getId(),
                java.sql.Date.valueOf(
                        new SimpleDateFormat("yyyy-MM-dd").format(GregorianCalendar.getInstance().getTime())));


        historyService.save(history);

        return "redirect:/product";
    }


}
