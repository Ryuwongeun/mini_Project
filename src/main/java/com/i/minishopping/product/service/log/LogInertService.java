package com.i.minishopping.product.service.log;

import com.i.minishopping.product.bean.log.LogDTO;
import com.i.minishopping.product.dao.log.LogDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class LogInertService implements LogService {
    private final LogDTO logDTO;
    private final LogDAO logDAO;

    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        Long productId = 11L;
        String size = "1";
        System.out.print("수량 : ");
        int count = sc.nextInt();
        Long createdWho = 1L;

        logDTO.setProductId(productId);
        logDTO.setSize(size);
        logDTO.setCount(count);
        logDTO.setCreatedWho(createdWho);

        logDAO.writeLog(logDTO);

        System.out.println("데이터가 저장됐습니다.");
    }
}
