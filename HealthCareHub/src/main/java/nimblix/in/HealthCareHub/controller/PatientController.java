package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.constants.HealthCareConstants;
import nimblix.in.HealthCareHub.response.LabOrderResponse;
import nimblix.in.HealthCareHub.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class PatientController {
    @Autowired
    private PatientService patientService;

    // lab order controller
    @PutMapping("lab-orders/{id}/status")
    public ResponseEntity<LabOrderResponse> updateLabOrderStatus(
            @PathVariable Long id,
            @RequestBody String status
    ) {
        if (id == null ) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        if (status == null || (!HealthCareConstants.PENDING.equals(status) &&
                !HealthCareConstants.COMPLETED.equals(status))) {
            throw new IllegalArgumentException("Invalid lab order status");
        }
        LabOrderResponse updatedOrderResponse = patientService.updateLabOrderStatus(id, status);
        return ResponseEntity.ok(updatedOrderResponse);
    }
}
