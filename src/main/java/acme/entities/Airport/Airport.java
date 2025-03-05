
package acme.entities.Airport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import acme.constraints.ValidIATACode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airport extends AbstractEntity {

	// Serialisation version -------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes --------------------------------------------------------

	@Mandatory
	@NotBlank
	@ValidString(max = 50)
	@Automapped
	private String				name;

	@Mandatory
	@ValidIATACode
	@Column(unique = true)
	private String				IATACode;

	@Mandatory
	@Valid
	@Automapped
	private OperationalScope	operationalScope;

	@Mandatory
	@ValidString(max = 50)
	@NotBlank
	@Automapped
	private String				city;

	@Mandatory
	@ValidString(max = 50)
	@NotBlank
	@Automapped
	private String				country;

	@Optional
	@ValidUrl
	@Automapped
	private String				website;

	@Optional
	@ValidEmail
	@Automapped
	private String				emailAddress;

	@Optional
	@Pattern(regexp = "^\\+?\\d{6,15}$")
	private String				phoneNumber;
}
