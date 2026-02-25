package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.model.LabOrder;
import nimblix.in.HealthCareHub.response.LabOrderResponse;

public interface PatientService {

    // lab order service
    LabOrderResponse updateLabOrderStatus(Long id, String status);
    LabOrderResponse toOrderResponse(LabOrder order);
}
