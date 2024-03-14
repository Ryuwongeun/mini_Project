package com.i.minishopping.product.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.i.minishopping.product.bean.product.ProductDTO;
import com.i.minishopping.product.dao.product.ProductDAO;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class ProductInsertService implements ProductService {
    private final ProductDTO productDTO;
    private final ProductDAO productDAO;
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("제품명 입력 : ");
        String pd_name = sc.next();
        System.out.print("가격 입력 : ");
        int pd_price = sc.nextInt();
        Long brand_id = 1L;
        System.out.print("카테고리 입력 : ");
        String pd_category = sc.next();
        Long created_who = 1L;

        productDTO.setPdName(pd_name);
        productDTO.setPdPrice(pd_price);
        productDTO.setBrandId(brand_id);
        productDTO.setPdCategory(pd_category);
        productDTO.setCreatedWho(created_who);

        productDAO.write(productDTO);

        System.out.println("데이터가 저장됐습니다.");
    }
}
