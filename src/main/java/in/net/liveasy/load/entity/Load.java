package in.net.liveasy.load.entity;


import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="logistics")
public class Load {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long shipperId;
	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private int weight;
	private String comment;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;
}
