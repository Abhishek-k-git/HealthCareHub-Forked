package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.model.LabOrder;
import nimblix.in.HealthCareHub.model.LabOrderStatus;
import nimblix.in.HealthCareHub.response.LabOrderResponse;

public interface LabOrderService {
    LabOrderResponse updateLabOrderStatus(Long id, LabOrderStatus status);
    LabOrderResponse toOrderResponse(LabOrder order);
}