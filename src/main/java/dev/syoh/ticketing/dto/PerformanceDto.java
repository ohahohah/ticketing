package dev.syoh.ticketing.dto;

import dev.syoh.ticketing.domain.Performance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PerformanceDto {
	private long id;
	private String name;

	public Performance toEntity() {
		return new Performance(id, name);
	}
}
