package dev.syoh.ticketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.syoh.ticketing.domain.Performance;
import dev.syoh.ticketing.dto.PerformanceDto;
import dev.syoh.ticketing.repository.PerformanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerformanceService {

	private final PerformanceRepository performanceRepository;

	public List<Performance> readAll() {
		return performanceRepository.findAll();
	}

	public Optional<Performance> readById(long id) {
		return performanceRepository.findById(id);
	}

	public Performance create(PerformanceDto performanceDto) {
		return performanceRepository.save(performanceDto.toEntity());
	}

	public Performance update(PerformanceDto performanceDto) {
		Performance performance = new Performance(performanceDto.getName());
		return  performanceRepository.save(performance);
	}

	public void deletePerformance(long id) {
		performanceRepository.deleteById(id);
	}
}
