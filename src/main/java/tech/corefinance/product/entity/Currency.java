package tech.corefinance.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import tech.corefinance.common.model.CreateUpdateDto;
import tech.corefinance.common.model.GenericModel;

@Data
@Table(name = "currency")
@Entity
public class Currency implements GenericModel<String>, CreateUpdateDto<String> {

    @Id
    private String id;
    private String name;
    private String symbol;
}
