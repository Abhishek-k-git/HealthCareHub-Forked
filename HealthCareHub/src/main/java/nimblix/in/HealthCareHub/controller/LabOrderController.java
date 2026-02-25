package nimblix.in.HealthCareHub.controller;

import nimblix.in.HealthCareHub.model.LabOrderStatus;
import nimblix.in.HealthCareHub.response.LabOrderResponse;
import nimblix.in.HealthCareHub.service.LabOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lab-orders")
public class LabOrderController {
    @Autowired
    private LabOrderService labOrderService;

    @PutMapping("/{id}/status")
    public ResponseEntity<LabOrderResponse> updateLabOrderStatus(
            @PathVariable Long id,
            @RequestBody LabOrderStatus status
    ) {
        if (id == null || status == null) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        LabOrderResponse updatedOrderResponse = labOrderService.updateLabOrderStatus(id, status);
        return ResponseEntity.ok(updatedOrderResponse);
    }
}
