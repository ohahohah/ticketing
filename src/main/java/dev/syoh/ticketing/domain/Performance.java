package dev.syoh.ticketing.domain;

import dev.syoh.ticketing.dto.PerformanceDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Performance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	public Performance(String name) {
		this.name = name;
	}

	public void changeName(String name) {
		this.name = name;
	}

	public PerformanceDto convertToDto() {
		return new PerformanceDto(this.name);
	}


}

