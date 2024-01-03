package dev.syoh.ticketing.dto;

import dev.syoh.ticketing.domain.Performance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter  // for testing
@AllArgsConstructor // for testing
@NoArgsConstructor
public class PerformanceDto {
	private long id;
	private String name;

	public PerformanceDto(String name) {
		this.name = name;
	}

	public Performance toEntity() {
		return new Performance(name);
	}

	public void setId(long id) {
		this.id = id;
	}
}
