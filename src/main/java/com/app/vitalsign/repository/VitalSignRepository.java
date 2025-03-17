package com.app.vitalsign.repository;

import com.app.vitalsign.entity.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {
}
