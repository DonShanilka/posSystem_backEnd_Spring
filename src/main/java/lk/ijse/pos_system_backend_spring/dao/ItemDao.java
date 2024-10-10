package lk.ijse.pos_system_backend_spring.dao;

import lk.ijse.pos_system_backend_spring.entity.impl.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item,String> {
}
