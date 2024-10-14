package lk.ijse.pos_system_backend_spring.util;


import lk.ijse.pos_system_backend_spring.dto.custom.impl.*;
import lk.ijse.pos_system_backend_spring.entity.impl.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //Customer DTO, Entity & List of Customers
    public Customer toCustomerEntity(CustomerDto dto){
        return modelMapper.map(dto, Customer.class);
    }

    public CustomerDto toCustomerDto(Customer customer){
        return modelMapper.map(customer, CustomerDto.class);
    }

    public List<CustomerDto> asCustomerDto(List<Customer> customerList){
        return modelMapper.map(customerList, new TypeToken<List<CustomerDto>>() {}.getType());
    }

    //User DTO, Entity & List of Users
    public User toUserEntity(UserDto dto) {
        return modelMapper.map(dto, User.class);
    }

    public UserDto toUserDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> asUserDto(List<User> userList) {
        return modelMapper.map(userList, new TypeToken<List<UserDto>>() {}.getType());
    }

    //Item DTO, Entity & List of Items
    public Item toItemEntity(ItemDto dto){
        return modelMapper.map(dto, Item.class);
    }

    public ItemDto toItemDto(Item item){
        return modelMapper.map(item, ItemDto.class);
    }

    public List<ItemDto> asItemDto(List<Item> itemList) {
        return modelMapper.map(itemList, new TypeToken<List<ItemDto>>() {}.getType());
    }

    //Order DTO, Entity & List of Orders
    public Order toOrderEntity(OrderDto dto){
        return modelMapper.map(dto, Order.class);
    }

    public OrderDto toOrderDto(Order order){
        return modelMapper.map(order, OrderDto.class);
    }

    public List<OrderDto> asOrderDto(List<Order> orderList){
        return modelMapper.map(orderList, new TypeToken<List<OrderDto>>() {}.getType());
    }

    //Order Details DTO, Entity & List of Order Details
    public OrderDetail toOrderDetailEntity(OrderDetailsDto dto){
        return modelMapper.map(dto, OrderDetail.class);
    }

    public OrderDetailsDto toOrderDetailDto(OrderDetail orderDetail){
        return modelMapper.map(orderDetail, OrderDetailsDto.class);
    }

    public List<OrderDetailsDto> asOrderDetailDto(List<OrderDetail> orderDetailList){
        return modelMapper.map(orderDetailList, new TypeToken<List<OrderDetail>>() {}.getType());
    }
}
