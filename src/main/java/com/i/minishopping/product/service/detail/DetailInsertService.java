package com.i.minishopping.product.service.detail;

import com.i.minishopping.product.bean.detail.DetailDTO;
import com.i.minishopping.product.bean.product.ProductDTO;
import com.i.minishopping.product.dao.detail.DetailDAO;
import com.i.minishopping.product.service.product.ProductSelectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class DetailInsertService implements DetailService {
    private final DetailDTO detailDTO;
    private final DetailDAO detailDAO;
    private final ProductSelectService productSelectService;
    @Override
    public void execute() {
        System.out.print("입력할 상품의 id값을 입력해주세요!");
        Scanner sc = new Scanner(System.in);
        Long productId = sc.nextLong();
        ProductDTO productDTO = productSelectService.findById(productId);
        if(productDTO==null){
            System.out.println();
            System.out.println("없어요!!");
            return;
        }
        System.out.println();
        System.out.print("사이즈 입력 : ");
        String size = sc.next();
        System.out.print("입고수량 입력 : ");
        int pdBeforeCount = sc.nextInt();
        System.out.print("판매수량 입력 : ");
        int pdSellCount = sc.nextInt();

        detailDTO.setProductId(productId);
        detailDTO.setSize(size);
        detailDTO.setPdBeforeCount(pdBeforeCount);
        detailDTO.setPdSellCount(pdSellCount);


        detailDAO.writeDetail(detailDTO);

        System.out.println("데이터가 저장됐습니다.");
    }


}
