package com.diplom.example;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.diplom.example");

        noClasses()
            .that()
            .resideInAnyPackage("com.diplom.example.service..")
            .or()
            .resideInAnyPackage("com.diplom.example.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.diplom.example.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
