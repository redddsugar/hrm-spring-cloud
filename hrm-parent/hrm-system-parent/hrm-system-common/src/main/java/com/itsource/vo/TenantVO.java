package com.itsource.vo;

import com.itsource.domain.Employee;
import com.itsource.domain.Tenant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TenantVO {
    Employee employee;
    Long mealId;
    Tenant tenant;
}
