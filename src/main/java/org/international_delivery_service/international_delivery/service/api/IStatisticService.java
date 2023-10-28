package org.international_delivery_service.international_delivery.service.api;

import org.international_delivery_service.international_delivery.core.dto.base.DepartmentStatisticDTO;
import org.international_delivery_service.international_delivery.core.dto.base.PackageStatisticDTO;

public interface IStatisticService {
    DepartmentStatisticDTO getDepartmentStatistic(String department);
    PackageStatisticDTO getPackageStatists();
}
