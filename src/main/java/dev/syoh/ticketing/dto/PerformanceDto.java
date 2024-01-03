package dev.syoh.ticketing.dto;

import dev.syoh.ticketing.domain.Performance;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PerformanceDto {
	private long id;
	private String name;

	public PerformanceDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Performance toEntity() {
		return new Performance(name);
	}
}
