package tech.corefinance.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.corefinance.common.annotation.ControllerManagedResource;
import tech.corefinance.common.controller.CrudServiceAndController;
import tech.corefinance.product.entity.LoanProduct;
import tech.corefinance.product.entity.Organization;
import tech.corefinance.product.repository.LoanProductRepository;
import tech.corefinance.product.repository.OrganizationRepository;

@RestController
@RequestMapping("organizations")
@ControllerManagedResource("organization")
public class OrganizationController implements CrudServiceAndController<String, Organization, Organization, OrganizationRepository> {

    @Autowired
    private OrganizationRepository repository;

    @Override
    public OrganizationRepository getRepository() {
        return repository;
    }
}
