package lk.ijse.pos_system_backend_spring.controller;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDto;
import lk.ijse.pos_system_backend_spring.exception.OrderNotFoundException;
import lk.ijse.pos_system_backend_spring.service.OrderService;
import lk.ijse.pos_system_backend_spring.util.RegexUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDto orderDto) {
        try {
            orderService.saveOrder(orderDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("orderId") String orderId) {
        if (!RegexUtil.isValidOrderId(orderId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            OrderDto orderDto = orderService.getOrderById(orderId);
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping(value = "/{orderId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateOrder(@PathVariable("orderId") String orderId, @RequestBody OrderDto orderDto) {
        if (!RegexUtil.isValidOrderId(orderId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            orderService.updateOrder(orderId, orderDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") String orderId) {
        if (!RegexUtil.isValidOrderId(orderId)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
