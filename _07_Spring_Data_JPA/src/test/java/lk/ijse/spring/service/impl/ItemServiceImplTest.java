package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebRootConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class ItemServiceImplTest {
    @Autowired
    ItemService itemService;
    @Test
    void saveItem() {
        assertDoesNotThrow(() -> itemService.saveItem(new ItemDTO("I004", "Sofa", 100, new BigDecimal(200))) );

        assertThrows(RuntimeException.class, () -> itemService.saveItem(new ItemDTO("I001", "Sofa", 100, new BigDecimal(200))) );
    }

    @Test
    void updateItem() {
        assertDoesNotThrow(() -> itemService.updateItem(new ItemDTO("I001", "Sofa", 100, new BigDecimal(200))) );

        assertThrows(RuntimeException.class, () -> itemService.updateItem(new ItemDTO("I004", "Sofa", 100, new BigDecimal(200))) );
    }

    @Test
    void deleteItem() {
        assertDoesNotThrow(() -> itemService.deleteItem("I001") );

        assertThrows(RuntimeException.class, () -> itemService.deleteItem("I004") );
    }

    @Test
    void getAllItem() {
        assertTrue(itemService.getAllItem().size() > 0);

        assertFalse(itemService.getAllItem().isEmpty());
    }
}