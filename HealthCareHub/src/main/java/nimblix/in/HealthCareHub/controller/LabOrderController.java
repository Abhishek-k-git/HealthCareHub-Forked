package nimblix.in.HealthCareHub.controller;

import jakarta.validation.Valid;
import nimblix.in.HealthCareHub.model.LabOrder;
import nimblix.in.HealthCareHub.request.LabOrderRequest;
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
            @Valid @RequestBody LabOrderRequest request
    ) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid lab order ID");
        }
        LabOrderResponse updatedOrderResponse = labOrderService.updateLabOrderStatus(id, request.getStatus());
        return ResponseEntity.ok(updatedOrderResponse);
    }
}
