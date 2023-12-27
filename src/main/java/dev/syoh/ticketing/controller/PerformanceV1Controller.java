package dev.syoh.ticketing.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.syoh.ticketing.domain.Performance;
import dev.syoh.ticketing.dto.PerformanceDto;
import dev.syoh.ticketing.service.PerformanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/performances")
public class PerformanceV1Controller {

	private final PerformanceService performanceService;

	@GetMapping
	public Iterable<Performance> retrieveAllPerformances() {
		return performanceService.retrieveAllPerformances();
	}

	@GetMapping("/{id}")
	public Optional<Performance> retrievePerformanceById(@PathVariable long id) {
		return performanceService.retrievePerformanceById(id);
	}

	@PostMapping
	public Performance postPerformance(@RequestBody PerformanceDto performanceDto) {
		return performanceService.postPerformance(performanceDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Performance> putPerformance(@PathVariable long id, @RequestBody PerformanceDto performanceDto) {
		return performanceService.putPerformance(id, performanceDto);
	}

	@DeleteMapping("/{id}")
	public void deletePerformance(@PathVariable long id) {
		performanceService.deletePerformance(id);
	}

}
