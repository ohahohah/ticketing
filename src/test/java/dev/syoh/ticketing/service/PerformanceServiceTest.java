package dev.syoh.ticketing.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import dev.syoh.ticketing.domain.Performance;
import dev.syoh.ticketing.dto.PerformanceDto;
import dev.syoh.ticketing.repository.PerformanceRepository;

@SpringBootTest
public class PerformanceServiceTest {

	@Mock
	private PerformanceRepository performanceRepository;

	@InjectMocks
	private PerformanceService performanceService;

	@Test
	public void testReadAll() {
		// Given
		List<Performance> expectedPerformances = Arrays.asList(new Performance("Performance 1"), new Performance("Performance 2"));
		given(performanceRepository.findAll()).willReturn(expectedPerformances);

		// When
		List<Performance> actualPerformances = performanceService.readAll();

		// Then
		assertThat(actualPerformances).isEqualTo(expectedPerformances);
	}

	@Test
	public void testReadById() {
		// Given
		long id = 1L;
		Optional<Performance> expectedPerformance = Optional.of(new Performance("Performance 1"));
		given(performanceRepository.findById(id)).willReturn(expectedPerformance);

		// When
		Optional<Performance> actualPerformance = performanceService.readById(id);

		// Then
		assertThat(actualPerformance).isEqualTo(expectedPerformance);
	}

	@Test
	public void testCreate() {
		// Given
		PerformanceDto performanceDto = new PerformanceDto(0, "New Performance");
		Performance expectedPerformance = new Performance("New Performance");
		given(performanceRepository.save(any(Performance.class))).willReturn(expectedPerformance);

		// When
		Performance actualPerformance = performanceService.create(performanceDto);

		// Then
		assertThat(actualPerformance.readName()).isEqualTo(expectedPerformance.readName());
	}

	@Test
	public void testUpdate() {
		// Given
		PerformanceDto performanceDto = new PerformanceDto(1, "Updated Performance");
		Performance expectedPerformance = new Performance("Updated Performance");
		given(performanceRepository.save(any(Performance.class))).willReturn(expectedPerformance);

		// When
		Performance actualPerformance = performanceService.update(performanceDto.getId(), performanceDto);

		// Then
		assertThat(actualPerformance.readName()).isEqualTo(expectedPerformance.readName());
	}

	@Test
	public void testDeletePerformance() {
		// Given
		long id = 1L;
		doNothing().when(performanceRepository).deleteById(id);

		// When
		performanceService.deletePerformance(id);

		// Then
		verify(performanceRepository).deleteById(id);
	}
}
