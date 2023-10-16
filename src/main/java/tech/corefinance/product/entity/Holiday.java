package tech.corefinance.product.entity;

import jakarta.persistence.*;
import lombok.Data;
import tech.corefinance.common.model.GenericModel;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "holiday")
public class Holiday implements GenericModel<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "holiday_date")
    private LocalDate holidayDate;
    @Column(name = "repeat_yearly")
    private boolean repeatYearly;
    private String description;
}
