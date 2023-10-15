package tech.corefinance.product.entity;

import jakarta.persistence.*;
import lombok.Data;
import tech.corefinance.common.model.GenericModel;
import tech.corefinance.product.enums.RateType;

import java.time.ZonedDateTime;

@Entity
@Table(name = "rate_source")
@Data
public class RateSource implements GenericModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String note;
    @Enumerated(EnumType.STRING)
    private RateType type;
}
