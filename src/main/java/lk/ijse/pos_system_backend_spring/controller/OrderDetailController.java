package lk.ijse.pos_system_backend_spring.controller;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDetailsDto;
import lk.ijse.pos_system_backend_spring.exception.OrderDetailNotFoundException;
import lk.ijse.pos_system_backend_spring.service.OrderDetailsService;
import lk.ijse.pos_system_backend_spring.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-details")
public class OrderDetailController {

    @Autowired
    private OrderDetailsService orderDetailService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrderDetail(@RequestBody OrderDetailsDto orderDetailDto) {
        try {
            orderDetailService.saveOrderDetail(orderDetailDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{orderDetailId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDetailsDto> getOrderDetailById(@PathVariable("orderDetailId") String orderDetailId) {
        if (!RegexUtil.isValidOrderDetailId(orderDetailId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            OrderDetailsDto orderDetailDto = orderDetailService.getOrderDetailById(orderDetailId);
            return new ResponseEntity<>(orderDetailDto, HttpStatus.OK);
        } catch (OrderDetailNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDetailsDto> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    @PutMapping(value = "/{orderDetailId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateOrderDetail(@PathVariable("orderDetailId") String orderDetailId, @RequestBody OrderDetailsDto orderDetailDto) {
        if (!RegexUtil.isValidOrderDetailId(orderDetailId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            orderDetailService.updateOrderdetail(orderDetailId, orderDetailDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderDetailNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{orderDetailId}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable("orderDetailId") String orderDetailId) {
        if (!RegexUtil.isValidOrderDetailId(orderDetailId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            orderDetailService.deleteOrderDetail(orderDetailId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderDetailNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
