package dev.syoh.ticketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.syoh.ticketing.domain.Performance;
import dev.syoh.ticketing.dto.PerformanceDto;
import dev.syoh.ticketing.repository.PerformanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformanceService {

	private final PerformanceRepository performanceRepository;

	public List<Performance> retrieveAllPerformances() {
		return performanceRepository.findAll();
	}

	public Optional<Performance> retrievePerformanceById(long id) {
		return performanceRepository.findById(id);
	}

	public Performance postPerformance(PerformanceDto performanceDto) {
		return performanceRepository.save(performanceDto.toEntity());
	}

	public ResponseEntity<Performance> putPerformance(long id, PerformanceDto performanceDto) {
		if (performanceRepository.existsById(id)) {
			Performance existingPerformance = performanceRepository.findById(id).orElse(null);
			if (existingPerformance != null) {
				existingPerformance.setName(performanceDto.getName());
				return new ResponseEntity<>(performanceRepository.save(existingPerformance), HttpStatus.OK);
			}
		} else {
			performanceDto.setId(id);
			return new ResponseEntity<>(performanceRepository.save(performanceDto.toEntity()), HttpStatus.CREATED);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public void deletePerformance(long id) {
		performanceRepository.deleteById(id);
	}
}
