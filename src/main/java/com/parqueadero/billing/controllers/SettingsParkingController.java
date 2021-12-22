package com.parqueadero.billing.controllers;

import com.parqueadero.billing.models.SettingsParking;
import com.parqueadero.billing.repositories.SettingsParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SettingsParkingController {
    private final SettingsParkingRepository settingsParkingRepository;

    //endpoint to modify parking settings
    @GetMapping("/Settings")
    SettingsParking getActualSettings() {
        List<SettingsParking> settings=settingsParkingRepository.findAll();
        return settings.get(0);
    }
    @PostMapping("/Settings")
    SettingsParking updateSettings(@RequestBody SettingsParking settingsParking) {
        List<SettingsParking> settings=settingsParkingRepository.findAll();
        SettingsParking newSettingsParking;
        newSettingsParking=settings.get(0);

        newSettingsParking.setCapacity(settingsParking.getCapacity());
        newSettingsParking.setMinutePrice(settingsParking.getMinutePrice());
        settingsParkingRepository.save(newSettingsParking);
        return newSettingsParking;
    }
}
