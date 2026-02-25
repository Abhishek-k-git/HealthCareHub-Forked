package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;
import nimblix.in.HealthCareHub.response.LocationResponse;
import nimblix.in.HealthCareHub.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping("/hospital/register")
    public String registerHospital(@RequestBody HospitalRegistrationRequest request) {
        return hospitalService.registerHospital(request);
    }

    @GetMapping("/locations")
    public ResponseEntity<List<LocationResponse>> getLocations() {
        return ResponseEntity.status(200).body(hospitalService.getDistinctLocations());
    }
    
}
