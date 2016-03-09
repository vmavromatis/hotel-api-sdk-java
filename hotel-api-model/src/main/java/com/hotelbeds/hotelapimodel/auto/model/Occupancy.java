/**
 * Autogenerated code by SdkModelGenerator.
 * Do not edit. Any modification on this file will be removed automatically after project build
 *
 */
package com.hotelbeds.hotelapimodel.auto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hotelbeds.hotelapimodel.auto.model.Pax;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@ToString
@NoArgsConstructor
@Data
public class Occupancy {

	@NotNull
	@Min(value = 1)
	private Integer rooms;
	@NotNull
	@Min(value = 1)
	private Integer adults;
	@NotNull
	@Min(value = 0)
	private Integer children;
	@Valid
	private List<Pax> paxes;


}