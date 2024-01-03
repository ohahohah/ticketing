package dev.syoh.ticketing.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.*;

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
	public List<PerformanceDto> readAll() {
		Iterable<Performance> performances = performanceService.readAll();
		return StreamSupport.stream(performances.spliterator(), false)
			.map(Performance::convertToDto)
			.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public PerformanceDto readById(@PathVariable long id) {
		Performance performance = performanceService.readById(id).orElseThrow();
		return performance.convertToDto();
	}

	@PostMapping
	public PerformanceDto create(@RequestBody PerformanceDto performanceDto) {
		Performance createdPerformance = performanceService.create(performanceDto);
		return createdPerformance.convertToDto();
	}

	@PutMapping
	public PerformanceDto update(@RequestBody PerformanceDto performanceDto) {
		Performance updatedPerformance = performanceService.update(performanceDto);
		return updatedPerformance.convertToDto();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		performanceService.deletePerformance(id);
	}
}
